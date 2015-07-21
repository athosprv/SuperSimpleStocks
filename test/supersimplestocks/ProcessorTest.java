/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supersimplestocks;

import java.security.InvalidParameterException;
import java.util.LinkedHashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import superSimpleStocks.Processor;

/**
 *
 * @author Kimchi
 */
public class ProcessorTest {

    public ProcessorTest() {
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
     * Test of calcDividendYield method, of class Processor.
     */
    @Test
    public void testCalcDividendYield() {
        System.out.println("calcDividendYield");
        String stock = "DoesNotExist";
        LinkedHashMap<String, superSimpleStocks.StockVO> stockVOMap = new LinkedHashMap<String, superSimpleStocks.StockVO>();
        Processor instance = new Processor(stockVOMap);
        try {
            instance.calcDividendYield(stock);
        } catch (Exception e) {
            assertTrue(e.getClass().equals(NullPointerException.class));
        }

        //  VHV	Common	13	0.74	100	160	1436912394819	Buy	5424	176
    }

    /**
     * Test of calcPERatio method, of class Processor.
     */
    @Test
    public void testCalcPERatio() {
        System.out.println("calcPERatio");
        String stock = "DoesNotExist";
        LinkedHashMap<String, superSimpleStocks.StockVO> stockVOMap = new LinkedHashMap<String, superSimpleStocks.StockVO>();
        Processor instance = new Processor(stockVOMap);
        try {
            instance.calcPERatio(stock);
        } catch (Exception e) {
            assertTrue(e.getClass().equals(NullPointerException.class));
        }
    }

    /**
     * Test of recordTrade method, of class Processor.
     */
    @Test
    public void testRecordTrade() {
        System.out.println("recordTrade");
        String stock = "DoesNotExist";
        LinkedHashMap<String, superSimpleStocks.StockVO> stockVOMap = new LinkedHashMap<String, superSimpleStocks.StockVO>();
        Processor instance = new Processor(stockVOMap);
        try {
            instance.recordTrade(stock);
        } catch (Exception e) {
            assertTrue(e.getClass().equals(NullPointerException.class));
        }
    }

    /**
     * Test of calcStockPriceRecorded method, of class Processor.
     */
    @Test
    public void testCalcStockPriceRecorded() {
        System.out.println("calcStockPriceRecorded");
        String stock = "DoesNotExist";
        LinkedHashMap<String, superSimpleStocks.StockVO> stockVOMap = new LinkedHashMap<String, superSimpleStocks.StockVO>();
        Processor instance = new Processor(stockVOMap);
        try {
            instance.calcStockPriceRecorded(stock);
        } catch (Exception e) {
            assertTrue(e.getClass().equals(NullPointerException.class));
        }

    }

    /**
     * Test of CalcGeometricMean method, of class Processor.
     */
    @Test
    public void testCalcGeometricMean() {
        System.out.println("CalcGeometricMean");
        String stock = "DoesNotExist";
        LinkedHashMap<String, superSimpleStocks.StockVO> stockVOMap = new LinkedHashMap<String, superSimpleStocks.StockVO>();
        Processor instance = new Processor(stockVOMap);
        try {
            instance.CalcGeometricMean();
        } catch (Exception e) {
            assertTrue(e.getClass().equals(NullPointerException.class));
        }
    }

}
