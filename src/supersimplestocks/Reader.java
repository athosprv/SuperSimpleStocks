/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superSimpleStocks;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author geo53576
 */
public class Reader {

    private Scanner sc;
    private LinkedHashMap<String, StockVO> stockVOMap;

    public Reader(Scanner sc) {
        this.sc = sc;
        stockVOMap = new LinkedHashMap<String, StockVO>();
        constructAndStoreVO();
    }

    public void constructAndStoreVO() {
        sc.nextLine();
        Scanner scanLine = null;
        double fixedDividend = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            StockVO ivo;
            scanLine = new Scanner(line).useDelimiter(",");

            String stockSymbol = scanLine.next();
            String type = scanLine.next();
            int lastDividend = Integer.parseInt(scanLine.next());
            try {
                fixedDividend = Double.parseDouble(scanLine.next());
            } catch (NumberFormatException nfe) {
            }
            int parValue = Integer.parseInt(scanLine.next());
            long tickerPrice = Long.parseLong(scanLine.next());
            Long timeInMillis = Long.parseLong(scanLine.next());
            String indicator = scanLine.next();
            int quantity = Integer.parseInt(scanLine.next());
            double tradePrice = Double.parseDouble(scanLine.next());

            if (stockVOMap.containsKey(stockSymbol)) {
                ivo = stockVOMap.get(stockSymbol);
                ivo.setOccurrences(ivo.getOccurrences() + 1);
                stockVOMap.put(stockSymbol, ivo);
                stockVOMap.put(stockSymbol + stockVOMap.get(stockSymbol).getOccurrences(), new StockVO(type, lastDividend, fixedDividend, parValue, tickerPrice, timeInMillis, indicator, quantity, 1, tradePrice));
            } else {
                ivo = new StockVO(type, lastDividend, fixedDividend, parValue, tickerPrice, timeInMillis, indicator, quantity, 1, tradePrice);
                stockVOMap.put(stockSymbol, ivo);
            }
        }
        sc.close();
        if (scanLine != null) {
            scanLine.close();
        }
        sortMap();
    }

    public LinkedHashMap<String, StockVO> getStockVOMap() {
        return stockVOMap;
    }

    public void sortMap() {

        List<Map.Entry<String, StockVO>> list = new LinkedList<Map.Entry<String, StockVO>>(stockVOMap.entrySet());

        // Sort list with comparator, to compare the Map values
        Collections.sort(list, new Comparator<Map.Entry<String, StockVO>>() {
            @Override
            public int compare(Map.Entry<String, StockVO> o1, Map.Entry<String, StockVO> o2) {
                return (o1.getValue().getTimeInMillis() + "").compareTo(o2.getValue().getTimeInMillis() + "");
            }
        });

        // Convert sorted map back to a Map
        Map<String, StockVO> sortedMap = new LinkedHashMap<String, StockVO>();
        for (Iterator<Map.Entry<String, StockVO>> it = list.iterator(); it.hasNext();) {
            Map.Entry<String, StockVO> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        stockVOMap = (LinkedHashMap<String, StockVO>) sortedMap;
    }

    public void printMap() {
        for (Map.Entry<String, StockVO> entry : stockVOMap.entrySet()) {
            System.out.println("[Key] : " + entry.getKey()
                    + " [Value] : " + getDateFromMillis(entry.getValue().getTimeInMillis()));
        }
    }

    public static String getDateFromMillis(Long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);

        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);
        int mHour = calendar.get(Calendar.HOUR_OF_DAY);
        int mMinute = calendar.get(Calendar.MINUTE);
        int mSecond = calendar.get(Calendar.SECOND);
        return mYear + "/" + mMonth + "/" + mDay + ": " + mHour + ":" + mMinute + ":" + mSecond;
    }

}
