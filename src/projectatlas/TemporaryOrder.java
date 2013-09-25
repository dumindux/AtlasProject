/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

import java.util.ArrayList;

/**
 *
 * @author Dumindu
 */
class TemporaryOrder {
    
    private ArrayList<OrderItem> itmList;
    
    public void addItem(String type,int amount){
        itmList.add(new OrderItem(type, amount));
    }
    
    
   private class OrderItem{
       /**
        * This class holds item types and desired amounts
        */
       private String type;
       private int  amount;

        public OrderItem(String type, int amount) {
            this.type = type;
            this.amount = amount;
        }
       
       
       
   }
}
