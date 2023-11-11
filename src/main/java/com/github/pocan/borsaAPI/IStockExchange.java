package com.github.pocan.borsaAPI;

/**
 * @author Pocan
 * @since 10.11.2023
 * @version 1.0.0
 * <code>com.github.pocan.borsaAPI.IStockExchange</code> <b>Interface</b>
 * <p>get current price, get current rate , get current loss of price , get current latest update time , get stock symbol name</p>
 */

public interface IStockExchange {

    String getCurrentlyPrice();

    String getCurrentlyRate();

    String getCurrentlyLossOfPrice();

    String getLatestUpdateTime();

    String getStockSymbolName();

}
