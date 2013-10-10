/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

/**
 *
 * @author Cosmox Software Developers
 */
public class StoreKeeperWarehouse extends User {

    public StoreKeeperWarehouse(String username) {
        super(username);
    }

    public StoreKeeperWarehouse(String username, String passwordHash) {
        super(username, passwordHash);
    }
    
}
