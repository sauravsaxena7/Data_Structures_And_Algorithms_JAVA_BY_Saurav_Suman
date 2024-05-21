package java_8_Features.personRepos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class PersonReposImple {

   static List<Persons> personsList;
   public static List<Persons> getAllPersonList(){
        personsList = new ArrayList<>();
        personsList.add(new Persons("saurav",1,23, Arrays.asList("dancing","singing","foodie")));
        personsList.add(new Persons("gaurav",2,20, Arrays.asList("weeping","nulla","pagal")));
        personsList.add(new Persons("saroj",3,50, Arrays.asList("anger","anger","anger")));
        personsList.add(new Persons("nana",3,55, Arrays.asList("funny","cool","leader")));
        return personsList;
    }

}
