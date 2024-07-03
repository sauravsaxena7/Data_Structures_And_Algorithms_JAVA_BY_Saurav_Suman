package utils.personRepos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonReposImple {

   static List<Persons> personsList;
   public static List<Persons> getAllPersonList(){
        personsList = new ArrayList<>();
        personsList.add(new Persons("saurav",1,23,"Male" ,Arrays.asList("dancing","singing","foodie")));
        personsList.add(new Persons("gaurav",2,20,"Male", Arrays.asList("weeping","nulla","pagal")));
        personsList.add(new Persons("saroj",3,50,"Female", Arrays.asList("anger","anger","anger")));
        personsList.add(new Persons("nana",3,55,"Male", Arrays.asList("funny","cool","leader")));
       personsList.add(new Persons("lola",3,140,"Cartoon", Arrays.asList("lola","cola","pola")));
        return personsList;
    }

}
