/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dumindu
 */
public class RawMaterialOrderTableProxy implements TableProxy {

    private Connection connection;
    private String tableName = "rawmaterial_order";
    private Statement stmt = null;
    private static RawMaterialOrderTableProxy instance = null;

    private RawMaterialOrderTableProxy() {
        connection = DatabaseConnection.getDatabaseConnection().getConnection();  //retrieves the connection to the database from singleton DatabaseConnection object

    }

    public static RawMaterialOrderTableProxy getRawMaterialOrderTableProxy() {
        if (instance == null) {
            instance = new RawMaterialOrderTableProxy();
            return instance;
        } else {
            return instance;
        }
    }

    @Override
    public Object get(String ID) {
        try {
            int id = Integer.parseInt(ID);
            stmt = connection.createStatement();
            ResultSet results1 = stmt.executeQuery("SELECT * from " + tableName + " where orderID=" + id);
            if (results1.next()) {
                RawMaterialOrder order = new RawMaterialOrder(ID);
                order.setTimestamp(results1.getTimestamp(2).toString());
                order.setIsActive(results1.getBoolean(3));
                stmt.close();
                stmt = connection.createStatement();
                ResultSet results2 = stmt.executeQuery("SELECT * from order_rawmaterial where orderID=" + id);
                while(results2.next())
                {
                    order.addItem(results2.getInt(3), results2.getInt(2));
                }
                return order;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialOrderTableProxy.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public boolean add(Object obj) {
        try {
            RawMaterialOrder order=(RawMaterialOrder)obj;
            stmt=connection.createStatement();
            ResultSet results1=stmt.executeQuery("SELECT * from "+tableName+" where orderID="+order.getOrderID());
            if(results1.next())
            {
                stmt.close();
                stmt=connection.createStatement();
                stmt.executeUpdate("UPDATE "+tableName+" SET is_active="+order.isIsActive()+" where orderID="+order.getOrderID());
                stmt.close();
                return true;
            }
            else
            {
                stmt=connection.createStatement();
                ResultSet results2=stmt.executeQuery("SELECT MAX(orderID) from "+tableName);
                int nextID;
                if(results2.next())
                {
                    nextID=results2.getInt(1);
                }
                else
                {
                    nextID=1;
                }
                stmt.close();
                stmt=connection.createStatement();
                stmt.executeUpdate("INSERT INTO "+tableName+" VALUES("+nextID+","+order.getTimestamp()+","+order.isIsActive()+")");
                List<RawMaterialOrder.ItemInfo> list=order.getItems();
                for(RawMaterialOrder.ItemInfo itemInfo:list)
                {
                    stmt.executeUpdate("INSERT INTO "+tableName+" VALUES("+order.getOrderID()+","+itemInfo.getAmount()+","+itemInfo.getBatchNumber()+")");
                    
                }
                stmt.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialOrderTableProxy.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ResultSet getItems() {
        try {
            /*returns a resultset containing the data where type equals the given  
             *type and sorted according to time stamp. 
             */
            stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableName + " order by time");
            return results;
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialOrderTableProxy.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ResultSet getContents() {
        try {
            stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * from " + tableName);
            return results;
        } catch (SQLException ex) {
            Logger.getLogger(RawMaterialOrderTableProxy.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
