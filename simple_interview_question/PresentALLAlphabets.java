package simple_interview_question;

import java.util.HashMap;
import java.util.Scanner;

public class PresentALLAlphabets {
    public static void main(String[] args){
        // Arguments will be read by STDIN
        //zacxyjbbkfgtbhdaielqrm45pnsowtuv
        Scanner s = new Scanner(System.in); // do not change this
        String inputLine = s.nextLine(); // do not change this

        int[] count2 = new int[100];
        boolean flag=false;

        HashMap<Character,Integer> mp = new HashMap<>();
        for(char i='a';i<='z';i++){
            mp.put(i,1);
        }
        mp.put('z',1);
        for(int i=1;i<=26;i++){

            count2[i]=0;
        }



        for (int i = 0; i < inputLine.length(); i++) {

            // storing the frequency of the character.
            //System.out.print(inputLine.charAt(i)+" ,");
            if(mp.containsKey(inputLine.charAt(i))){
               // System.out.print(inputLine.charAt(i)+" ,");
                count2[inputLine.charAt(i) - 'a']=1;
            }

        }
        //System.out.println();
        int count=0;
        for (int i = 0; i < inputLine.length(); i++) {



            if (mp.containsKey(inputLine.charAt(i)) && mp.get(inputLine.charAt(i))==1 && count2[inputLine.charAt(i) - 'a']==1) {
                //System.out.print(inputLine.charAt(i)+" ,");
                mp.put(inputLine.charAt(i),0);
                count=count+1;
            }
        }
        //System.out.println();
        if(count==26){
            flag=true;
        }

        System.out.println(flag);
    }
}
