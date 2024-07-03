package Multithreading.Lock_and_semaphores;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;

public class SharedResources {
    boolean isAvailable = true;
    public synchronized void producer(){
        try {
            System.out.println("Lock acquire by: "+Thread.currentThread().getName());
            isAvailable=true;
            Thread.sleep(4000);
            System.out.println("Lock releases by: "+Thread.currentThread().getName());
        }catch (Exception e){
           System.out.println(e.getMessage());
        }
    }



    public void reenTrantLockProducer( ReentrantLock reentrantLock){

        try {
            reentrantLock.lock();
            System.out.println("ReentrantLock acquire by: "+Thread.currentThread().getName());
            isAvailable=true;
            Thread.sleep(4000);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            reentrantLock.unlock();
            System.out.println("ReentrantLock releases by: "+Thread.currentThread().getName());
        }

    }


    public void readWriteProducer(ReadWriteLock readWriteLock){

        try {
            readWriteLock.readLock().lock();
            System.out.println("ReadWritLock For Producer READ LOCK acquire by: "+Thread.currentThread().getName());
            isAvailable=true;
            Thread.sleep(8000);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            readWriteLock.readLock().unlock();
            System.out.println("ReadWritLock For Producer READ LOCK releases by: "+Thread.currentThread().getName());

        }

    }

    public void readWriteConsumer(ReadWriteLock readWriteLock){

        try {
            readWriteLock.writeLock().lock();
            System.out.println("ReadWritLock For Consumer READ LOCK acquire by: "+Thread.currentThread().getName()+" consumer thread");
            isAvailable=false;
            Thread.sleep(8000);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            readWriteLock.writeLock().unlock();
            System.out.println("ReadWritLock For Consumer READ LOCK releases by: "+Thread.currentThread().getName()+" consumer thread");

        }

    }

    StampedLock stampedLock = new StampedLock();


    public void readWriteStampProducer(){
        long stamp= stampedLock.readLock();

        try {
            //it returns some version id

            System.out.println("STAMPReadWritLock For Producer READ LOCK acquire by: "+Thread.currentThread().getName());
            isAvailable=true;
            Thread.sleep(8000);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            stampedLock.unlockRead(stamp);
            System.out.println("StampReadWritLock For Producer READ LOCK releases by: "+Thread.currentThread().getName());

        }

    }



    int a = 10;
    public void readWriteOptimisticStampProducer(){
        long stamp= stampedLock.tryOptimisticRead();
        try {
            a=11;
            Thread.sleep(6000);
            if (stampedLock.validate(stamp)){
                System.out.println("readWriteOptimisticStampProducer Value Update Successfully " +Thread.currentThread().getName());
            }else{
                a=10;
                System.out.println("readWriteOptimisticStampProducer Value Update ROLLBACK " +Thread.currentThread().getName());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    public void readWriteOptimisticStampConsumer(){
        long stamp = stampedLock.writeLock();
        System.out.println("readWriteOptimisticStampConsumer Write LOCK acquire by: "+Thread.currentThread().getName()+" consumer thread");
        try {

            System.out.println("readWriteOptimisticStampConsumer Performing some work "+Thread.currentThread().getName());
           a=9;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            stampedLock.unlockWrite(stamp);
            System.out.println("readWriteOptimisticStampConsumer write releases by: "+Thread.currentThread().getName()+" consumer thread");

        }
    }


    //two threads acquire same resorces as per permits
    Semaphore semaphoreLock = new Semaphore(2);


    public void semaPhoreProducer(){
        long stamp= stampedLock.tryOptimisticRead();
        try {
           semaphoreLock.acquire();
            Thread.sleep(4000);
            System.out.println("semaPhoreProducer lock acquire: "+Thread.currentThread().getName());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            semaphoreLock.release();
            System.out.println("semaPhoreProducer lock releases: "+Thread.currentThread().getName());

        }


    }

    ReentrantLock reentrantLockCondition = new ReentrantLock();
    Condition condition = reentrantLockCondition.newCondition();

    public void reentrantLockConditionProducer(){
        try {
            reentrantLockCondition.lock();
            System.out.println("reentrantLockCondition lock acqyuire by: "+Thread.currentThread().getName());

            if (isAvailable){
                //already available, thread has to wait for it to consume
                System.out.println("reentrantLockCondition thread is waiting:"+Thread.currentThread().getName());
                condition.await();;
            }
            isAvailable=true;
            condition.signal();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            reentrantLockCondition.unlock();
            System.out.println("reentrantLockConditionProducer lock releases by: "+Thread.currentThread().getName());

        }
    }

    public void reentrantLockConditionConsumer(){
        try {
            reentrantLockCondition.lock();
            System.out.println("reentrantLockConditionConsume lock acqyuire by: "+Thread.currentThread().getName());

            if (!isAvailable){
                //already available, thread has to wait for it to Produce
                System.out.println("reentrantLockConditionConsume thread is waiting:"+Thread.currentThread().getName());
                condition.await();;
            }
            isAvailable=false;
            condition.signal();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            reentrantLockCondition.unlock();
            System.out.println("reentrantLockConditionConsumer lock releases by: "+Thread.currentThread().getName());

        }
    }

    int counter;
    public void increment(){
        counter++;
    }

    public int get(){
        return counter;
    }

    AtomicInteger atomicIntegerCounter = new AtomicInteger(0);
    public void atomicIntegerCounterIncrement(){
        atomicIntegerCounter.incrementAndGet();
    }

    public int getAtomicInteger(){
        return atomicIntegerCounter.get();
    }

}
