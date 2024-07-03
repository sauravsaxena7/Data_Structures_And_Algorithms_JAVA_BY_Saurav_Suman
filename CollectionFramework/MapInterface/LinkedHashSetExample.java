package CollectionFramework.MapInterface;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample {
    public static void main(String[] args){
        Set<Integer> s = new LinkedHashSet<>();

        s.add(34);
        s.add(2);
        s.add(0);
        s.add(9999);

        System.out.println("Maintain Insertion Order");

        Iterator<Integer> it = s.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
