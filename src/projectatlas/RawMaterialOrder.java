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
public class RawMaterialOrder extends Order{

    private ArrayList<ItemInfo> itemList= new ArrayList<ItemInfo>();

    public RawMaterialOrder() {
    }
    
    public RawMaterialOrder(String orderID) {
        super(orderID);
    }
    
    public void addItem(int batchNumber,int amount)
    {
        itemList.add(new ItemInfo(batchNumber,amount));
    }
    
    private class ItemInfo{
        private int batchNumber;
        private int amount;

        public ItemInfo(int batchNumber, int amount) {
            this.batchNumber = batchNumber;
            this.amount = amount;
        }
        
    }
}
