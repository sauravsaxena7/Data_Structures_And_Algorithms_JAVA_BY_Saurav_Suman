import java.util.ArrayList;

class Emp{
    int age;
    String name;

    public Emp(int age,String name){
        this.age=age;
        this.name=name;
    }


    public boolean elquals(Object o){

        Emp emp = (Emp) o;
       if(this.name.length()==emp.name.length() ){
           return true;
       }
        return false;
    }
}

public class OverrideEqualsMethod {

    public static void main(String args[]){

        Emp e1=new Emp(20,"saurav");
        Emp e2=new Emp(30,"lola");

        System.out.println("Hi, Saurav And Gaurav "+e1.elquals(e2));


    }
}
