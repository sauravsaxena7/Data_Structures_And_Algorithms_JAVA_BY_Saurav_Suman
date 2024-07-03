package Multithreading;

class MyThreadClass extends Thread{
    @Override
    public void run(){
        System.out.println("code executed by thread in extending thread class: "+Thread.currentThread().getName());
    }
}
public class CreatingThreadByExtendingThreadClass {

    public static void main(String[] args){
        System.out.println("Going inside the main method thread: "+Thread.currentThread().getName());

        MyThreadClass myThreadClass = new MyThreadClass();
        myThreadClass.start();
        System.out.println("Finish main method: "+Thread.currentThread().getName());
    }
}
