package demopackage;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoMain {


    public static void main(String[] args){
        Stream<Integer> it = Stream.iterate(1000,(Integer n)->n+7000).limit(5);
        System.out.println(it.map(r->r).collect(Collectors.toList()));

    }
}
