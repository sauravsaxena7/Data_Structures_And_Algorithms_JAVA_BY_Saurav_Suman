package java_8_Features.funcional_interface.BiConsumerInterface;

import java.util.List;
import java.util.function.BiConsumer;


//@FunctionalInterface
//public interface BiConsumer<T, U> {
//    /**
//     * Performs this operation on the given arguments.
//     *
//     * @param t the first input argument
//     * @param u the second input argument
//     */
//    void accept(T t, U u);
//    /**
//     * Returns a composed {@code BiConsumer} that performs, in sequence, this
//     * operation followed by the {@code after} operation. If performing either
//     * operation throws an exception, it is relayed to the caller of the
//     * composed operation.  If performing this operation throws an exception,
//     * the {@code after} operation will not be performed.
//     *
//     * @param after the operation to perform after this operation
//     * @return a composed {@code BiConsumer} that performs in sequence this
//     * operation followed by the {@code after} operation
//     * @throws NullPointerException if {@code after} is null
//     */
//    default BiConsumer<T, U> andThen(BiConsumer<? super T, ? super U> after) {
//        Objects.requireNonNull(after);
//        return (l, r) -> {
//            accept(l, r);
//            after.accept(l, r);
//        };
//    }
//}



public class BiConsumerInterfaceExample {
    public static void main(String[] args){
        BiConsumer<Integer,Integer> BiCon1 = (a,b)->System.out.println(a+b);
        BiCon1.accept(9,10);

        BiConsumer<String, List<String>> BiCon2 = (name,hobbies)->System.out.println(name+" "+hobbies);

        BiConsumer<String, Integer> BiCon3 = (name,id)->System.out.println(name+" "+id);

        //Here BiConsumer Of Different types it's give error If two consumer have same type then we can apply andThen Method
        //PersonReposImple.getAllPersonList().forEach(p->BiCon1.andThen(BiCon2));

    }
}
