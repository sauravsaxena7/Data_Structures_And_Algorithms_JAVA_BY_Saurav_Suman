package Multithreading;


class MonitorLock{
    public synchronized void task1(){
        try{
           System.out.println("Inside synchronizes task 1");
           Thread.sleep(10000);
           System.out.println("Inside synchronizes task 1 completed");
        }catch (Exception e){
            System.out.println("Exception: "+e.getMessage());
        }
    }

    public void task2(){
        System.out.println("task 2, but before synchronized");
        //synchronized block
        synchronized (this){
            System.out.println("task2, Inside synchronized block");
        }
    }

    public void task3(){
        System.out.println("task3 without synchronized block");
    }


}

public class MonitorLocksExample {
    public static void main(String[] args){

        MonitorLock monitorLockObj = new MonitorLock();

        Thread t1 = new Thread(()->{monitorLockObj.task1();});
        Thread t2 = new Thread(()->{monitorLockObj.task2();});
        Thread t3 = new Thread(()->{monitorLockObj.task3();});

        t1.start();
        t2.start();
        t3.start();
    }
}
