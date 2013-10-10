/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

/**
 *
 * @author Cosmox Software Developers
 */
public class StoreKeeperFactory extends User{

    public StoreKeeperFactory(String username) {
        super(username);
    }

    public StoreKeeperFactory(String username, String passwordHash) {
        super(username, passwordHash);
    }
    
    
    
}
