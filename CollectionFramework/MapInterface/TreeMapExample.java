package CollectionFramework.MapInterface;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapExample {

    public static void main(String[] arga){
        Map<Integer,String> mp = new TreeMap<>((k1,k2)->k2-k1);
        mp.put(21,"lola");
        mp.put(11,"pola");
        mp.put(12,"sunny");
        mp.put(5,"luffy");

        //decending order
        System.out.println("decending order");
        mp.forEach((k,v)->System.out.println(k+" : "+v));

        Map<Integer,String> map = new TreeMap<>();
        map.put(21,"lola");
        map.put(11,"pola");
        map.put(12,"sunny");
        map.put(5,"luffy");

        //decending order
        System.out.println("natural or ascending order for integer key");
        map.forEach((k,v)->System.out.println(k+" : "+v));



        System.out.println("Sorted Map ");
        SortedMap<Integer,String> smp = new TreeMap<>();
        smp.put(21,"lola");
        smp.put(11,"p3");
        smp.put(13,"nana");
        smp.put(5,"12");

        System.out.println("smp.headMap(13) exclusive: "+smp.headMap(13));



        System.out.println("smp.tailMap(13) inclusive: "+smp.tailMap(13));


        System.out.println("smp.firstKey(): "+smp.firstKey());
        System.out.println("smp.lastKey(): "+smp.lastKey());

        System.out.println("Navigable Map");
        SortedMap<Integer,String> nmp = new TreeMap<>();
        nmp.put(21,"lola");
        nmp.put(11,"p3");
        nmp.put(13,"nana");
        nmp.put(5,"12");

        //Map.Entry<K,V> lowerEntry(K key)
        System.out.println("Map.Entry<K,V> lowerEntry(K key)");
       // System.out.println(nmp.);


    }
}
