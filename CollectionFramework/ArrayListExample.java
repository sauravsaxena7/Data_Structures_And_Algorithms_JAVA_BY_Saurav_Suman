package CollectionFramework;

import java.util.*;

public class ArrayListExample {
    public static void main(String[] args){

        //add(int index,E e)
        List<Integer> list1 = new ArrayList<>();

        list1.add(0,1);
        list1.add(1,2);
        list1.add(2,3);
        list1.add(3,3);

        System.out.println("list1: "+list1);

        //addAll(int index Collection c);
        List<Integer> list2 = new ArrayList<>();
        list2.add(0,9);
        list2.add(1,10);

        list1.addAll(0,list2);

        System.out.println("list1+list2 at 0 index: "+list1);

        //replace all
        list1.replaceAll((val)->val+1);
        System.out.println("list1.replaceAll((val)->val+1): "+list1);

        //sort
        Comparator<Integer> myComp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };
        list1.sort(myComp);

        System.out.println("list1.sort(myComp): "+list1);
        System.out.println("list1.get(3): "+list1.get(3));

        list1.set(1,-9000);

        System.out.println("list1.set(0,-9000): "+list1);

        list1.remove(1);
        System.out.println("list1.remove(1): "+list1);

        System.out.println("list1.lastIndexOf(3): "+list1.lastIndexOf(3));

        //ListIterator
        //need to provide the index in listiterator , from where it has to start

        ListIterator<Integer> listIterator1 = list1.listIterator(list1.size());

        //traversing backward direction
        while(listIterator1.hasPrevious()){
            int prevEle = listIterator1.previous();
            System.out.println("traversing backward: "+prevEle+" nextIndex: "+listIterator1.nextIndex()+ " prevIndex: "+listIterator1.previousIndex());
            if (prevEle==-9000){
                listIterator1.set(-5000);
            }
        }

        System.out.println("after traversing and setting backward direction"+list1);

        //Traversing in forward direction
        ListIterator<Integer> listIterator2 = list1.listIterator();

        while (listIterator2.hasNext()){
            int val = listIterator2.next();
            System.out.println("traversing forward: "+val+" nextIndex: "+listIterator1.nextIndex()+ " prevIndex: "+listIterator2.previousIndex());

            if(val ==-5000){
                listIterator2.add(-9000);
            }
        }
        System.out.println("after traversing and setting forward direction: "+list1);


        List<Integer> subList = list1.subList(1,4);
        System.out.println("list1.subList(3,6): " + subList);






    }
}
