package Multithreading;

public class Main {
    public static void main(String[] args){
        System.out.println("Main Method Start");
        SharedResource sharedResource = new SharedResource();

        //producer thread
        Thread produceThread = new Thread(new ProduceTask(sharedResource));

        //consumer thread
        Thread consumerThread = new Thread(new ConsumeTask(sharedResource));

        //thread is in "RUNNABLE STATE"
        produceThread.start();
        consumerThread.start();

        System.out.println("Main method end");
    }
}
