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
}

