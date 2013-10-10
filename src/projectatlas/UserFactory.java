/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

import java.util.ArrayList;

/**
 *
 * @author Cosmox Software Developers
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
        else if(type.equals("storekeeperwarehouse"))
        {
            User usr=new StoreKeeperWarehouse(username);
            lst.add(usr);
            return usr;
        }
        else if(type.equals("storekeeperfactory"))
        {
            User usr=new StoreKeeperFactory(username);
            lst.add(usr);
            return usr;
        }
        else if(type.equals("rawmaterialofficerwarehouse"))
        {
            User usr=new RawMaterialOfficerWarehouse(username);
            lst.add(usr);
            return usr;
        }
        else if(type.equals("rawmaterialofficerfactory"))
        {
            User usr=new RawMaterialOfficerFactory(username);
            lst.add(usr);
            return usr;
        }
        else if(type.equals("finishedmaterialofficer"))
        {
            User usr=new FinishedMaterialOfficer(username);
            lst.add(usr);
            return usr;
        }
        return null;
    }
    
    public static User getUser(String username,String type,String passwordHash)
    {
        if(type.equals("manager"))
        {
            User usr=new Manager(username,passwordHash);
            lst.add(usr);
            return usr;
        }
        else if(type.equals("storekeeperwarehouse"))
        {
            User usr=new StoreKeeperWarehouse(username,passwordHash);
            lst.add(usr);
            return usr;
        }
        else if(type.equals("storekeeperfactory"))
        {
            User usr=new StoreKeeperFactory(username,passwordHash);
            lst.add(usr);
            return usr;
        }
        else if(type.equals("rawmaterialofficerwarehouse"))
        {
            User usr=new RawMaterialOfficerWarehouse(username,passwordHash);
            lst.add(usr);
            return usr;
        }
        else if(type.equals("rawmaterialofficerfactory"))
        {
            User usr=new RawMaterialOfficerFactory(username,passwordHash);
            lst.add(usr);
            return usr;
        }
        else if(type.equals("finishedmaterialofficer"))
        {
            User usr=new FinishedMaterialOfficer(username,passwordHash);
            lst.add(usr);
            return usr;
        }
        return null;
    }
}
