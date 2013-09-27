/*
 * Edited by Nuwan prabhath
 * 
 */
package projectatlas;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/**
 *
 * @author Dumindu
 */
/*
 * a singleton class which initializes the connectivity to the database.
 * 
 */
public class DatabaseConnection {
    private String dbURL="jdbc:mysql://localhost:3306/atlasservices";
    private Connection conn=null;
    
    private static DatabaseConnection instance=null;
    
    private DatabaseConnection()
    {
        createConnection();
    }
         
    public static DatabaseConnection getDatabaseConnection()
    {
        if(instance==null)
        {
            instance=new DatabaseConnection();
            return instance;
        }
        else
            return instance;
    }
    
    private void createConnection()//establishes connection to the database
    {
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn=DriverManager.getConnection(dbURL,"root","");
            
        }
        catch(Exception e)
        {
            System.out.println("Database connection failed");
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    public Connection getConnection()
    {
        return conn;
    }
    public void shutdown()//shuts down database connection
    {
        try
        {
            if(conn!=null)
            {
                
                DriverManager.getConnection(dbURL,
                            "root","");
                conn.close();
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
