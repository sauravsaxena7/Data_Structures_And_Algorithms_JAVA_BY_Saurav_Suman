package Multithreading;

class MyClass implements Runnable{

    @Override
    public void run() {
        System.out.println("code executed by thread in runnable run method of MyClass: "+Thread.currentThread().getName());
    }
}

public class CreatingThreadByImplementingRunnable {

    public static void main(String[] args){

        System.out.println("Going inside the main method thread: "+Thread.currentThread().getName());
        MyClass myClassRunnableObj = new MyClass();

        Thread thread = new Thread(myClassRunnableObj);
        thread.start();
        System.out.println("Finish main method: "+Thread.currentThread().getName());
    }
}
