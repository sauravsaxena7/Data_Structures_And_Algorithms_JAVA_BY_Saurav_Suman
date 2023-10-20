package recursion;

import java.util.Scanner;

public class Print_1_to_n_Using_Recursion {

    static void Print(int n){
        if(n==0){
            return;
        }
        Print(n-1);
        System.out.print(n+" ");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        Print(n);
    }
}
