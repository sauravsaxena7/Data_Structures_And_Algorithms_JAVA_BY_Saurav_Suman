package java_8_Features;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

interface FunctionalInterface{
    //an abstract method
    void abstractFunction(int x);

    default void normalFunction(){
        System.out.println("I am normal function");
    }


}
public class LambdaExpression {
    public static void main(String[] args){

        //here we are implmenting abstract mehod
        FunctionalInterface functionalInterfaceObject= ((int x)->{
            System.out.println("SEE the value of 2x+"+2*x);
        });
        functionalInterfaceObject.abstractFunction(3);
        functionalInterfaceObject.normalFunction();

        List<Integer> arr = List.of(1, 2, 3, 4, 5, 6, 7);
        List<Integer> even
                = arr.stream().reduce(new ArrayList<Integer>(),
                (a, b)
                        -> {
                    if (b % 2 == 0)
                        a.add(b);
                    return a;
                },
                (a, b) -> {
                    a.addAll(b);
                    return a;
                });
        System.out.println(even);

        String[] myArray
                = "I am 24 years old and I want to be in Tier I company"
                .split(" ");

        // create a stream on myArray
        Stream<String> myStream = Stream.of(myArray);

        // filter by matching vowels regular expression
        myStream.filter(x -> x.matches("(a|e|i|o|u)\\w*"))
                .forEach(System.out::println);




    }
}
