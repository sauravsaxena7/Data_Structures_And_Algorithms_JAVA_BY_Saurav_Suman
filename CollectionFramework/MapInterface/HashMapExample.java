package CollectionFramework.MapInterface;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

    static void printHashMap(Map<Integer,String> mp){
        for(Map.Entry<Integer, String> map : mp.entrySet()){
            Integer key = map.getKey();
            String val = map.getValue();

            System.out.println("key: "+key+" value: "+val);
        }
    }
    public static void main(String[] args){
        Map<Integer,String> mp = new HashMap<>();
        mp.put(null,"i am null");
        mp.put(0, null);
        mp.put(1,"A");
        mp.put(-1,"Q");


        //compute if present
        mp.putIfAbsent(null,"lola");
        mp.putIfAbsent(0,"ZERO");
        mp.putIfAbsent(3,"c");

        printHashMap(mp);

        //isEmpty
        System.out.println("mp.isEmpty(): "+mp.isEmpty());

        //size
        System.out.println("mp.size(): "+mp.size());

        //size
        System.out.println("mp.containsKey(3): "+mp.containsKey(3));


        //get(key)
        System.out.println("mp.get(1): "+mp.get(1));

        //getOrDefault(key)
        System.out.println("mp.getOrDefault(1,'default value'): "+mp.getOrDefault(1,"default value"));

        //remove(key)
        System.out.println("remove(null)" + mp.remove(null));

        printHashMap(mp);

        //keySet()
        System.out.println("KeySet");
        for (Integer key : mp.keySet()){
            System.out.println("key: "+key);
        }


        //values()
        System.out.println("values");
        Collection<String> values = mp.values();
        for (String val : values){
            System.out.println("value: "+val);
        }





    }
}
