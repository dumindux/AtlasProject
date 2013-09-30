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
 * @author Dumindu
 */
public class FinishedProductTableProxy implements TableProxy{

    private Connection connection;
    private String tableName="finished_product";
    private Statement stmt=null;
    
    private static FinishedProductTableProxy instance=null;
    
    private FinishedProductTableProxy()
    {
        connection=DatabaseConnection.getDatabaseConnection().getConnection();  //retrieves the connection to the database from singleton DatabaseConnection object
        
    }
    
    public static FinishedProductTableProxy getFinishedProductTableProxy()
    {
        if(instance==null)
        {
            instance=new FinishedProductTableProxy();
            return instance;
        }
        else
            return instance;
    }
    @Override
    public Object get(String ID) {
        try {
            stmt=connection.createStatement();
            ResultSet results=stmt.executeQuery("select * from "+tableName+" where type='"+ID+"'");
            if(!results.next())
                return null;
            else
            {
                return new FinishedProduct(results.getString(1),results.getInt(2),results.getInt(3),results.getInt(4));
            }
        } catch (SQLException ex) {
            System.out.println("Database error!");
            Logger.getLogger(FinishedProductTableProxy.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public boolean add(Object obj) {
        try{
            FinishedProduct fp=(FinishedProduct)obj;
            stmt=connection.createStatement();
            ResultSet results=stmt.executeQuery("select * from "+tableName+" where type='"+fp.getType()+"'");
            if(results.next())
            {
                
                stmt.executeUpdate("UPDATE finished_product SET amount_avail="+fp.getAmount_avail()+",amount_res="+fp.getAmount_res()+",unit_price="+fp.getUnitPrice()+ " where type='"+fp.getType()+"'");
                stmt.close();
                return true;
           
            }
            else
            {
                stmt.executeUpdate("INSERT INTO finished_product VALUES('"+fp.getType()+"',"+fp.getAmount_avail()+","+fp.getAmount_res()+","+fp.getUnitPrice()+")");
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
            Logger.getLogger(projectatlas.FinishedProductTableProxy.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public static void main(String[] args)
    {
        FinishedProduct fp1=new FinishedProduct("pen",1200,2400,15),fp2=new FinishedProduct("eraser",250,300,12);
        FinishedProductTableProxy.getFinishedProductTableProxy().add(fp2);
        
    }
    
}

