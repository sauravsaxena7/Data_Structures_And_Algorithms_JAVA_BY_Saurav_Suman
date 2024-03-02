package array;


import java.util.Arrays;
import java.util.Scanner;



class RotationArray{
    public void rotate(int position){
        
    }
}
class Solution {
    public boolean check(int[] nums) {
        int sortedArray[]=new int[nums.length];
        int k=0;
        for(int i:nums){
            sortedArray[k]=i;
            k++;
        }
        Arrays.sort(sortedArray);

        System.out.println();
        return false;
    }
}
public class Check_if_Array_Is_Sorted_and_Rotated {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Solution solution = new Solution();
        System.out.println(solution.check(arr));
    }
}
