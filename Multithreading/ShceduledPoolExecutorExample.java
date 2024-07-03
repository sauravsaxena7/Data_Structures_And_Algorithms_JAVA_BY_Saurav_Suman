package Multithreading;

import java.util.concurrent.*;

public class ShceduledPoolExecutorExample {

    public static void main(String[] args){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

//        scheduledExecutorService.schedule(()->{
//            System.out.println("hello i am From Runnable i am not returning any thing.");
//        },5, TimeUnit.SECONDS);
//
//        Future<String> future=scheduledExecutorService.schedule(()->{
//            return "hello i am From Callable i am returning String vALUE.";
//        },5, TimeUnit.SECONDS);
//
//        try {
//            System.out.println("Call callable future.get(): "+future.get());
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }


//        Future<?> future=scheduledExecutorService.scheduleAtFixedRate(()->{
//
//
//            System.out.println("Hello");
//
//
//        },3,5,TimeUnit.SECONDS);
//
//        try {
//            Thread.sleep(10000);
//            future.cancel(true);
//            System.out.println("Task Will cancel abruptly");
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }


        Future<?> future=scheduledExecutorService.scheduleWithFixedDelay(()->{
            System.out.println("Thread Pick that the task.");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread completed the task.");

        },1,3,TimeUnit.SECONDS);
        //scheduledExecutorService.shutdown();
    }

}
