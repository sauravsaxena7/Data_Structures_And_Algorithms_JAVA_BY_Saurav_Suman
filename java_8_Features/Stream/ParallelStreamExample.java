package java_8_Features.Stream;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamExample {
    public static void main(String[] args){
        List<Integer> numbers  = Arrays.asList(11,22,33,44,55,66,77,88,99,110);

        //Sequential Processing
        System.out.println("Sequential Processing");

        long sequentialProcessingStartTime = System.currentTimeMillis();
        numbers.stream().map((val)->val*val)
                .forEach((val)->System.out.print(val+" "));
        System.out.println();

        System.out.println("Sequential Processing time taken: "+(System.currentTimeMillis()-sequentialProcessingStartTime)+" milisecond");


        //Parallel Processing
        System.out.println("Parallel Processing");

        long parallelProcessingStartTime = System.currentTimeMillis();
        numbers.parallelStream().map((val)->val*val)
                .forEach((val)->System.out.print(val+" "));
        System.out.println();

        System.out.println("Parallel Processing time taken: "+(System.currentTimeMillis()-parallelProcessingStartTime)+" milisecond");



    }
}
