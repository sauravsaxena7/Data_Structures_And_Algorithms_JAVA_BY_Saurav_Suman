package Multithreading.DeadLockImplementation;

public class SharedResources {
    boolean isAvailable = false;

    public synchronized void produce(){
        System.out.println("Lock Acquire.");
        isAvailable=true;
        try {
            Thread.sleep(8000);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Lock Release");
    }
}
