package java_8_Features;

public class ThreadUsingLambdaExpression {

    public static void main(String[] args){
        Runnable myThread= ()->{
            Thread.currentThread().setName("myThread");
            System.out.println("Current running thread is "+Thread.currentThread().getName());

        };
        Thread thread=new Thread(myThread);
        thread.run();
    }
}
