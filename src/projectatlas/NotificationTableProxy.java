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
public class NotificationTableProxy implements TableProxy{
    
    private Connection connection;
    private String tableName="notifications";
    private Statement stmt=null;
    
    private static NotificationTableProxy instance=null;
    
    private NotificationTableProxy()
    {
        connection=DatabaseConnection.getDatabaseConnection().getConnection();  //retrieves the connection to the database from singleton DatabaseConnection object
        
    }
    
    public static NotificationTableProxy getNotificationTableProxy()
    {
        if(instance==null)
        {
            instance=new NotificationTableProxy();
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
        try {
            Notification not=(Notification)obj;
            stmt=connection.createStatement();
            ResultSet results=stmt.executeQuery("SELECT * from "+tableName+" where notificationID="+not.getNotificationID());
            if(results.next())
            {
                stmt.executeUpdate("UPDATE "+tableName+" SET is_resolved="+not.isIs_resolved()+", receiver='"+not.getReceiver()+"' where notificationID="+not.getNotificationID());
                stmt.close();
                return true;
            }
            else
            {
                ResultSet results2=stmt.executeQuery("SELECT MAX(notificationID) from "+tableName);
                int notID;
                if(results2.next())
                {
                    notID=results2.getInt(7)+1;
                }
                else
                {
                    notID=1;
                }
                stmt.executeQuery("INSERT INTO "+tableName+" VALUES('"+not.getSender()+"','"+not.getReceiver()+"','"+not.getDescription()+"','"+not.isIs_resolved()+"',"+not.getBatch()+","+not.getAmount()+","+notID+")");
                stmt.close();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotificationTableProxy.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public ResultSet getItems(String sender)
    {
        try {
            stmt=connection.createStatement();
            ResultSet results=stmt.executeQuery("SELECT * from "+tableName+" where sender='"+sender+"'");
            return results;
        } catch (SQLException ex) {
            Logger.getLogger(NotificationTableProxy.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
