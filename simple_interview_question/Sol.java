package simple_interview_question;


class A{
    void m1() throws ArrayIndexOutOfBoundsException{
        System.out.println("In m1 A");
    }
}

class B extends A{
    void m1() throws IndexOutOfBoundsException{
        System.out.println("In m1 B");
    }
    void m2(){
        System.out.println("In m2 B");
    }
}
public class Sol {
    public static void main(String[] args){
        A a =new B();
        a.m1();
        //a.m2(); m2 function is not present in A class
    }

}
