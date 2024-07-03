package System_Design.DesignPatterns.ObserverDesignPattern.Amazon_Interview_Question.Observable;

import System_Design.DesignPatterns.ObserverDesignPattern.Amazon_Interview_Question.Observer.NotificationAlertObserver;

public interface StockObservable {
        public void add(NotificationAlertObserver obj);
        public void remove(NotificationAlertObserver obj);
        public void setStockCount(int newStockCount);
        public void notifySubscribers();
        public int getStockCount();
}
