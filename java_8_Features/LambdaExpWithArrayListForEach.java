package java_8_Features;

import java.util.ArrayList;

public class LambdaExpWithArrayListForEach {

    public static void main(String args[]){
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i=0;i<=10;i++){
            al.add(i+7);
        }

        al.forEach((ele)->{
            if(ele%2==0){
                System.out.println(ele+" is even number");
                return;
            }
            System.out.println(ele+" is odd number");
        });
    }
}
