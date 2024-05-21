package java_8_Features.funcional_interface;

@FunctionalInterface
public interface FunctionalInterfaceExample {
    int add(int a,int b);
    default String sayHi(){
        return "hi";
    }

    static boolean isTrue(){
        return true;
    }

    private void lola(){
        System.out.println("lola");
    }

}


