/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dumindu
 */
public class Manager extends User{

    public Manager(String username) {
        super(username);
    }
    
    public Manager(String username, String passwordHash) {
        super(username, passwordHash);
    }
    
    public void placeOrder(TemporaryOrder orderList){
        List<TemporaryOrder.OrderItem> lst=orderList.getItmList();
        RawMaterialOrder newOrder=new RawMaterialOrder();
        RawMaterialWarehouseTableProxy rawMaterialProxy=RawMaterialWarehouseTableProxy.getRawMaterialWarehouseTableProxy();
        RawMaterialOrderTableProxy orderProxy=RawMaterialOrderTableProxy.getRawMaterialOrderTableProxy();
        for(TemporaryOrder.OrderItem orderItem:lst)
        {
            try {
                ResultSet res=rawMaterialProxy.getTypeOrderByBatchNumber(orderItem.getType());
                while(res.next())
                {
                    if(res.getInt(3)<orderItem.getAmount())
                    {
                        newOrder.addItem(res.getInt(4), res.getInt(3));
                        orderItem.setAmount(orderItem.getAmount()-res.getInt(3));
                        
                    }
                    else
                    {
                        newOrder.addItem(res.getInt(4), orderItem.getAmount());
                        break;
                    }
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        orderProxy.add(newOrder);
    }
    
    //cancel order()
    
   
    
    
}
