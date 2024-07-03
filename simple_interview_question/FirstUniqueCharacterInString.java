package simple_interview_question;

import java.util.Scanner;

public class FirstUniqueCharacterInString {
    public static void main(String[] args){
        // Arguments will be read by STDIN
        Scanner s = new Scanner(System.in); // do not change this
        String inputLine = s.nextLine(); // do not change this

        // you code will be inside this main method
        // to view the output, just print the string

        int[] count = new int[26];

        for (int i = 0; i < inputLine.length(); i++) {
            count[inputLine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < inputLine.length(); i++) {
            // checking if the character is non-repeating or not.
            if (count[inputLine.charAt(i) - 'a'] == 1) {
                System.out.println(inputLine.charAt(i));
                break;
            }
        }
    }
}
