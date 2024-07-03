package java_8_Features.funcional_interface.consumer;

import utils.personRepos.PersonReposImple;
import utils.personRepos.Persons;

import java.util.List;
import java.util.function.Consumer;

//public interface Consumer<T> {
//    void accept(T paramT);
//
//    default Consumer<T> andThen(Consumer<? super T> paramConsumer){
//        Objects.requireNonNull(paramConsumer);
//        return (paramObj)->{
//            accept(paramObj);
//            paramConsumer.accept(paramObj);
//        };
//    }
//}



public class ConsumerInterfaceExample {

    static Consumer<Persons> c3 = (p)->System.out.println(p.getName().toUpperCase());
    static Consumer<Persons> c4 = (p)->System.out.println(p.getHobbies());
    public static void main(String[] args){
        Consumer<String> con1 = (str)->{System.out.println(str.toUpperCase());};
        con1.accept("lola");
        Consumer<String> con2 = (str)->System.out.println(str.concat(" pola"));
        con1.andThen(con2).accept("chhola");
        //Operation on Persons using consumer
        List<Persons> personsList = PersonReposImple.getAllPersonList();
        c3.accept(personsList.get(3));
        c3.andThen(c4).accept(personsList.get(3));

        printNameAndHobbies();
    }

    static void printNameAndHobbies(){
        List<Persons> personsList = PersonReposImple.getAllPersonList();
        personsList.forEach(c3);
        personsList.forEach((p)->{
            if(p.getAge()>=50 && p.getName().equals("saroj"))
                c3.andThen(c4).accept(p);
        });
        personsList.forEach(c3.andThen(c4));
    }
}
