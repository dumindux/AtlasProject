/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

/**
 *
 * @author Cosmox Software Developers
 */
public class RawMaterialFactory {
    /*
     * holds a batch of raw material in factory
     */
    private int batchNumber=-1;
    private int batchAmount;
    private String type;
    private int unitPrice;
    
    public RawMaterialFactory() {
    }

    public RawMaterialFactory(int batchNumber,int batchAmount, String type,int unitPrice) {
        this.batchAmount = batchAmount;
        this.type = type;
        this.batchNumber=batchNumber;
        this.unitPrice=unitPrice;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }

    public int getBatchAmount() {
        return batchAmount;
    }

    public void setBatchAmount(int batchAmount) {
        this.batchAmount = batchAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    
    
    
}
