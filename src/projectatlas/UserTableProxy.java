/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dumindu
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
    
   /* public boolean changePassword(String username,String password,String newPassword) throws Exception
    {
        if(compareData(username,password)!=null)
        {
            stmt=connection.createStatement();
            stmt.executeUpdate("UPDATE userinfo SET passwordHash='"+getHash(newPassword)+"' where username='"+username+"'");
            return true;
        }
        else
            return false;
    }
    
    public String compareData(String username,String password) throws Exception// returns type if username and password is a match
    {
        try
        {
            stmt=connection.createStatement();
            ResultSet results=stmt.executeQuery("select * from "+tableName+" where username='"+username+"'");
            ResultSetMetaData rsmd=results.getMetaData();
            int numberCols=rsmd.getColumnCount();
            results.next();
           // System.out.println(results.getString(2));
            if(results.getString(3).equals(getHash(password)))
            {
                String rtn=results.getString(2);
               // System.out.println(rtn);
                results.close();
                stmt.close();
                return rtn;
            }
            else
            {
                results.close();
                stmt.close();
                return null;
            }
            
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public String getHash(String password) throws Exception {
        MessageDigest sha256=MessageDigest.getInstance("SHA-256");
        byte[] passBytes=password.getBytes();
        byte[] passHash=sha256.digest(passBytes);
        String hash=Arrays.toString(passHash);
        return hash;
    }*/
    
   /* public boolean addUser(String username,String password,String type)
    {
        return true;
    }
    
    public boolean updateUser(User user)
    {
        try {
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
    }*/
    
    /*public User getUser(String username)
    {
        try
        {
            stmt=connection.createStatement();
            ResultSet results=stmt.executeQuery("select * from "+tableName+" where username='"+username+"'");
            ResultSetMetaData rsmd=results.getMetaData();
            int numberCols=rsmd.getColumnCount();
            results.next();
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
    }*/
    
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
            stmt.close();
            
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
}
