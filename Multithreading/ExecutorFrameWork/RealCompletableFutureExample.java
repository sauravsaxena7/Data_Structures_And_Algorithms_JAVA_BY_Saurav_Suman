package Multithreading.ExecutorFrameWork;

import java.util.concurrent.*;

public class RealCompletableFutureExample {
    public static void main(String[] args){
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,1,1,
                TimeUnit.HOURS,new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());



//        try {
//            CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(()->{
//                //This is the task which need to to be completed by thread.
//                System.out.println("asyncTask1 in supplyAsync thread name: "+Thread.currentThread().getName());
//                return "Saurav ";
//            },poolExecutor).thenApply((String val)->{
//                System.out.println("asyncTask1 in thenApply thread name: "+Thread.currentThread().getName());
//                return val+"Saxena";
//            });
//
//            System.out.println("asyncTask1.get(): "+ asyncTask1.get());
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }





//        try {
//            CompletableFuture<String> asyncTask2 = CompletableFuture.supplyAsync(()->{
//                //This is the task which need to to be completed by thread.
//                System.out.println("asyncTask2 in supplyAsync thread name: "+Thread.currentThread().getName());
//                try {
//                    Thread.sleep(8000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                return "Saurav ";
//            },poolExecutor);
//
//            CompletableFuture<String> thenApplyAsync=asyncTask2.thenApplyAsync((String val)->{
//                System.out.println("asyncTask2 in thenApplyAsync thread name: "+Thread.currentThread().getName());
//                return val+"Saxena";
//            },poolExecutor);
//            System.out.println(" asyncTask2.get(): "+ asyncTask2.get());
//            System.out.println("thenApplyAsync thenApplyAsync.get(): "+ thenApplyAsync.get());
//        } catch (Exception e) {
//            System.out.println("Ex=> "+e.getMessage());
//        }



//                try {
//            CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(()->{
//                //This is the task which need to to be completed by thread.
//                System.out.println("asyncTask1 in supplyAsync thread name: "+Thread.currentThread().getName());
//                return "Saurav ";
//            },poolExecutor).thenCompose((val)->CompletableFuture.supplyAsync(()->val+"lola "));// order always maintained
//            //in case of thenComposeAsync we can pass executor.
//         CompletableFuture<String> thenComposes =  asyncTask1.thenCompose((String val)->{
//                System.out.println("thenComposes thread name: "+Thread.currentThread().getName());
//                 return CompletableFuture.supplyAsync(()->val+"Saxena");
//            });
//         asyncTask1.thenAccept((val)->System.out.println("All stage complete of asyncTask1 final value is: "+val));
//
//            System.out.println("asyncTask1.get(): "+ asyncTask1.get());
//            System.out.println("thenComposes.get(): "+ thenComposes.get());
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }



        try{
            CompletableFuture<Integer> asyncTask3 = CompletableFuture.supplyAsync(()->{
                return 10;
            },poolExecutor);

            CompletableFuture<String> asyncTask4 = CompletableFuture.supplyAsync(()->{
                return "k";
            });
            CompletableFuture<String> combineFutureObj =  asyncTask3.thenCombine(asyncTask4,(Integer num,String str)->{
                return num.toString()+str;
            });

            System.out.println("combineFutureObj.get(): "+combineFutureObj.get());

         }catch (Exception e){
            System.out.println(e.getMessage());
        }

        poolExecutor.shutdown();

    }
}
