/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superSimpleStocks;

import java.security.InvalidParameterException;
import java.util.LinkedHashMap;

/**
 *
 * @author geo53576
 */
public class Processor {

    private LinkedHashMap<String, StockVO> stockVOMap;

    public Processor(LinkedHashMap<String, StockVO> ivoMap) {
        this.stockVOMap = ivoMap;
    }

    public void calcDividendYield(String stock) {
        if (stockVOMap.isEmpty()) {
            throw new NullPointerException();
        }
        System.out.println("Problem   a.i:  Calculate the dividend yield for given stock: " + stock + ". (First Encountered)");
        if (stockVOMap.get(stock).getType().equals("Common")) {
            System.out.println("Dividend Yield: " + (double) stockVOMap.get(stock).getLastDividend() / stockVOMap.get(stock).getTickerPrice());
        } else if (stockVOMap.get(stock).getType().equals("Preferred")) {
            System.out.println("Dividend Yield: " + (double) stockVOMap.get(stock).getfixedDividend() / stockVOMap.get(stock).getTickerPrice());
        } else {
            throw new InvalidParameterException();
        }

    }

    public void calcPERatio(String stock) {
        System.out.println("Problem   a.ii: Calculate the P/E ratio for given stock: " + stock + ". (First Encountered)");
        if (stockVOMap.isEmpty()) {
            throw new NullPointerException();
        }
        if (stockVOMap.get(stock).getType().equals("Common")) {
            System.out.println("P/E ratio: " + (double) stockVOMap.get(stock).getTickerPrice() / stockVOMap.get(stock).getLastDividend());
        } else if (stockVOMap.get(stock).getType().equals("Preferred")) {
            System.out.println("P/E ratio: " + (double) stockVOMap.get(stock).getTickerPrice() / stockVOMap.get(stock).getfixedDividend());
        } else {
            throw new InvalidParameterException();
        }
    }

    public void recordTrade(String stock) {
        if (stockVOMap.isEmpty()) {
            throw new NullPointerException();
        } else if (!stockVOMap.containsKey(stock)) {
            throw new InvalidParameterException();
        }
        int occurrences = stockVOMap.get(stock).getOccurrences();
        System.out.println("Problem   a.iii:    Record a trade, with timestamp, quantity of shares, buy or sell indicator and price for given stock: " + stock + ".");
        System.out.println(occurrences + " occurrences of Stock: '" + stock + "' found.");
        String action = null;

        String stockName;
        for (int i = 0; i < occurrences; i++) {
            if (i == 0) {
                stockName = stock;
            } else {
                stockName = stock + (i + 1);
            }
            if (stockVOMap.get(stockName).getIndicator().equals("Buy")) {
                action = "bought";
            } else if (stockVOMap.get(stockName).getIndicator().equals("Sell")) {
                action = "sold";
            } else {
                throw new InvalidParameterException();
            }

            String date = Reader.getDateFromMillis(stockVOMap.get(stockName).getTimeInMillis());
            int quantity = stockVOMap.get(stockName).getQuantity();
            long price = stockVOMap.get(stockName).getTickerPrice();
            System.out.println("On: " + date + ", " + quantity + " shares were " + action + " for " + price + " pence each.");
        }

    }

    public void calcStockPriceRecorded(String stock) {
        if (stockVOMap.isEmpty()) {
            throw new NullPointerException();
        } else if (!stockVOMap.containsKey(stock)) {
            throw new InvalidParameterException();
        }
        int occurrences = stockVOMap.get(stock).getOccurrences();
        System.out.println("Problem   a.iv: Calculate Stock Price based on trades recorded in past 15 minutes for given stock: " + stock + ".");
        long startTime = stockVOMap.get(stock).getTimeInMillis();
        int minutesInMillis = 900000;
        String stockName;

        long totalQuantity = 0;
        double tradePricexQuantity = 0;
        for (int i = 0; i < occurrences; i++) {
            if (i == 0) {
                stockName = stock;
            } else {
                stockName = stock + (i + 1);
            }
            long tradeTime = stockVOMap.get(stockName).getTimeInMillis();
            if ((startTime - tradeTime) <= minutesInMillis) {
                totalQuantity += stockVOMap.get(stockName).getQuantity();
                tradePricexQuantity += (stockVOMap.get(stockName).getTradePrice() * stockVOMap.get(stockName).getQuantity());
            }

        }
        System.out.println("Stock Price based on trades recorded in past 15 minutes for given stock: " + stock + ": " + Math.round(tradePricexQuantity / totalQuantity) + " pence.");

    }

    public void CalcGeometricMean() {
        if (stockVOMap.isEmpty()) {
            throw new NullPointerException();
        }
        System.out.println("Problem   b.i:  Calculate the GBCE All Share Index using the geometric mean of prices for all stocks.");
        int stockNum = stockVOMap.size();
        long sumStockPrice = 1;
        for (String stock : stockVOMap.keySet()) {
            sumStockPrice *= stockVOMap.get(stock).getTradePrice();
        }
        double root = 1.0 / stockNum;
        double geo = Math.pow(sumStockPrice, root);
        System.out.println("GBCE All Share Index: " + geo);
    }
}
