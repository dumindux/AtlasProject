/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

/**
 *
 * @author Cosmox Software Developers
 */
public interface TableProxy {
    /*
     * Defines an interface for table access proxy classes
     */
    public Object get(String ID);//gets an object created from the database
    
    public boolean add(Object obj);//adds a new objects to the database
    
    public boolean update(Object obj);//updates information of already existing object on the database and reports result
    
}
