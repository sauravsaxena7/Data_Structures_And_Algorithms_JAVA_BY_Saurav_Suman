package Multithreading.Lock_and_semaphores;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockONTWoObjects {

    public static void main(String[] args){
        ReentrantLock reentrantLock = new ReentrantLock();
        ReadWriteLock  readWriteLock = new ReentrantReadWriteLock();
        SharedResources resources1 = new SharedResources();
        Thread th1 = new Thread(()->{
            //resources1.reenTrantLockProducer(reentrantLock);
            resources1.readWriteProducer(readWriteLock);
        });


        //already shared lock apply on resources1 by thread th1
        Thread th2 = new Thread(()->{
            //resources2.reenTrantLockProducer(reentrantLock);
            resources1.readWriteProducer(readWriteLock);
        });

        //already shared lock apply on rearWriteConsumerBlock by thread th1 and th2 , and we are try to apply Xclusive lock on re
        SharedResources resources2 = new SharedResources();
        Thread th3 = new Thread(()->{
            //resources2.reenTrantLockProducer(reentrantLock);
            resources1.readWriteConsumer(readWriteLock);
        });


//        th1.start();
//        th2.start();
//        th3.start();

        Thread tryOptimisticThread1 = new Thread(()->{
            resources1.readWriteOptimisticStampProducer();
        });

        Thread tryOptimisticThread2 = new Thread(()->{
            resources1.readWriteOptimisticStampConsumer();
        });

//        tryOptimisticThread1.start();
//        tryOptimisticThread2.start();

        Thread t1 = new Thread(()->{
            resources1.semaPhoreProducer();
        });
        Thread t2 = new Thread(()->{
            resources1.semaPhoreProducer();
        });
        Thread t3 = new Thread(()->{
            resources1.semaPhoreProducer();
        });
        Thread t4 = new Thread(()->{
            resources1.semaPhoreProducer();
        });

//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();

        Thread t = new Thread(()->{
            resources1.reentrantLockConditionProducer();
        });

        Thread tt = new Thread(()->{
            resources1.reentrantLockConditionConsumer();
        });
//        t.start();
//        tt.start();

//        for (int i=0;i<400;i++){
//            resources1.increment();
//        }
        //System.out.println("main threadresources1.get(): "+resources1.get());

        Thread lt1 = new Thread(()->{
            for (int i=0;i<10000;i++){
                resources1.increment();
            }
        });
        Thread lt2 = new Thread(()->{
            for (int i=0;i<10000;i++){
                resources1.increment();
            }
        });
//        lt1.start();
//        lt2.start();


        Thread lt3 = new Thread(()->{
            for (int i=0;i<10000;i++){
                resources1.atomicIntegerCounterIncrement();
            }
        });
        Thread lt4 = new Thread(()->{
            for (int i=0;i<10000;i++){
                resources1.atomicIntegerCounterIncrement();
            }
        });
        lt3.start();
        lt4.start();


        try {
            lt3.join();
            lt4.join();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

       // System.out.println("lt1 & lt2 thread threadresources1.get(): "+resources1.get());
        System.out.println("lt3 & lt4 thread threadresources1.get(): "+resources1.getAtomicInteger());

    }
}
