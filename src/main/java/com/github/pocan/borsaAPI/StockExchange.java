package com.github.pocan.borsaAPI;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * @author Pocan
 * @since 10.11.2023
 * @version 1.0.0
 * <code>com.github.pocan.borsaAPI.StockExchange</code> class
 * <p>StockExchange class</p>
 */

public class StockExchange implements IStockExchange {

    private StockSymbol stockSymbol;

    /**
     *
     * @param stockSymbol Stock Symbol.
     */
    public StockExchange(StockSymbol stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    /**
     * Get currently price of the stock symbol.
     * @return String
     */
    @Override
    public String getCurrentlyPrice() {
        return getStockSymbol(stockSymbol, getCurrentlyRequest()).get(1);
    }

    /**
     * Get currently rate of the stock symbol.
     * @return String
     */
    @Override
    public String getCurrentlyRate() {
        return getStockSymbol(stockSymbol, getCurrentlyRequest()).get(2);
    }

    /**
     * Get currently latest update time of the stock symbol.
     * @return String
     */
    @Override
    public String getLatestUpdateTime() {
        return getStockSymbol(stockSymbol, getCurrentlyRequest()).get(3);
    }

    /**
     * Get stock symbol name.
     * @return String
     */
    @Override
    public String getStockSymbolName() {
        return getStockSymbol(stockSymbol, getCurrentlyRequest()).get(0);
    }

    /**
     *
     * Get currently loss of price the stock symbol.
     * @return String
     */
    @Override
    public String getCurrentlyLossOfPrice() {
        return getStockSymbol(stockSymbol, getCurrentlyRequest()).get(4);
    }

    private ArrayList<String> getStockSymbol(StockSymbol stockSymbol, ArrayList<String> arrayList) {
        ArrayList<String> stockSymbolListFeatures = new ArrayList<>();
        int findIndex = -1;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).contains(stockSymbol.getStockSymbol())) {
                findIndex = i;
                break;
            }
        }
        if (findIndex != -1) {
            String findLine = arrayList.get(findIndex);
            String[] veriler = findLine.split(", ");
            for (String veri : veriler) {
                    String[] parcalar = veri.split("\\|");
                    for (String parca : parcalar) {
                        stockSymbolListFeatures.add(parca);
                }
            }
        }
        else {
            throw new RuntimeException("StockSymbol can't find.");

        }
        return stockSymbolListFeatures;
    }

    private ArrayList<String> getCurrentlyRequest() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String apiUrl = "https://www.sabah.com.tr/json/canli-borsa-verileri";

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            String[] kelimeler = new String[0];

            while ((line = reader.readLine()) != null) {
                kelimeler = line.split("~");
            }
            reader.close();

            for (String s : kelimeler) {
                arrayList.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
            }
        return arrayList;
    }

}
