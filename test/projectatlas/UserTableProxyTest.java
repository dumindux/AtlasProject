/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cosmox Software Developers
 */
public class UserTableProxyTest {
    
    public UserTableProxyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUserTableProxy method, of class UserTableProxy.
     */
    @Test
    public void testGetUserTableProxy() {
        System.out.println("getUserTableProxy");
        UserTableProxy expResult = null;
        UserTableProxy result = UserTableProxy.getUserTableProxy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of shutdown method, of class UserTableProxy.
     */
    @Test
    public void testShutdown() throws Exception {
        System.out.println("shutdown");
        UserTableProxy instance = null;
        instance.shutdown();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class UserTableProxy.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        String ID = "";
        UserTableProxy instance = null;
        Object expResult = null;
        Object result = instance.get(ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class UserTableProxy.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Object obj = null;
        UserTableProxy instance = null;
        boolean expResult = false;
        boolean result = instance.add(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class UserTableProxy.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Object obj = null;
        UserTableProxy instance = null;
        boolean expResult = false;
        boolean result = instance.update(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
