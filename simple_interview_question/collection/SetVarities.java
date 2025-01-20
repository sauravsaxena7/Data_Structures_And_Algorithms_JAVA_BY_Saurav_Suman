package simple_interview_question.collection;

import java.util.*;

public class SetVarities {
   public static void main(String[] args){
       Set<Integer> mySet = new TreeSet<Integer>();//LINE1 NOT WORKING
       Set<Integer> mySet2 = new HashSet<Integer>();//LINE2 NOT WORKING
       //Set<Integer> mySet3 = new SortedSet<Integer>() ;//LINE3 NOT WORKING
       //Set<Integer> mySet4 = new LinkedList<>();
       mySet2.add(51);
       mySet2.add(61);
       mySet2.add(71);
       System.out.println(mySet2);
   }
}
