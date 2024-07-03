package java_8_Features.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args){
        List<Integer> salaries = new ArrayList<>();
        salaries.add(3000);
        salaries.add(7000);
        salaries.add(5000);
        salaries.add(15000);
        salaries.add(10000);
        salaries.add(1000);
        salaries.add(9000);
        int count = 0;
        for(Integer sal :salaries){
            if(sal>3000){
                count++;
            }
        }
        System.out.println("Total Employee with salary > 3000 without stream: "+count);
        System.out.println("Same operation using stream ");

        //default Stream<T> srtream(){return StreamSupport.stream(spliterator(), false);}

        long output = salaries.stream()
                .filter((sal)->sal>3000)
                .peek((str)->System.out.println(str))
                .count();

        System.out.println("Total Employee with salary > 3000 with stream: "+output);


        Stream<String> stringStream = Stream.of("how","are","you","?");
        List<String> stringList = stringStream.filter((str)->str.length()==3).collect(Collectors.toList());
        //List<String> stringMapList = stringStream.map((str)->str.toLowerCase()).collect(Collectors.toList());

        List<List<String>> listOfList = Arrays.asList(
                Arrays.asList("I","LOVE","JAVA"),
                Arrays.asList("CONCEPTS","ARE","CLEAR"),
                Arrays.asList("ITS","VERY","EASY")
        );

        List<String> flatStringListOfList = listOfList.stream().flatMap((list)->list.stream().map(str->str.toLowerCase())).collect(Collectors.toList());

        System.out.println("flatStringListOfList"+flatStringListOfList);

        List<String> numbers = Arrays.asList("2","4","7");
        IntStream numberStream = numbers.stream().mapToInt((String val)->Integer.parseInt(val));

        int[] numberArray = numberStream.toArray();

        int[] numbersArray = {1,2,3,5};
        IntStream numbersStream = Arrays.stream(numbersArray);
        numbersStream.filter((int val)->val>2);

        Arrays.asList(1,2,3,4,5).stream().map((i)->i*2).peek((v)->System.out.println(v));


        System.out.println("Sequence Of Stream Operations.");
        List<Integer> numList = Arrays.asList(2,1,4,10);
        Stream<Integer> numListStream = numList.stream()
                .filter((val)->val>=2)
                .peek((val)->System.out.println("after filter: "+val))
                .map((val)->(val*-1))
                .peek((val)->System.out.println("after negating:"+val))
                .sorted()
                .peek((val)->System.out.println("after Sorted: "+val));
        List<Integer> sequencOfOperationResult = numListStream.collect(Collectors.toList());
        System.out.println("sequencOfOperationResult: "+sequencOfOperationResult);
    }
}
