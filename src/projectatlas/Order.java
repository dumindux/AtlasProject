/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Cosmox Software Developers
 */
public abstract class Order {
    private String timestamp;
    private String orderID="-1";
    private boolean isActive=true;
    
    public Order(String orderID) {
        this.orderID = orderID;
        Date date=new Date();
        timestamp=new Timestamp(date.getTime()).toString();
    }    

    public Order() {
        
        Date date=new Date();
        timestamp=new Timestamp(date.getTime()).toString();
        
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    
    
    
}
