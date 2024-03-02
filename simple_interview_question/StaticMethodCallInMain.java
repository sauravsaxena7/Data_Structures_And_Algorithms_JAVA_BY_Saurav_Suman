package java_static_concept;


class A{
    int a=0;
    static void my(){
        System.out.println("I Am From Class A and I am Static Method  too.");
       // a++;
        //mx();
//        Consequently, attempting to access a non-static variable from a
//        static context (a static method or block) without a class instance
//        creates ambiguity—every instantiated object has its own variable,
//        so the compiler is unable to tell which value is being referenced.
    }

    void mx(){
        System.out.println("I am Simple Void Method From Class A.");
    }
}


public class StaticMethodCallInMain {
    public static void main(String[] args) {
        A.my();
    }
}
