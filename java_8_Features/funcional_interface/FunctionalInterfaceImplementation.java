package java_8_Features.funcional_interface;

public class FunctionalInterfaceImplementation implements   FunctionalInterfaceExample{
    @Override
    public int add(int a, int b) {
        return 0;
    }

    @Override
    public String sayHi() {
        return FunctionalInterfaceExample.super.sayHi();
    }

    public static void main(String[] args){
        FunctionalInterfaceImplementation o = new FunctionalInterfaceImplementation();
        System.out.println("add of 15,20: "+o.add(15,20));
        System.out.println("sayHi : "+o.sayHi());


    }
}
