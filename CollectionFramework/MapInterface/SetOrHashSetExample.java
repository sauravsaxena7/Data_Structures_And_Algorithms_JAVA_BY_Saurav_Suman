package CollectionFramework.MapInterface;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetOrHashSetExample {
    public static void main(String[] args){
        Set<Integer> s = new HashSet<>();
        s.add(11);
        s.add(9);
        s.add(33);
        s.add(-1);

        Set<Integer> s2 = new HashSet<>();
        s2.add(11);
        s2.add(88);
        s2.add(12);
        s2.add(33);
        s.add(0);
        s2.add(null);

        //union
        System.out.println("union of 2 set");
        s.addAll(s2);
        System.out.println("After union");
        s.forEach((v)->System.out.print(v+" "));

        //intersection
        s=new HashSet<>();
        s.add(12);
        s.add(33);
        s.add(88);
        s.add(99999);

        s2 = new HashSet<>();
        s2.add(0);
        s2.add(99999);
        s2.add(null);
        s2.add(-1);
        s2.add(88);

        System.out.println("After Intersection");
        s.retainAll(s2);
        s.forEach((v)->System.out.println(v));


        //difference
        s=new HashSet<>();
        s.add(12);
        s.add(33);
        s.add(88);
        s.add(99999);

        s2 = new HashSet<>();
        s2.add(0);
        s2.add(99999);
        s2.add(null);
        s2.add(-1);
        s2.add(88);
        s.removeAll(s2);

        Iterator<Integer> it = s.iterator();
        while (it.hasNext()){
            Integer val = it.next();
            if(val==99999){
                //it.add(null);
            }
        }
    }
}
