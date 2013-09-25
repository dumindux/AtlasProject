/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

/**
 *
 * @author Dumindu
 */
public abstract class Order {
    private String timestamp;
    private String orderID;

    public Order(String orderID) {
        this.orderID = orderID;
    }    
    
}
