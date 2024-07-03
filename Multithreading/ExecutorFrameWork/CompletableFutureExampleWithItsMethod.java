package Multithreading.ExecutorFrameWork;

import java.sql.Time;
import java.util.concurrent.*;

public class CompletableFutureExampleWithItsMethod {
    public static void main(String[] args){
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS,new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        Future<?> futureObj= poolExecutor.submit(()->{
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("this is the task, which thread will execute.");

        });


        System.out.println("Is Done: "+futureObj.isDone());

        try {
            futureObj.get(2,TimeUnit.SECONDS);
        }catch (TimeoutException | InterruptedException | ExecutionException e){
            System.out.println("Ex->2"+e.getMessage());
        }

        try {
            futureObj.get();
            //here main thread will be blocked
        }catch (Exception e){
            System.out.println("Ex->1"+e.getMessage());
        }

        System.out.println("is done: "+futureObj.isDone());
        System.out.println("is cancelled: "+futureObj.isCancelled());

        poolExecutor.shutdown();

    }

}

