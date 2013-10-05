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
public class RawMaterialOrderTableProxy implements TableProxy{

    private Connection connection;
    private String tableName="rawmaterial_order";
    private Statement stmt=null;
    
    private static RawMaterialOrderTableProxy instance=null;
    
    private RawMaterialOrderTableProxy()
    {
        connection=DatabaseConnection.getDatabaseConnection().getConnection();  //retrieves the connection to the database from singleton DatabaseConnection object
        
    }
    
    public static RawMaterialOrderTableProxy getRawMaterialOrderTableProxy()
    {
        if(instance==null)
        {
            instance=new RawMaterialOrderTableProxy();
            return instance;
        }
        else
            return instance;
    }
    
    @Override
    public Object get(String ID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean add(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public ResultSet getItems(String type)
    {
        try {
            /*returns a resultset containing the data where type equals the given  
             *type and sorted according to time stamp. 
             */
            stmt=connection.createStatement();
            ResultSet results=stmt.executeQuery("select * from "+tableName+" where type='"+type+"' order by time");
            return results;
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialOrderTableProxy.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
