package System_Design.DesignPatterns.ObserverDesignPattern.Amazon_Interview_Question.Observable;

import System_Design.DesignPatterns.ObserverDesignPattern.Amazon_Interview_Question.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImple implements StockObservable{

    public List<NotificationAlertObserver> observerList = new ArrayList<>();
    public int stockCount = 0;

    @Override
    public void add(NotificationAlertObserver obj) {
        observerList.add(obj);
    }

    @Override
    public void remove(NotificationAlertObserver obj) {

        observerList.remove(obj);
    }

    @Override
    public void setStockCount(int newStockCount) {
        if (stockCount == 0){
            notifySubscribers();
        }
        stockCount = stockCount+newStockCount;
    }

    @Override
    public void notifySubscribers() {
        for (NotificationAlertObserver observer : observerList){
            observer.update();
        }

    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
