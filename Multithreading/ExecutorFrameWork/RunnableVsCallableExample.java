package Multithreading.ExecutorFrameWork;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class MyRunnableForUseCase2 implements Runnable{

    List<Integer> list;
    MyRunnableForUseCase2(List<Integer> list){
        this.list=list;
    }
    @Override
    public void run() {
        list.add(700);

    }
}

public class RunnableVsCallableExample {

    public static void main(String[] args){
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS,new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());


        //UseCase 1
        Future<?> futureObj= poolExecutor.submit(()->{
            System.out.println("this is the task, which thread will execute.");

        });
        try {
            Object obj = futureObj.get();
            System.out.println(obj==null);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        //UseCase2
        List<Integer> output = new ArrayList<>();
        Future<List<Integer>> futureObjUseCase2 = poolExecutor.submit(new MyRunnableForUseCase2(output),output);

        try {
            List<Integer> integerList = futureObjUseCase2.get();
            System.out.println("UseCaseResult2: "+integerList);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        //UseCase3

        Future<List<Integer>> futureObjUseCase3 = poolExecutor.submit(()->{
            System.out.println("Usecase3 3 With Callable");
            List<Integer> list = new ArrayList<>();
            list.add(300);
            return list;
        });

        try {
            List<Integer> integerList = futureObjUseCase3.get();
            System.out.println("UseCase3Result3: "+integerList);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        poolExecutor.shutdown();

    }



}
