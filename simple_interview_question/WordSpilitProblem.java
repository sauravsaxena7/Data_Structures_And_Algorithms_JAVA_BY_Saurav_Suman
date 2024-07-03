package simple_interview_question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class WordSpilitProblem {


    //baseball::a,all,b,ball,bas,base,cat,code,d,e,quit,z

    //abcgefd::a,ab,abc,abcg,b,c,dog,e,efd,zzzz

    public static void main(String[] args){
        Scanner s = new Scanner(System.in); // do not change this
        String inputLine = s.nextLine();

        String[] starr = inputLine.split("::");
        //System.out.println(starr[0]);

        String firstInput = starr[0];


        String[] secondInputArr = starr[1].split(",");

        //System.out.println(secondInputArr[0]);

        HashMap<String,Integer> mp = new HashMap<String,Integer>();

        for(int i=0;i<secondInputArr.length;i++){
            mp.put(secondInputArr[i],1);
        }



        String answer="Not Possible";

        for(int i=0;i<firstInput.length();i++){
            String firstWord = firstInput.substring(0,i+1);
            String secondWord = "-1";
            if(i+2<firstInput.length()){
                secondWord=firstInput.substring(i+1);
            }
            //System.out.println(firstWord+","+secondWord);
            if(mp.containsKey(firstWord) && mp.containsKey(secondWord)){
                answer=firstWord+","+secondWord;
            }
        }

        System.out.println(answer);






    }




}
