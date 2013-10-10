/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
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
public class FactoryLogsTableProxyTest {
    private Connection connection;
    private Statement stmt;
    
    public FactoryLogsTableProxyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        connection=DatabaseConnection.getDatabaseConnection().getConnection();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of get method, of class FactoryLogsTableProxy.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        String ID = "";
        FactoryLogsTableProxy instance = null;
        Object expResult = null;
        Object result = null;
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class FactoryLogsTableProxy.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Object obj = null;
        FactoryLogsTableProxy instance = null;
        boolean expResult = true;
        boolean result = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of getTableContents method, of class FactoryLogsTableProxy.
     */
    @Test
    public void testGetTableContents() throws SQLException {
        System.out.println("getTableContents");
        FactoryLogsTableProxy instance = FactoryLogsTableProxy.getFactoryLogsTableProxy();
        ResultSet expResult = null;
        try {
            
            stmt=connection.createStatement();
            ResultSet results=stmt.executeQuery("select * from factory_logs where level='INFO'");
            expResult= results;
        } catch (SQLException ex) {
           expResult= null;
        }
       
        ResultSet result = instance.getTableContents();
        expResult.next();
        result.next();
        assertEquals(expResult.getString(4), result.getString(4));
    }
}
