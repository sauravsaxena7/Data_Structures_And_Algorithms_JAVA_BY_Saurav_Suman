package Multithreading.ThreadLocalVsVirtualThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalExample {
    public static void main(String[] args){
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

//        //mainThread
//        threadLocal.set(Thread.currentThread().getName());
//
//
//        Thread thread1 = new Thread(()->{
//            threadLocal.set(Thread.currentThread().getName());
//            System.out.println("inside thread1 of task1");
//            System.out.println("Inside thread1 threadLocal.get(): "+threadLocal.get());
//        });
//
//        thread1.start();
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("Inside main thread threadLocal.get(): "+threadLocal.get());
//

        ExecutorService poolObj = Executors.newFixedThreadPool(2);
        poolObj.submit(()->{
            threadLocal.set(Thread.currentThread().getName());
            //for cleaning the threadLocal variable
            threadLocal.remove();

        });

        for (int i=1;i<=15;i++){
            poolObj.submit(()->{
                System.out.println(threadLocal.get());
            });
        }
        poolObj.shutdown();
    }
}
