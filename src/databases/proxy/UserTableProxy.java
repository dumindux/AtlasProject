/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databases.proxy;

import databases.connection.DatabaseConnection;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import users.User;
import users.UserFactory;

/**
 *
 * @author Cosmox Software Developers
 */
public class UserTableProxy implements TableProxy{
    private Connection connection;
    private String tableName="userinfo";
    private Statement stmt=null;
    
    private static UserTableProxy instance=null;
    
    private UserTableProxy()
    {
        connection=DatabaseConnection.getDatabaseConnection().getConnection();  //retrieves the connection to the database from singleton DatabaseConnection object
        
    }
    
    public static UserTableProxy getUserTableProxy()
    {
        if(instance==null)
        {
            instance=new UserTableProxy();
            return instance;
        }
        else
            return instance;
    }
    
   
    
    public void shutdown() throws SQLException
    {
        if(stmt!=null)
        {
                stmt.close();
        }
    }

    @Override
    public Object get(String ID) {
        String username=ID;
        try
        {
            stmt=connection.createStatement();
            ResultSet results=stmt.executeQuery("select * from "+tableName+" where username='"+username+"'");
            ResultSetMetaData rsmd=results.getMetaData();
            int numberCols=rsmd.getColumnCount();
            if(!results.next())
                return null;
           // System.out.println(results.getString(2));
            String type=results.getString(2);
            String passwordHash=results.getString(3);
            User user=UserFactory.getUser(username, type,passwordHash);
            return user;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean add(Object obj) {
        User user;
        try{
            user=(User)obj;
        }
        catch(ClassCastException e)
        {
            return false;
        }
        
        
        try {
            stmt=connection.createStatement();
            ResultSet results=stmt.executeQuery("select * from userinfo where username='"+user.getUsername()+"'");
            
            if(!results.next())
            {
                stmt=connection.createStatement();
                stmt.executeUpdate("INSERT INTO userinfo VALUES('"+user.getUsername()+"','"+user.getClass().getSimpleName().toLowerCase()+"','"+user.getPasswordHash()+"')");
                stmt.close();
                return true;
            }
            
            stmt=connection.createStatement();
            stmt.executeUpdate("UPDATE userinfo SET passwordHash='"+user.getPasswordHash()+"' where username='"+user.getUsername()+"'");
            stmt.close();
            
            stmt=connection.createStatement();
            stmt.executeUpdate("UPDATE userinfo SET type='"+user.getClass().getSimpleName().toLowerCase()+"' where username='"+user.getUsername()+"'");
            stmt.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserTableProxy.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public ResultSet getTableContents()
    {
        try {
            stmt=connection.createStatement();
            ResultSet results=stmt.executeQuery("SELECT * from "+tableName);
            return results;
        } catch (SQLException ex) {
            Logger.getLogger(UserTableProxy.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
