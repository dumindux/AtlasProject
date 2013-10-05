/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Dumindu
 */
public abstract class Order {
    private String timestamp;
    private String orderID;

    public Order(String orderID) {
        this.orderID = orderID;
        Date date=new Date();
        timestamp=new Timestamp(date.getTime()).toString();
    }    

    public Order() {
        
        Date date=new Date();
        timestamp=new Timestamp(date.getTime()).toString();
        
    }
    
    
}
