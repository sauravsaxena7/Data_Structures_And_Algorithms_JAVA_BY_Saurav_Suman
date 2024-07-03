package java_8_Features;


interface Test{
    void print();

}

interface Test2{
    int multiply(int x,int y);
}
public class LambdaFunctionAsAParameter {
    static void functionPrint(Test t){
        t.print();
    }

    static void functionMultiply(Test2 t,Integer x,Integer y){
        System.out.println("Multiplication Of "+x+" & "+y+" is "+t.multiply(x,y));
    }

    public static void main(String[] args){
        functionPrint((()->{
            System.out.println("I AM CALLING FROM FUNCTION AS PARAMETER");
        }));
        functionMultiply(((int x,int y)-> x*y),78,10);
        
    }
}
