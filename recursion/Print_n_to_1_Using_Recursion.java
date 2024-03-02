package recursion;

import java.util.Scanner;

public class Print_n_to_1_Using_Recursion {

    static void Print(int n){
        if(n==0) return;
        System.out.print(n+" ");
        Print(n-1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        Print(n);
    }
}
