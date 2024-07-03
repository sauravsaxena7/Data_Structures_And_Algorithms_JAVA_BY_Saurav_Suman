package CollectionFramework.MapInterface;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafeSetExample {
    public static void main(String[] args){
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<>();

        Set<Integer> threadSafeSet =concurrentHashMap.newKeySet();

        threadSafeSet.add(0);
        threadSafeSet.add(1);

        Iterator<Integer> it = threadSafeSet.iterator();

        while(it.hasNext()){
            Integer val = it.next();
            if(val==1){
                //it.remove() :-we cam remove
                threadSafeSet.add(9);
                //we should be able to add because it is thread safe
            }
        }
        threadSafeSet.forEach((val)->System.out.println(val));

    }
}
