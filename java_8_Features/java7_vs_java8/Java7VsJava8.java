package java_8_Features.java7_vs_java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java7VsJava8 {

    public static void main(String[] args){
        System.out.println("Java7 VS Java8");

        //in java 7
        int sum=0;
        for(int i=0;i<=50;i++){
            sum+=i;
        }
        System.out.println("Java 7 sum " +sum);

        //in java 8
        int total = IntStream.rangeClosed(0,50).map(num->Integer.parseInt(String.valueOf(num))).sum();
        int total2 = IntStream.rangeClosed(0,50).sum();

        System.out.println("java8 total "+total);
        System.out.println("java8 total2 "+total2);



        List<String> names = Arrays.asList("saurav","suman","faoo","lola","pola",
                "suman","faoo","gaurav","saurav","saroj","gaurav","faoo");

        //In hava 7
        List<String> uniqueNames = new ArrayList<>();
        for(String name:names){
            if(!uniqueNames.contains(name)){
                uniqueNames.add(name);
            }
        }

        System.out.println("in java 7 uniquesName "+ uniqueNames );

        //In java 8
        uniqueNames=names.stream().distinct().collect(Collectors.toList());
        System.out.println("in java 8 using stream uniquesName "+ uniqueNames );


        //Lambda Expression Java 7 and Java 8

        //In java 7
        System.out.println("IN JAVA 7 vs JAVA 8 Lambda expression");
        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Java 7 In Runnable thread 1");
            }
        };
        new Thread(t1).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Java 7 In Runnable thread 1 inline implement");
            }
        }).start();


        //In Java 8 using lambda expression
        Runnable t2 = ()->{System.out.println("In java 8 from runnable thread lambda expression");};
        new Thread(t2).start();
        new Thread(()->System.out.println("In java 8 from runnable thread inline lambda expression")).start();



        //Comparator in Java 7 vs Java 8
        System.out.println("IN JAVA 7 vs JAVA 8 Comparator");

        //In java 7
        Comparator<Integer> c1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        System.out.println("comparing value 15,10 in java 7 using comparator "+c1.compare(15,10));

        //In Java 8
        Comparator<Integer> c2 = (Integer o1,Integer o2)->o1.compareTo(o2);
        System.out.println("comparing value 15,10 in java 8 using comparator in lambda expression "+c2.compare(15,10));




    }


}
