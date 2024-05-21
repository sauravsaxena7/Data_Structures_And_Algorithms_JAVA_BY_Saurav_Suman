package java_8_Features.personRepos;

import java.util.List;


public class Persons {
    String name;
    Integer id;
    Integer age;
    List<String> hobbies;

    public Persons(String name, Integer id, Integer age, List<String> hobbies) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}
