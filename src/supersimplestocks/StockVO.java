/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superSimpleStocks;

/**
 *
 * @author geo53576
 */
public class StockVO {

    private final String type;
    private final int lastDividend;
    private final double fixedDividend;
    private final int parValue;
    private final long tickerPrice;
    private final Long timeInMillis;
    private final String indicator;
    private final int quantity;
    private final double tradePrice;
    private int occurrences;

    StockVO(String type, int lastDividend, double fixedDividend, int parValue, long tickerPrice, Long timeInMillis, String indicator, int quantity, int occurrences, double tradePrice) {
        this.type = type;
        this.lastDividend = lastDividend;
        this.fixedDividend = fixedDividend;
        this.parValue = parValue;
        this.tickerPrice = tickerPrice;
        this.timeInMillis = timeInMillis;
        this.indicator = indicator;
        this.quantity = quantity;
        this.occurrences = occurrences;
        this.tradePrice = tradePrice;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the lastDividend
     */
    public int getLastDividend() {
        return lastDividend;
    }

    /**
     * @return the fixedDividend
     */
    public double getfixedDividend() {
        return fixedDividend;
    }

    /**
     * @return the parValue
     */
    public int parValue() {
        return parValue;
    }

    /**
     * @return the tickerPrice
     */
    public long getTickerPrice() {
        return tickerPrice;
    }

    /**
     * @return the timeInMillis
     */
    public Long getTimeInMillis() {
        return timeInMillis;
    }

    /**
     * @return the indicator
     */
    public String getIndicator() {
        return indicator;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @return the occurrences
     */
    public int getOccurrences() {
        return occurrences;
    }

    /**
     * @param occurrences the occurrences to set
     */
    public void setOccurrences(int occurrences) {
        this.occurrences = occurrences;
    }

    /**
     * @return the tradePrice
     */
    public double getTradePrice() {
        return tradePrice;
    }

}
