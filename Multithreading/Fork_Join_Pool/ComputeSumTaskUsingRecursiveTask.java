package Multithreading.Fork_Join_Pool;


import java.util.concurrent.*;

class ComputeSumTask extends RecursiveTask<Integer>{
    int start;
    int end;

    ComputeSumTask(int start,int end){
        this.start=start;
        this.end=end;
    }


    @Override
    protected Integer compute() {
        if(end-start<=4){
            int totalSum = 0;
            for(int i=start;i<=end;i++){
                totalSum+=i;
            }
            return totalSum;
        }else{
            //split
            int mid = (start+end)/2;
            ComputeSumTask leftTask = new ComputeSumTask(start,mid);
            ComputeSumTask rightTask = new ComputeSumTask(mid+1,end);

            //Fork the Subtasks for parallel execution;
            leftTask.fork();
            rightTask.fork();

            //combine the results of subtasks
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            //combine the result
             return leftResult+rightResult;
        }

    }
}


public class ComputeSumTaskUsingRecursiveTask {
    public static void main(String[] args){
        ForkJoinPool pool = ForkJoinPool.commonPool();
        Future<Integer> future = pool.submit(new ComputeSumTask(0,100));

//        try
//        {
//            System.out.println("FINAL RESULT: "+future.get());
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }

        ExecutorService poolObj = Executors.newFixedThreadPool(5);
        poolObj.submit(()->{
            try {
                Thread.sleep(15000);
            }catch (Exception e){
                System.out.println("Exception: "+e.getMessage());
            }
            System.out.println("Task completed");

        });

        poolObj.shutdownNow();


//        try {
//            boolean isTerminated = poolObj.awaitTermination(2,TimeUnit.SECONDS);
//            System.out.println("isTerminated "+isTerminated);
//
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }

        System.out.println("Main thread completed");
    }
}
