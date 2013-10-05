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
 * @author Dumindu
 */
public class UserPasswordMatchTest {
    
    public UserPasswordMatchTest() {
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
     * Test of getHash method, of class UserPasswordMatch.
     */
    @Test
    public void testGetHash() throws Exception {
        System.out.println("getHash");
        String password = "atlas";
        String expResult = "[124, -126, 96, 37, 0, -123, 122, -90, -19, 12, -13, -116, 76, 62, 78, -58, 69, -67, -54, -88, 44, 0, -71, 21, 94, -80, -117, -31, 0, -57, 120, -87]";
        String result = UserPasswordMatch.getHash(password);
        assertEquals(expResult, result);
    }

    /**
     * Test of compareData method, of class UserPasswordMatch.
     */
    @Test
    public void testCompareData() throws Exception {
        System.out.println("compareData");
        User user = (User)UserTableProxy.getUserTableProxy().get("dumindux");
        String password = "atlas";
        boolean expResult = true;
        boolean result = UserPasswordMatch.compareData(user, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of changePassword method, of class UserPasswordMatch.
     */
    @Test
    public void testChangePassword() throws Exception {
        System.out.println("changePassword");
        User user = (User)UserTableProxy.getUserTableProxy().get("dumindux");
        String curPassword = "atlas";
        String newPassword = "atlas4";
        boolean expResult = true;
        boolean result = UserPasswordMatch.changePassword(user, curPassword, newPassword);
        assertEquals(expResult, result);
    }
}
