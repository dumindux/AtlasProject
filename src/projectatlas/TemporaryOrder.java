/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

import java.util.ArrayList;

/**
 *
 * @author Cosmox Software Developers
 */
class TemporaryOrder {
    
    private ArrayList<OrderItem> itmList=new ArrayList<OrderItem>();
    
    public void addItem(String type,int amount){
        itmList.add(new OrderItem(type, amount));
    }

    public ArrayList<OrderItem> getItmList() {
        return itmList;
    }
    
    
   public static class OrderItem{
       /**
        * This class holds item types and desired amounts
        */
       private String type;
       private int  amount;

        public OrderItem(String type, int amount) {
            this.type = type;
            this.amount = amount;
        }

        public String getType() {
            return type;
        }

        public int getAmount() {
            return amount;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "OrderItem{" + "type=" + type + ", amount=" + amount + '}';
        }
       
        
       
       
   }

    @Override
    public String toString() {
        return "TemporaryOrder{" + "itmList=" + itmList + '}';
    }
   
   
}
