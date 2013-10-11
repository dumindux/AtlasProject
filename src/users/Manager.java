/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import databases.proxy.RawMaterialWarehouseTableProxy;
import databases.proxy.RawMaterialOrderTableProxy;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import projectatlas.RawMaterialOrder;
import projectatlas.RawMaterialWarehouse;
import projectatlas.TemporaryOrder;

/**
 *
 * @author Cosmox Software Developers
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
                        RawMaterialWarehouseTableProxy proxy=RawMaterialWarehouseTableProxy.getRawMaterialWarehouseTableProxy();
                        RawMaterialWarehouse rmw=(RawMaterialWarehouse)proxy.get(""+res.getInt(4));
                        rmw.setAvailAmount(rmw.getAvailAmount()-res.getInt(3));
                        rmw.setResAmount(rmw.getResAmount()+res.getInt(3));
                        proxy.add(rmw);
                        orderItem.setAmount(orderItem.getAmount()-res.getInt(3));
                        
                    }
                    else
                    {
                        RawMaterialWarehouseTableProxy proxy=RawMaterialWarehouseTableProxy.getRawMaterialWarehouseTableProxy();
                        RawMaterialWarehouse rmw=(RawMaterialWarehouse)proxy.get(""+res.getInt(4));
                        rmw.setAvailAmount(rmw.getAvailAmount()-orderItem.getAmount());
                        rmw.setResAmount(rmw.getResAmount()+orderItem.getAmount());
                        proxy.add(rmw);
                        newOrder.addItem(res.getInt(4), orderItem.getAmount());
                        break;
                    }
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(newOrder);
        orderProxy.add(newOrder);
    }
    
    //cancel order()
    
   
    
    
}
