package com.github.pocan.borsaAPI;


/**
 * @author Pocan
 * @since 10.11.2023
 * @version 1.0.0
 * <code>com.github.pocan.borsaAPI.StockSymbol</code> class
 * <p>StockSymbol class</p>
 */
public class StockSymbol {

    private String stockSymbol;
    public StockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    @Override
    public String toString() {
        return "com.github.pocan.borsaAPI.StockSymbol{" +
                "stockSymbol='" + stockSymbol + '\'' +
                '}';
    }
}
