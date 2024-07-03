package System_Design.DesignPatterns.ObserverDesignPattern.Amazon_Interview_Question.Observer;

import System_Design.DesignPatterns.ObserverDesignPattern.Amazon_Interview_Question.Observable.StockObservable;

public class EmailObserverImple implements NotificationAlertObserver{

    String emailId;
    StockObservable observable;
    //Constructor Injections
    public EmailObserverImple(String emailId, StockObservable observable){
        this.emailId=emailId;
        this.observable = observable;
    }
    @Override
    public void update() {
        sendEmail(emailId,"Product Is In-Stock hurry up!");

    }

    private void sendEmail(String emailId, String s) {
        System.out.println("mail sent to: "+ emailId);
    }
}
