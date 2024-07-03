package CollectionFramework.MapInterface;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args){
        Set<Integer> s = new TreeSet<>();
        s.add(11);
        s.add(9);
        s.add(33);
        s.add(-1);
        Iterator<Integer> it = s.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }


    }
}
