package Generics_In_Java_Depth;


import java.util.List;

class PrintUnboundedWildCardType {
    //wild card Type method
    public void computeList(List<?> list){

    }
    //Generic Type method
    public <T> void computeListGenericType(List<T> source, List<T> destination){

    }
}
public class UnboundedWildCardTypeExample {
}
