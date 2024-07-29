package com.example.observerpattern;
import java.util.ArrayList;
import java.util.List;


interface Stock {
    void register(Observer o);
    void deregister(Observer o);
    void notifyObservers();
}
//package com.example.observerpattern;


class StockMarket implements Stock {
    private List<Observer> observers;
    private double stockPrice;

    public StockMarket() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void deregister(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockPrice);
        }
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }
}
//package com.example.observerpattern;

interface Observer {
    void update(double stockPrice);
}
//package com.example.observerpattern;

class MobileApp implements Observer {
    private String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(double stockPrice) {
        System.out.println(appName + " received stock price update: " + stockPrice);
    }
}

//package com.example.observerpattern;

class WebApp implements Observer {
    private String appName;

    public WebApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(double stockPrice) {
        System.out.println(appName + " received stock price update: " + stockPrice);
    }
}
//package com.example.observerpattern;

public class ObserverPatternTest {
    public static void main(String[] args) {
        // Create a StockMarket instance
        StockMarket stockMarket = new StockMarket();

        // Create observer instances
        Observer mobileApp1 = new MobileApp("MobileApp1");
        Observer mobileApp2 = new MobileApp("MobileApp2");
        Observer webApp1 = new WebApp("WebApp1");

        // Register observers
        stockMarket.register(mobileApp1);
        stockMarket.register(mobileApp2);
        stockMarket.register(webApp1);

        // Change stock price and notify observers
        stockMarket.setStockPrice(100.50);
        System.out.println("");

        // Deregister an observer and change stock price again
        stockMarket.deregister(mobileApp2);
        stockMarket.setStockPrice(105.75);
    }
}
