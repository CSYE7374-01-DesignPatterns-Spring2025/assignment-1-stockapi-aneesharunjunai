package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {

    private static volatile StockMarket instance;
    private final List<StockAPI> stocks;

    private StockMarket() {
        stocks = new ArrayList<>();
    }

    public static StockMarket getInstance() {
        if (instance == null) {
            synchronized (StockMarket.class) {
                if (instance == null) {
                    instance = new StockMarket();
                }
            }
        }
        return instance;
    }

    public void addStock(StockAPI stock) {
        stocks.add(stock);
    }

    public void showStocks() {
        for (Tradable stock : stocks) {
            System.out.println(stock);
        }
    }

    public void tradeStocks(String name, String bid) {
        for (StockAPI stock : stocks) {
            if(stock.getName().equals(name))
                stock.setBid(bid);
        }
    }

    public void removeStock(String name) {
        int index = -1;
        for (int i=0; i < stocks.size(); i++) {
            if(stocks.get(i).getName().equals(name))
                index = i;
        }
        if(index != -1)
            stocks.remove(index);
    }

    public void startTrade() {
        addStock(new SPCXStock("SpaceX Inc", 100, "SPCX"));
        addStock(new APPLStock("APPL Corp", 225, "APPL"));
        System.out.println("=== Stocks in the market ===");
        showStocks();

        tradeStocks("Tesla Inc", "110");
        tradeStocks("APPL Corp", "240");
        System.out.println("--- Result of Bid 1 ---");
        showStocks();

        tradeStocks("SpaceX Inc", "112");
        tradeStocks("APPL Corp", "242");
        System.out.println("--- Result of Bid 2 ---");
        showStocks();

        tradeStocks("SpaceX Inc", "128");
        tradeStocks("APPL Corp", "255");
        System.out.println("--- Result of Bid 3 ---");
        showStocks();

        tradeStocks("SpaceX Inc", "130");
        tradeStocks("APPL Corp", "250");
        System.out.println("--- Result of Bid 4 ---");
        showStocks();

        tradeStocks("SpaceX Inc", "140");
        tradeStocks("APPL Corp", "255");
        System.out.println("--- Result of Bid 5 ---");
        showStocks();

        tradeStocks("SpaceX Inc", "145");
        tradeStocks("APPL Corp", "265");
        System.out.println("--- Result of Bid 6 ---");
        showStocks();

        removeStock("SpaceX Inc");
        System.out.println("--- Removing stock - SpaceX Inc ---");
        showStocks();
    }


}
