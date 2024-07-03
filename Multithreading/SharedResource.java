package Multithreading;

public class SharedResource {
    boolean itemAvailable = false;

    //synchronized put the monitor lock
    public synchronized  void addItem(){
        itemAvailable=true;
        System.out.println("Item added by: "+Thread.currentThread().getName()+" and invoking all threads");
        notifyAll();// who ever waiting on this object will be notify
    }

    public synchronized void consumeItem(){
        System.out.println("Consume Item method invoked by: "+Thread.currentThread().getName());
        //using while loop to avoid "spurious wake-up", sometimes because of system noise
        while (!itemAvailable){
            try{
                System.out.println("Thread "+ Thread.currentThread().getName()+" is waiting for resource");
                wait();//it releases the all the monitor lock
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Item Consumed by: "+Thread.currentThread().getName());
        itemAvailable=false;
    }
}
