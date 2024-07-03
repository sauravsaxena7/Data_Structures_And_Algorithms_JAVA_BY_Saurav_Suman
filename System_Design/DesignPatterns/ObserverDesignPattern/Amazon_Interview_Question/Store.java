package System_Design.DesignPatterns.ObserverDesignPattern.Amazon_Interview_Question;

import System_Design.DesignPatterns.ObserverDesignPattern.Amazon_Interview_Question.Observable.IphoneObservableImple;
import System_Design.DesignPatterns.ObserverDesignPattern.Amazon_Interview_Question.Observable.StockObservable;
import System_Design.DesignPatterns.ObserverDesignPattern.Amazon_Interview_Question.Observer.EmailObserverImple;
import System_Design.DesignPatterns.ObserverDesignPattern.Amazon_Interview_Question.Observer.MobileObserverImple;
import System_Design.DesignPatterns.ObserverDesignPattern.Amazon_Interview_Question.Observer.NotificationAlertObserver;

public class Store {
    public static void main(String[] args){
        StockObservable iphoneObservable = new IphoneObservableImple();
        NotificationAlertObserver observer1 = new EmailObserverImple("sauravsrivastava121@gmail.com",iphoneObservable);
        NotificationAlertObserver observer2 = new EmailObserverImple("gauravsrivastava2003mth@gmail.com",iphoneObservable);
        NotificationAlertObserver observer3 = new MobileObserverImple("7061036502",iphoneObservable);

        iphoneObservable.add(observer1);
        iphoneObservable.add(observer2);
        iphoneObservable.add(observer3);

        iphoneObservable.setStockCount(10);
    }
}

