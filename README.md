# borsaAPI

an api that allows you to access data related to BIST stock market stocks using the java language.


## Getting Started

The latest jar can be downloaded from the [releases](https://github.com/Pocanistaken/borsaAPI/releases) page.

If you use Maven for Dependency management, you can include this using below dependency.

```
<dependency>
  <groupId>com.github.pocan</groupId>
  <artifactId>borsaAPI</artifactId>
  <version>1.0.0</version>
</dependency>
```

## Avaliable Methods

```
getCurrentlyPrice(); // @return Get currently price of the stock symbol.
getCurrentlyRate(); // @return Get currently rate of the stock symbol.
getCurrentlyLossOfPrice(); // @return Get currently loss of price the stock symbol.
getLatestUpdateTime(); // @return Get currently latest update time of the stock symbol.
getStockSymbolName(); // @return Get stock symbol name.
```

## Exceptions

- StockSymbolCantFindException - > This exception catchs when you will write a unvalid stock symbol check all stock symbol names in [here](https://bigpara.hurriyet.com.tr/api/v1/hisse/list) 


## Usage

```
import com.github.pocan.borsaAPI.StockExchange;
import com.github.pocan.borsaAPI.StockSymbol;

public class Main {

    public static void main(String[] args) {

        StockSymbol stockSymbol = new StockSymbol("TABGD");
        StockExchange stockExchange = new StockExchange(stockSymbol);

        String stockSymbolName = stockExchange.getStockSymbolName();
        String price = stockExchange.getCurrentlyPrice();
        String latestUpdate = stockExchange.getLatestUpdateTime();
        String rate = stockExchange.getCurrentlyRate();
        String loss = stockExchange.getCurrentlyLossOfPrice();

        System.out.println("Symbol -> " + stockSymbolName);
        System.out.println("Price -> " + price + " TRY");
        System.out.println("Rate -> %" + rate);
        System.out.println("Latest Update Time -> " + latestUpdate);
        System.out.println("Loss > " + loss + " TRY");
        
    }
}

```

## Output

```
Symbol -> TABGD
Price -> 180,7 TRY
Rate -> %-0,99
Latest Update Time -> 18:09
Loss > -1.8 TRY
```

