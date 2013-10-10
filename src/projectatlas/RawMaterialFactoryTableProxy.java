/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cosmox Software Developers
 */
public class RawMaterialFactoryTableProxy implements TableProxy{

    private Connection connection;
    private String tableName="rawmaterial_fac";
    private Statement stmt=null;
    
    private static RawMaterialFactoryTableProxy instance=null;
    
    private RawMaterialFactoryTableProxy()
    {
        connection=DatabaseConnection.getDatabaseConnection().getConnection();  //retrieves the connection to the database from singleton DatabaseConnection object
        
    }
    
    public static RawMaterialFactoryTableProxy getRawMaterialFactoryTableProxy()
    {
        if(instance==null)
        {
            instance=new RawMaterialFactoryTableProxy();
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
            ResultSet results=stmt.executeQuery("SELECT * from "+tableName+" where batch_number="+id);
            if(results.next())
            {
                return new RawMaterialFactory(results.getInt(1),results.getInt(2),results.getString(3),results.getInt(4));
            }
            else
                return null;
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialFactoryTableProxy.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public boolean add(Object obj) {
        try {
            RawMaterialFactory rm=(RawMaterialFactory)obj;
            stmt=connection.createStatement();
            ResultSet results=stmt.executeQuery("SELECT * from "+tableName+" where batch_number="+rm.getBatchNumber());
            RawMaterialTypeInfoTableProxy proxy=RawMaterialTypeInfoTableProxy.getRawMaterialTypeInfoTableProxy();
            RawMaterialTypeInfoTableProxy.TypeInfo typeInfo=(RawMaterialTypeInfoTableProxy.TypeInfo)proxy.get(rm.getType());
            if(results.next())
            {
                stmt=connection.createStatement();
                typeInfo.setTotalAmount(typeInfo.getTotalAmount()+rm.getBatchAmount()-results.getInt(2));
                typeInfo.setType(rm.getType());
                typeInfo.setUnitPrice(rm.getUnitPrice());
                proxy.add(typeInfo);
                stmt.executeUpdate("UPDATE "+tableName+"SET batch_amount="+rm.getBatchAmount()+",type='"+rm.getType()+"',unit_price="+rm.getUnitPrice()+" where batch_number="+rm.getBatchNumber());
                stmt.close();
                return true;
            }
            else
            {
                stmt=connection.createStatement();
               // results=stmt.executeQuery("SELECT * from "+tableName+"where type='"+rm.getType()+"'");
                stmt.executeUpdate("INSERT INTO "+tableName+" VALUES("+rm.getBatchNumber()+","+rm.getBatchAmount()+",'"+rm.getType()+"',"+rm.getUnitPrice()+")");
                stmt.close();
                if(typeInfo==null)
                {
                    typeInfo=new RawMaterialTypeInfoTableProxy.TypeInfo(rm.getType(),rm.getUnitPrice(),rm.getBatchAmount());
                    proxy.add(typeInfo);
                }
                else
                {
                    typeInfo.setUnitPrice(rm.getUnitPrice());
                    typeInfo.setTotalAmount(typeInfo.getTotalAmount()+rm.getBatchAmount());
                    proxy.add(typeInfo);
                }
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialFactoryTableProxy.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }

    @Override
    public boolean update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public boolean deleteBatch(String type,int batch)
    {
        try {
            stmt=connection.createStatement();
            ResultSet results1=stmt.executeQuery("SELECT * from "+tableName+" where batch="+batch);
            RawMaterialTypeInfoTableProxy proxy=RawMaterialTypeInfoTableProxy.getRawMaterialTypeInfoTableProxy();
            RawMaterialTypeInfoTableProxy.TypeInfo typeInfo=(RawMaterialTypeInfoTableProxy.TypeInfo)proxy.get(type);
            typeInfo.setTotalAmount(typeInfo.getTotalAmount()-results1.getInt(2));
            proxy.add(typeInfo);
            stmt.executeUpdate("DELETE from "+tableName+"where batch="+batch);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialFactoryTableProxy.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public ResultSet getTypeOrderByBatchNumber(String type)
    {
        try {
            /*returns a resultset containing the data where type equals the given  
             *type and sorted according to batch number. 
             */
            stmt=connection.createStatement();
            ResultSet results=stmt.executeQuery("select * from "+tableName+" where type='"+type+"' order by batch_number");
            return results;
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialOrderTableProxy.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
