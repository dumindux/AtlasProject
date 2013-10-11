/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

/**
 *
 * @author Cosmox Software Developers
 */
public class StoreKeeper extends User{

    public StoreKeeper(String username, String passwordHash) {
        super(username, passwordHash);
    }

    public StoreKeeper(String username) {
        super(username);
    }
    
}
