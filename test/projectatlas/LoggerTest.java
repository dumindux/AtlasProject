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
public class LoggerTest {
    
    public LoggerTest() {
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
     * Test of debug method, of class Logger.
     */
    @Test
    public void testDebug() {
        System.out.println("debug");
        String message = "Testing debug logging";
        Logger instance = Logger.getLogger("jUnit");
        boolean expResult = true;
        boolean result = instance.debug(message);
        assertEquals(expResult, result);
    }

    /**
     * Test of info method, of class Logger.
     */
    @Test
    public void testInfo() {
        System.out.println("info");
        String message = "Testing info logging";
        Logger instance = Logger.getLogger("jUnit");
        boolean expResult = true;
        boolean result = instance.info(message);
        assertEquals(expResult, result);
    }

    /**
     * Test of warning method, of class Logger.
     */
    @Test
    public void testWarning() {
        System.out.println("warning");
        String message = "Testing warning logging";
        Logger instance = Logger.getLogger("jUnit");
        boolean expResult = true;
        boolean result = instance.warning(message);
        assertEquals(expResult, result);
    }
}
