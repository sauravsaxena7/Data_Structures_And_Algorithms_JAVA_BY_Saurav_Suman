package CollectionFramework.MapInterface;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args){
        System.out.println("------Below is LinkedHasMap insertion order maintained----->");
        Map<Integer,String> map = new LinkedHashMap<>();
        map.put(1,"A");
        map.put(21,"B");
        map.put(23,"C");
        map.put(141,"D");
        map.put(25,"E");
        map.forEach((Integer key,String val)->System.out.println(key+" : "+val));

        System.out.println("------Below is Normal HasMap insertion order not maintained----->");

        Map<Integer,String> map2 = new HashMap<>();
        map2.put(1,"A");
        map2.put(21,"B");
        map2.put(23,"C");
        map2.put(141,"D");
        map2.put(25,"E");
        map2.forEach((Integer key,String val)->System.out.println(key+" : "+val));


        //now we are talking about access order
        System.out.println("------Below is LinkedHasMap access order maintained----->");
        Map<Integer,String> map3 = new LinkedHashMap<>(16,.75f,true);
        map3.put(1,"A");
        map3.put(21,"B");
        map3.put(23,"C");
        map3.put(141,"D");
        map3.put(25,"E");
        System.out.println("-----Actual insertion order------");
        map3.forEach((Integer key,String val)->System.out.println(key+" : "+val));


        //access the data 23 most frequently used data will be added in last
        map3.get(23);

        System.out.println("access the data 23 most frequently used data will be added in last");
        map3.forEach((Integer key,String val)->System.out.println(key+" : "+val));


    }
}


