/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

/**
 *
 * @author Cosmox Software Developers
 */
public class MaterialOfficer extends User{

    public MaterialOfficer(String username) {
        super(username);
    }

    public MaterialOfficer(String username, String passwordHash) {
        super(username, passwordHash);
    }
    
    
}
