package Multithreading.DeadLockImplementation;

public class DeadLockExampleMain {
    public static void main(String[] args) throws Exception{
        SharedResources sharedResources = new SharedResources();
        System.out.println("main thread started");

        Thread th1 = new Thread(()->{
            System.out.println("Thread1 is calling");
            sharedResources.produce();
        });

//        Thread th2 = new Thread(()->{
//            try {
//                //here we knowingly wanted to aucquire lock by thread 1
//                Thread.sleep(1000);
//            }catch (Exception e){
//                System.out.println(e.getMessage());
//            }
//            sharedResources.produce();
//        });

        th1.setDaemon(true);
        th1.start();
//        th2.start();
//
//        try {
//            System.out.println("thread 2 calling produce method");
//            Thread.sleep(3000);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        System.out.println("Thread is suspended");
//        th1.suspend();

//        try{
//            System.out.println("Main thread is waiting for thread th1 to complete their task");
//            th1.join();
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
        System.out.println("Main thread finising it's work");

    }
}
