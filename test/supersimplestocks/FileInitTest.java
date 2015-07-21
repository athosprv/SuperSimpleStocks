/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supersimplestocks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import superSimpleStocks.FileInit;

/**
 *
 * @author Kimchi
 */
public class FileInitTest {

    public FileInitTest() {
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
     * Test of getScanner method, of class FileInit.
     */
    @Test
    public void testGetScanner() {
        System.out.println("getScanner");
        try {
            FileInit instance = new FileInit(new File("badFile.csv"));
        } catch (Exception e) {
            assertEquals(e.getClass(), FileNotFoundException.class);
        }

    }

}
