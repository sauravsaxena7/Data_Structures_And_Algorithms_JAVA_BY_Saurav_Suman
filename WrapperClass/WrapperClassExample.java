package WrapperClass;

class Wrapper{
    int primitiveInt =10;
    Integer wrapperInteger =20;

     void modify(int val){
        primitiveInt=val;
        wrapperInteger=val;
    }
}
public class WrapperClassExample {
    public static void main(String[] args){
        Wrapper wrapper = new Wrapper();
        wrapper.modify(500);
        System.out.println("primitiveInt: "+wrapper.primitiveInt);
        System.out.println("wrapperInteger: "+wrapper.wrapperInteger);

    }

}
