/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

/**
 *
 * @author Cosmox Software Developers
 */
public class FinishedProduct {
    
    private String type;
    private int amount_avail;
    private int amount_res;
    private int unitPrice;

    public FinishedProduct(String type, int amount_avail, int amount_res, int unitPrice) {
        this.type = type;
        this.amount_avail = amount_avail;
        this.amount_res = amount_res;
        this.unitPrice = unitPrice;
    }

    public FinishedProduct() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount_avail() {
        return amount_avail;
    }

    public void setAmount_avail(int amount_avail) {
        this.amount_avail = amount_avail;
    }

    public int getAmount_res() {
        return amount_res;
    }

    public void setAmount_res(int amount_res) {
        this.amount_res = amount_res;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    
    
}
