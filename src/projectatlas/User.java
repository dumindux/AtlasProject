/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

/**
 *
 * @author Dumindu
 */
public abstract class User {
    private String username;
    private String passwordHash;
    
    public static User currentUser=null;
    
    public User(String username)
    {
        this.username=username;
    }

    public User(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        try{
            User usr=(User)obj;
            if(this.username.equals(usr.getUsername()))
                return true;
            else
                return false;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
}
