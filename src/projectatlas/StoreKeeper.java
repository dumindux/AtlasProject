/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

/**
 *
 * @author Dumindu
 */
public class StoreKeeper extends User{

    public StoreKeeper(String username, String passwordHash) {
        super(username, passwordHash);
    }

    public StoreKeeper(String username) {
        super(username);
    }
    
}
