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
public class RawMaterialTypeInfoTableProxy implements TableProxy{
    private Connection connection;
    private String tableName="rawmaterial_type_info";
    private Statement stmt=null;
    
    private static RawMaterialTypeInfoTableProxy instance=null;
    
    private RawMaterialTypeInfoTableProxy()
    {
        connection=DatabaseConnection.getDatabaseConnection().getConnection();  //retrieves the connection to the database from singleton DatabaseConnection object
        
    }
    
    public static RawMaterialTypeInfoTableProxy getRawMaterialTypeInfoTableProxy()
    {
        if(instance==null)
        {
            instance=new RawMaterialTypeInfoTableProxy();
            return instance;
        }
        else
            return instance;
    }
    @Override
    public Object get(String ID) {
        try{
            stmt=connection.createStatement();
            ResultSet results=stmt.executeQuery("SELECT * from rawmaterial_type_info where type='"+ID+"'");
            if(results.next())
                return new TypeInfo(ID,results.getInt(2),results.getInt(3));
            else
                return null;
        }
        catch(Exception e)
        {
            return null;
        }
    }

    @Override
    public boolean add(Object obj) {
         try{
            RawMaterialTypeInfoTableProxy.TypeInfo fp=(RawMaterialTypeInfoTableProxy.TypeInfo)obj;
            stmt=connection.createStatement();
            ResultSet results=stmt.executeQuery("select * from "+tableName+" where type='"+fp.getType()+"'");
            if(results.next())
            {
                
                stmt.executeUpdate("UPDATE "+tableName+" SET total_amount="+fp.getTotalAmount()+",unit_price="+fp.getUnitPrice()+ " where type='"+fp.getType()+"'");
                stmt.close();
                return true;
           
            }
            else
            {
                stmt.executeUpdate("INSERT INTO "+tableName+" VALUES('"+fp.getType()+"',"+fp.getUnitPrice()+","+fp.getTotalAmount()+")");
                stmt.close();
                return true;
            }
                 
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
    
    public static class TypeInfo{
        
         private String type;
         private int unitPrice;
         private int totalAmount;

        public TypeInfo(String type, int unitPrice, int totalAmount) {
            this.type = type;
            this.unitPrice = unitPrice;
            this.totalAmount = totalAmount;
        }

        public String getType() {
            return type;
        }

        public int getUnitPrice() {
            return unitPrice;
        }

        public int getTotalAmount() {
            return totalAmount;
        }
        
        public void setType(String type) {
            this.type = type;
        }

        public void setUnitPrice(int unitPrice) {
            this.unitPrice = unitPrice;
        }

        public void setTotalAmount(int totalAmount) {
            this.totalAmount = totalAmount;
        }
         
        
    }
    
    public ResultSet getTableContents()
    {
        /*
             * returns all the information contains in the table in a java resultset object
             */
        try {
            
            stmt=connection.createStatement();
            ResultSet results=stmt.executeQuery("select * from "+tableName);
            return results;
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialTypeInfoTableProxy.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
}
