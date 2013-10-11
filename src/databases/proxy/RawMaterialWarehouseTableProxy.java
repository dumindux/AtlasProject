/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databases.proxy;

import databases.connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import projectatlas.RawMaterialWarehouse;

/**
 *
 * @author Cosmox Software Developers
 */
public class RawMaterialWarehouseTableProxy implements TableProxy{

    private Connection connection;
    private String tableName="rawmaterial_ware";
    private Statement stmt=null;
    
    private static RawMaterialWarehouseTableProxy instance=null;
    
    private RawMaterialWarehouseTableProxy()
    {
        connection=DatabaseConnection.getDatabaseConnection().getConnection();  //retrieves the connection to the database from singleton DatabaseConnection object
        
    }
    
    public static RawMaterialWarehouseTableProxy getRawMaterialWarehouseTableProxy()
    {
        if(instance==null)
        {
            instance=new RawMaterialWarehouseTableProxy();
            return instance;
        }
        else
            return instance;
    }
    @Override
    public Object get(String ID) {
        try {
            int id=Integer.parseInt(ID);
            stmt=connection.createStatement();
            ResultSet results=stmt.executeQuery("SELECT * from "+tableName+" where batch_number_warehouse="+id);
            if(results.next())
            {
                return new RawMaterialWarehouse(results.getInt(4),results.getInt(2),results.getInt(3),results.getString(1),results.getInt(5));
            }
            else
                return null;
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialWarehouseTableProxy.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public boolean add(Object obj) {
        /*
         * Has to update the raw_material_type_info_warehouse table
         * this adds or updates a rawMaterial batch in the database
         * this also modifies the raw_material_type_info_warehouse table
         */
        try{
            RawMaterialWarehouse rm=(RawMaterialWarehouse)obj;
            RawMaterialTypeInfoWarehouseTableProxy proxy=RawMaterialTypeInfoWarehouseTableProxy.getRawMaterialTypeInfoWarehouseTableProxy();
            RawMaterialTypeInfoWarehouseTableProxy.TypeInfo typeInfo=(RawMaterialTypeInfoWarehouseTableProxy.TypeInfo)proxy.get(rm.getType());
            if(rm.getBatchNumber()!=-1)
            {
                stmt=connection.createStatement();
                ResultSet results1=stmt.executeQuery("SELECT * from "+tableName+" where batch_number_warehouse="+rm.getBatchNumber());
                if(results1.next())
                {
                    //stmt.close();
                    typeInfo.setTotalAmount(typeInfo.getTotalAmount()+rm.getAvailAmount()+rm.getResAmount()-results1.getInt(2)-results1.getInt(3));
                    System.out.println(typeInfo.getTotalAmount()+" "+rm.getAvailAmount()+" "+rm.getResAmount()+" "+results1.getInt(2)+" "+results1.getInt(3));
                    typeInfo.setTotalAvaillable(typeInfo.getTotalAvaillable()+rm.getAvailAmount()-results1.getInt(3));
                    System.out.println(typeInfo.getTotalAvaillable()+" "+rm.getAvailAmount()+" "+results1.getInt(3));
                    typeInfo.setUnitPrice(rm.getUnitPrice());
                    proxy.add(typeInfo);
                    stmt=connection.createStatement();
                    stmt.executeUpdate("UPDATE "+tableName+" SET res_amount="+rm.getResAmount()+",avail_amount="+rm.getAvailAmount()+",unit_price="+rm.getUnitPrice()+" where batch_number_warehouse="+rm.getBatchNumber()+"");
                    stmt.close();
                    return true;
                }
                else
                {
                    System.out.println("Error");
                    return false;
                }
            }
            stmt=connection.createStatement();
            ResultSet results=stmt.executeQuery("SELECT MAX(batch_number_warehouse) from "+tableName);
            int nextNum;
            if(results.next())
            {
                nextNum=results.getInt(1)+1;
            }
            else
            {
                nextNum=1;
            }
            stmt.executeUpdate("INSERT INTO "+tableName+" VALUES('"+rm.getType()+"',"+rm.getResAmount()+","+rm.getAvailAmount()+","+nextNum+","+rm.getUnitPrice()+")");
            stmt.close();
            
            if(typeInfo==null)
            {
                typeInfo=new RawMaterialTypeInfoWarehouseTableProxy.TypeInfo(rm.getType(),rm.getUnitPrice(),rm.getAvailAmount()+rm.getResAmount(),rm.getAvailAmount());
                proxy.add(typeInfo);
            }
            else
            {
                typeInfo.setTotalAmount(typeInfo.getTotalAmount()+rm.getAvailAmount()+rm.getResAmount());
                typeInfo.setTotalAvaillable(typeInfo.getTotalAvaillable()+rm.getAvailAmount());
                typeInfo.setUnitPrice(rm.getUnitPrice());
                proxy.add(typeInfo);
            }
            return true;
                 
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public ResultSet getTypeOrderByBatchNumber(String type)
    {
        try {
            /*returns a resultset containing the data where type equals the given  
             *type and sorted according to batch number. 
             */
            stmt=connection.createStatement();
            ResultSet results=stmt.executeQuery("select * from "+tableName+" where type='"+type+"' order by batch_number_warehouse");
            return results;
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialOrderTableProxy.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
