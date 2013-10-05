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
public class RawMaterialWarehouseTest {
    
    public RawMaterialWarehouseTest() {
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
     * Test of getUnitPrice method, of class RawMaterialWarehouse.
     */
    @Test
    public void testGetUnitPrice() {
        System.out.println("getUnitPrice");
        RawMaterialWarehouse instance = new RawMaterialWarehouse(5,500,200,"plastic",200);
        int expResult = 200;
        int result = instance.getUnitPrice();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUnitPrice method, of class RawMaterialWarehouse.
     */
    @Test
    public void testSetUnitPrice() {
        System.out.println("setUnitPrice");
        int unitPrice = 20;
        RawMaterialWarehouse instance = new RawMaterialWarehouse();
        instance.setUnitPrice(unitPrice);
    }

    /**
     * Test of getBatchNumber method, of class RawMaterialWarehouse.
     */
    @Test
    public void testGetBatchNumber() {
        System.out.println("getBatchNumber");
        RawMaterialWarehouse instance = new RawMaterialWarehouse(5,500,200,"plastic",200);
        int expResult = 5;
        int result = instance.getBatchNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBatchNumber method, of class RawMaterialWarehouse.
     */
    @Test
    public void testSetBatchNumber() {
        System.out.println("setBatchNumber");
        int batchNumber = 6;
        RawMaterialWarehouse instance = new RawMaterialWarehouse();
        instance.setBatchNumber(batchNumber);
    }

    /**
     * Test of getResAmount method, of class RawMaterialWarehouse.
     */
    @Test
    public void testGetResAmount() {
        System.out.println("getResAmount");
        RawMaterialWarehouse instance =new RawMaterialWarehouse(5,500,200,"plastic",200);
        int expResult = 500;
        int result = instance.getResAmount();
        assertEquals(expResult, result);
    }

    /**
     * Test of setResAmount method, of class RawMaterialWarehouse.
     */
    @Test
    public void testSetResAmount() {
        System.out.println("setResAmount");
        int resAmount = 23;
        RawMaterialWarehouse instance = new RawMaterialWarehouse();
        instance.setResAmount(resAmount);
    }

    /**
     * Test of getAvailAmount method, of class RawMaterialWarehouse.
     */
    @Test
    public void testGetAvailAmount() {
        System.out.println("getAvailAmount");
        RawMaterialWarehouse instance = new RawMaterialWarehouse(5,500,200,"plastic",200);
        int expResult = 200;
        int result = instance.getAvailAmount();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAvailAmount method, of class RawMaterialWarehouse.
     */
    @Test
    public void testSetAvailAmount() {
        System.out.println("setAvailAmount");
        int availAmount = 30;
        RawMaterialWarehouse instance = new RawMaterialWarehouse();
        instance.setAvailAmount(availAmount);
    }

    /**
     * Test of getType method, of class RawMaterialWarehouse.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        RawMaterialWarehouse instance = new RawMaterialWarehouse(5,500,200,"plastic",200);
        String expResult = "plastic";
        String result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setType method, of class RawMaterialWarehouse.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "rubber";
        RawMaterialWarehouse instance = new RawMaterialWarehouse();
        instance.setType(type);
    }
}
