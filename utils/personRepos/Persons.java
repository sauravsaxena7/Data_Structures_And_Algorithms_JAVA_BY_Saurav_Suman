package utils.personRepos;

import java.util.List;


public class Persons {
    String name;
    Integer id;
    Integer age;
    String gender;
    List<String> hobbies;

    public Persons(String name, Integer id, Integer age, String gender, List<String> hobbies) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public List<String> getHobbies() {
        return hobbies;
    }
}
