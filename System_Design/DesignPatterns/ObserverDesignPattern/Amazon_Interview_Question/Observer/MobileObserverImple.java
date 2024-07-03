package System_Design.DesignPatterns.ObserverDesignPattern.Amazon_Interview_Question.Observer;

import System_Design.DesignPatterns.ObserverDesignPattern.Amazon_Interview_Question.Observable.StockObservable;

public class MobileObserverImple implements NotificationAlertObserver{
    String phone;
    StockObservable observable;
    public MobileObserverImple(String phone,StockObservable observable){
        this.observable=observable;
        this.phone=phone;
    }


    @Override
    public void update() {
        sendMsg(phone,"Product is in stock hurry up.");
        //send the actual email to
    }

    private void sendMsg(String phone, String s) {
        System.out.println("message sent to phone: " +phone);
    }
}
