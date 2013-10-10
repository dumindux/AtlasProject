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
public class FinishedProductTest {
    FinishedProduct instance;
    public FinishedProductTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new FinishedProduct("pen",1200,2000,20);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getType method, of class FinishedProduct.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        
        String expResult = "pen";
        String result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setType method, of class FinishedProduct.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "eraser";
        FinishedProduct instance = new FinishedProduct();
        instance.setType(type);
    }

    /**
     * Test of getAmount_avail method, of class FinishedProduct.
     */
    @Test
    public void testGetAmount_avail() {
        System.out.println("getAmount_avail");
        int expResult =1200 ;
        int result = instance.getAmount_avail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAmount_avail method, of class FinishedProduct.
     */
    @Test
    public void testSetAmount_avail() {
        System.out.println("setAmount_avail");
        int amount_avail = 20;
        FinishedProduct instance = new FinishedProduct();
        instance.setAmount_avail(amount_avail);
    }

    /**
     * Test of getAmount_res method, of class FinishedProduct.
     */
    @Test
    public void testGetAmount_res() {
        System.out.println("getAmount_res");
        int expResult = 2000;
        int result = instance.getAmount_res();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAmount_res method, of class FinishedProduct.
     */
    @Test
    public void testSetAmount_res() {
        System.out.println("setAmount_res");
        int amount_res = 7000;
        FinishedProduct instance = new FinishedProduct();
        instance.setAmount_res(amount_res);
    }

    /**
     * Test of getUnitPrice method, of class FinishedProduct.
     */
    @Test
    public void testGetUnitPrice() {
        System.out.println("getUnitPrice");
        int expResult = 20;
        int result = instance.getUnitPrice();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUnitPrice method, of class FinishedProduct.
     */
    @Test
    public void testSetUnitPrice() {
        System.out.println("setUnitPrice");
        int unitPrice = 40;
        FinishedProduct instance = new FinishedProduct();
        instance.setUnitPrice(unitPrice);
    }
}
