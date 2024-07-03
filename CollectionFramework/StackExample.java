package CollectionFramework;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(0);

        System.out.println("stack: "+stack);
        System.out.println("stack.pop(): "+stack.pop());

    }
}
