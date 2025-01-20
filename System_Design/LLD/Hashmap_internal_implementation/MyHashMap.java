package System_Design.LLD.Hashmap_internal_implementation;

import java.util.HashMap;

public class MyHashMap <K,V>{
    private static final int INITIAL_SIZE = 1<<4;//16
    private static final int MAXIMUM_CAPACITY = 1<<30;

    public Entry[] hashTable;

    public MyHashMap(){
        hashTable = new Entry[INITIAL_SIZE];
    }

    public MyHashMap(int capacity){
        int tableSize = tableSizeFor(capacity);
        hashTable = new Entry[tableSize];
    }

    private int tableSizeFor(int capacity) {
        int n = capacity-1;
        n |= n>>>1;
        n |= n>>>2;
        n |= n>>>4;
        n |= n>>>8;
        n |= n>>>16;
        return (n<0) ? 1 : (n>=MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY:n+1;
    }

    class Entry<K,V>{
        public K key;
        public V value;
        public Entry next;
        Entry(K k, V v){
            key=k;
            value=v;
        }
    }

    public void put(K key, V value){
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        if(node==null){
            Entry newNode = new Entry(key,value);
            hashTable[hashCode] = newNode;
        }else{
            Entry prevNode = node;
            while(node!=null){
                if(node.key==key){
                    node.value=value;
                    return;
                }
                prevNode=node;
                node=node.next;
            }

            Entry newNode = new Entry(key,value);
            prevNode.next = newNode;

        }

    }

    public V get(K key){
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];
        while (node!=null){
            if(node.key.equals(key)){
                return (V) node.value;
            }
            node = node.next;
        }
        return null;
    }

    public static void main(String[] args){
        MyHashMap<Integer,String> mp = new MyHashMap<>();
        mp.put(1,"Hi, ");
        mp.put(2,"My");
        mp.put(3,"Name");
        mp.put(4,"Is");
        mp.put(5,"Saurav");
        mp.put(6,"Suman");
        mp.put(7,"and");
        mp.put(8,"I am Happy");
        String value = mp.get(8);
        System.out.println(value);


    }


}
