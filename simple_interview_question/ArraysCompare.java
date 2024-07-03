package simple_interview_question;

import java.util.Arrays;

public class ArraysCompare {
    public static void main(String args[]){

                int[] x= { 7, 8, 9}; int[] y = { 7, 7, 7};
                System.out.println(Arrays.compare (x, y) + " " + Arrays.mismatch(x, y));


    }
}

