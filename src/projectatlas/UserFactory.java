/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

import java.util.ArrayList;

/**
 *
 * @author Dumindu
 */
public class UserFactory {
/*
 * Factory class to generate user objects according to their type
 * subject to shange if different types of users are added 
 */
    private static ArrayList<User> lst =new ArrayList<User>();
    
    public static User getUser(String username)
    {
        /*
         * this method is called to get the User object associated with the username
         * if the object is not yet created it is created from the table data and listed in order to maintain a single intance of the object
         */
        for(User usr:lst)
        {
            if(usr.getUsername().equals(username))
            {
                return usr;
            }
        }
        User usr=(User)UserTableProxy.getUserTableProxy().get(username);
        return usr;
    }
    
    public static User getUser(String username,String type)
    {
        if(type.equals("manager"))
        {
            User usr=new Manager(username);
            lst.add(usr);
            return usr;
        }
        else if(type.equals("storekeeper"))
        {
            User usr=new StoreKeeper(username);
            lst.add(usr);
            return usr;
        }
        else if(type.equals("materialofficer"))
        {
            User usr=new MaterialOfficer(username);
            lst.add(usr);
            return usr;
        }
        return null;
    }
    
    public static User getUser(String username,String type,String passwordHash)
    {
        if(type.equals("manager"))
        {
            User usr= new Manager(username,passwordHash);
            lst.add(usr);
            return usr;
        }
        else if(type.equals("storekeeper"))
        {
            User usr= new StoreKeeper(username,passwordHash);
            lst.add(usr);
            return usr;
        }
        else if(type.equals("materialofficer"))
        {
            User usr= new MaterialOfficer(username,passwordHash);
            lst.add(usr);
            return usr;
        }
        return null;
    }
}
