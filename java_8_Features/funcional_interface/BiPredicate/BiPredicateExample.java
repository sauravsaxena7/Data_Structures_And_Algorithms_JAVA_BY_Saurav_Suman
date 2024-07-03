package java_8_Features.funcional_interface.BiPredicate;

import utils.personRepos.PersonReposImple;
import utils.personRepos.Persons;

import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class BiPredicateExample {
    static BiPredicate<Integer,String> bip = (age,gender)-> age>=140 && gender.equals("Cartoon");
    static Consumer<Persons> pHoobies = p->System.out.println(p.getHobbies());
    static Consumer<Persons> personsConsumer = p->{
        if(bip.test(p.getAge(),p.getGender())){
            System.out.println(p.getName()+" "+p.getAge()+" "+p.getGender());
            pHoobies.accept(p);
        }
    };
    public static void main(String[] args){
        PersonReposImple.getAllPersonList().forEach(personsConsumer);
    }
}
