package Multithreading.ExecutorFrameWork;

import java.util.concurrent.*;

class CustomThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setPriority(Thread.NORM_PRIORITY);
        thread.setDaemon(false);
        //thread.setName("lola");
        return thread;

    }
}

class CustomRejectHandler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task Rejected: "+r.toString());

    }
}


public class ThreadPoolExecutorExample {
    public static void main(String[] args){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,10,
                TimeUnit.MINUTES,new ArrayBlockingQueue<>(2),
                new CustomThreadFactory(),
               // new ThreadPoolExecutor.DiscardOldestPolicy()
                new CustomRejectHandler()

        );
        executor.allowCoreThreadTimeOut(true);

        for (int i=1;i<=7;i++){
            //accepts runnable
            int finalI = i;
            executor.submit(()->{
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Task"+ finalI + " Processed by: "+ Thread.currentThread().getName());
            });
        }
        executor.shutdown();


        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,1,1,TimeUnit.HOURS,new ArrayBlockingQueue<>(2),Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        //new Thread will be created and it will perform the task.
       Future<?> futureObj= poolExecutor.submit(()->{
            System.out.println("this is the task, which thread will execute.");

        });//Now what is caller want to know the status of the thread1. Whether it's completed or failed etc.

        System.out.println(futureObj.isDone());

        poolExecutor.shutdown();

        //main thread all continue to processing it.


    }
}
