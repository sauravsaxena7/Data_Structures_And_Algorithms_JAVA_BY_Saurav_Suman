package Multithreading.ActualProsucerConsumerProblem;

public class ProducerConsumerMain {
    public static void main(String[] args){

        SharedResources sharedResources = new SharedResources(3);
        //creating producer thread using Lambda expression;
        Thread producerThread = new Thread(()->{
            try{
                for (int i=1;i<=6;i++){
                    sharedResources.produce(i);
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        });

        //creting consumer thread
        Thread consumerThread = new Thread(()->{
            try{
                for (int i=1;i<=6;i++){
                    sharedResources.consume();
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        });
        producerThread.start();
        consumerThread.start();
    }
}
