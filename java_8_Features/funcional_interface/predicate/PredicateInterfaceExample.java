package java_8_Features.funcional_interface.predicate;

import java.util.function.Predicate;

public class PredicateInterfaceExample {

    //static Predicate<Persons> equalTo
    public static void main(String[] args){
        Predicate<Integer> lessThan = a->(a<=50);
        System.out.println("lessThan.test(90) "+lessThan.test(90));

        Predicate<Integer> greaterThan = a->a>=150;
        Predicate<Integer> equalTo = a->a==0;

        System.out.println("lessThan.and(greaterThan).and(equalTo).test(150) "+lessThan.and(greaterThan).and(equalTo).test(150));
        System.out.println("lessThan.or(greaterThan).or(equalTo).test(150) "+lessThan.or(greaterThan).or(equalTo).test(150));





    }
}
