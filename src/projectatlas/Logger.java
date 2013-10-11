/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

/**
 *
 * @author Cosmox Software Developers
 */
import users.User;
import databases.connection.DatabaseConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;

public class Logger {

    private String logger;
    private static Logger instance;
    private Connection connection;
    
    private Logger(){
        this.connection=DatabaseConnection.getDatabaseConnection().getConnection();
    }
    
    public static Logger getLogger(String logger)
    {
        if(instance==null)
            instance=new Logger();
        instance.logger=logger;
        return instance;
    }
    
    public boolean debug(String message)
    {
        return log("DEBUG",message);
    }
    
    public boolean info(String message)
    {
        return log("INFO",message);
    }
    
    public boolean warning(String message)
    {
        return log("WARNING",message);
    }
    
    private boolean log(String level,String message)
    {
        try {
            Statement stmt=connection.createStatement();
            stmt.executeUpdate("INSERT INTO factory_logs VALUES('"+User.currentUser.getUsername() +"','"+logger+"','"+level+"','"+message+"','"+new Timestamp(new Date().getTime())+"')");
            stmt.close();
            return true;
        } catch (SQLException ex) {
            //return false;
            java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }

    
    /*public static void main(String[] args) {
        Date date=new Date();
        System.out.println(new Timestamp(date.getTime()));
        Logger log=Logger.getLogger("material section");
        log.info("Testing logger 1");
        log.debug("Testing logger 2");
        log.warning("Testing logger 3");
    }*/
}
