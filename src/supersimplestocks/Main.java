/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superSimpleStocks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author geo53576
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("--------------------------------------------------");
        System.out.println("-=[Welcome to the Super Simple Stocks application]=-");
        System.out.println("--------------------------------------------------");
        try {
            FileInit init = new FileInit(new File("static_file.csv"));
            Reader r = new Reader(init.getScanner());
            Processor p = new Processor(r.getStockVOMap());
            //r.printMap();

            Random random = new Random();
            List<String> keys = new ArrayList<String>(r.getStockVOMap().keySet());
            String randomStock = keys.get(random.nextInt(keys.size()));

            p.calcDividendYield(randomStock);
            System.out.println("--------------------------------------------------");
            p.calcPERatio(randomStock);
            System.out.println("--------------------------------------------------");
            p.recordTrade("IZV");
            System.out.println("--------------------------------------------------");
            p.calcStockPriceRecorded("IZV");
            System.out.println("--------------------------------------------------");
            p.CalcGeometricMean();
            
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
    }

}
