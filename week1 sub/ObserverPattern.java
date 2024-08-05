package deepskilling;

import java.util.ArrayList;
import java.util.List;

interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockPrice;

    public void setStockPrice(String stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }
}

interface Observer {
    void update(String stockPrice);
}

class MobileApp implements Observer {
    @Override
    public void update(String stockPrice) {
        System.out.println("MobileApp: Stock price updated to " + stockPrice);
    }
}

class WebApp implements Observer {
    @Override
    public void update(String stockPrice) {
        System.out.println("WebApp: Stock price updated to " + stockPrice);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice("100 USD");
        stockMarket.setStockPrice("105 USD");

        stockMarket.deregisterObserver(mobileApp);

        stockMarket.setStockPrice("110 USD");
    }
}
