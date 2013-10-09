/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

import java.util.ArrayList;
import java.util.List;

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
    
    public List<ItemInfo> getItems()
    {
        return itemList;
    }
    
    public static class ItemInfo{
        private int batchNumber;
        private int amount;

        public ItemInfo(int batchNumber, int amount) {
            this.batchNumber = batchNumber;
            this.amount = amount;
        }

        public int getBatchNumber() {
            return batchNumber;
        }

        public void setBatchNumber(int batchNumber) {
            this.batchNumber = batchNumber;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final ItemInfo other = (ItemInfo) obj;
            if (this.batchNumber != other.batchNumber) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "ItemInfo{" + "batchNumber=" + batchNumber + ", amount=" + amount + '}';
        }
        
        
    }

    @Override
    public String toString() {
        return "RawMaterialOrder{" + "itemList=" + itemList + '}';
    }
    
    
}
