/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supersimplestocks;

import java.util.LinkedHashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import superSimpleStocks.Reader;
import superSimpleStocks.StockVO;

/**
 *
 * @author Kimchi
 */
public class ReaderTest {
    
    public ReaderTest() {
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
     * Test of constructAndStoreVO method, of class Reader.
     */
    @Test
    public void testConstructAndStoreVO() {
        System.out.println("constructAndStoreVO");
        Reader instance = null;
        instance.constructAndStoreVO();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStockVOMap method, of class Reader.
     */
    @Test
    public void testGetStockVOMap() {
        System.out.println("getIvoMap");
        Reader instance = null;
        LinkedHashMap<String, StockVO> expResult = null;
        LinkedHashMap<String, StockVO> result = instance.getStockVOMap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sortMap method, of class Reader.
     */
    @Test
    public void testSortMap() {
        System.out.println("sortMap");
        Reader instance = null;
        instance.sortMap();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printMap method, of class Reader.
     */
    @Test
    public void testPrintMap() {
        System.out.println("printMap");
        Reader instance = null;
        instance.printMap();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateFromMillis method, of class Reader.
     */
    @Test
    public void testGetDateFromMillis() {
        System.out.println("getDateFromMillis");
        Long millis = null;
        String expResult = "";
        String result = Reader.getDateFromMillis(millis);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
