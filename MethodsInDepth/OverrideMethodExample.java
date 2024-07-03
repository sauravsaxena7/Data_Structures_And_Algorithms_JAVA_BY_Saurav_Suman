package MethodsInDepth;

class Person{
    protected void profession(){
        System.out.println("I am Person");
    }
}

class Engineer extends Person{

    @Override
    public void profession(){
        System.out.println("I am Engineer");
    }
}

public class OverrideMethodExample {
}
