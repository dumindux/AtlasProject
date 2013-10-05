/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

/**
 *
 * @author Dumindu
 */
public class RawMaterialWarehouse {
    
    private int batchNumber;
    private int resAmount;
    private int availAmount;
    private String type;
    private int unitPrice;

    public RawMaterialWarehouse() {
    }

    public RawMaterialWarehouse(int batchNumber, int resAmount, int availAmount, String type,int unitPrice) {
        this.batchNumber = batchNumber;
        this.resAmount = resAmount;
        this.availAmount = availAmount;
        this.type = type;
        this.unitPrice=unitPrice;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    
    
    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }

    public int getResAmount() {
        return resAmount;
    }

    public void setResAmount(int resAmount) {
        this.resAmount = resAmount;
    }

    public int getAvailAmount() {
        return availAmount;
    }

    public void setAvailAmount(int availAmount) {
        this.availAmount = availAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
}
