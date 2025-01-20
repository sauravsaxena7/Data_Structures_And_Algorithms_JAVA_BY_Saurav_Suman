package simple_interview_question;

import java.util.*;
import java.util.stream.Collectors;

class Employee{
    String Name;
    int age;

    Employee(String name,int age){
        this.age=age;
        this.Name=name;
    }
}

public class ArraysCompare {
    public static void main(String args[]){

        int N = 4, X = 53;
        int arr[] = {12, 16, 22, 30, 35, 39, 42,
                45, 48, 50, 53, 55, 56};
//        Output: 30 39 42 45


        //will find the diff each value of array.
        List<Integer> l = new ArrayList<>();

        int pos=-1;
        for(int i=0;i<arr.length;i++){
            if(X==arr[i]){
                pos=i;
            }
        }

        int left=pos-1;
        int  right=pos+1;
        int j=0;
        while(left>=0 && right<arr.length && l.size()<N){
            int leftD=Math.abs(X-arr[left]);
            int rightD=Math.abs(X-arr[right]);

//            System.out.println("left: "+leftD+" "+arr[left]);
//            System.out.println("right: "+rightD+" "+arr[right]);
            if(leftD<rightD){
                l.add(arr[left]);
                left--;
            }else{
                l.add(arr[right]);
                right++;
            }

        }
        int restLength=N-l.size();
        if(right>=arr.length){
            while(l.size()<N){
                l.add(arr[left--]);
            }
        }else{
            while(l.size()<N){
                l.add(arr[right++]);
            }
        }

        System.out.println(l);
        Collections.sort(l);

        System.out.println(l);


        List<Employee> employeeList=new ArrayList<>();

        Employee e1=new Employee("John",21);
        Employee e2=new Employee("Martin",19);
        Employee e3=new Employee("Mary",31);
        Employee e4=new Employee("Stephan",18);
        Employee e5=new Employee("Gary",26);

        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);

        long con = employeeList.stream().filter((e)->e.age>=21).count();

        System.out.println(con);

        List<String> nameList = employeeList.stream().filter((e)->e.age>=21).map((e)->e.Name).collect(Collectors.toList());

        System.out.println(nameList);






    }
}

