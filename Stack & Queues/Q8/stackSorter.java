package FullStackStackQueue;

import java.util.Stack;

public class stackSorter {
    public static void sort(Stack<Integer> stack){
        if(!stack.isEmpty()){
            int x = stack.pop();
            sort(stack);
            insert(stack,x);
        }
    }

    public static void insert(Stack<Integer> stack, int x){
        if(!stack.isEmpty()){
            int y = stack.peek();
            if(x<y){
                stack.pop();
                insert(stack, x);
                stack.push(y);
            }else{
                stack.push(x);
            }
        }else{
            stack.push(x);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(2);
        stack.push(10);
        stack.push(1);

        System.out.println("Stack before sorting: " + stack);

        sort(stack);

        System.out.println("Stack after sorting: " + stack);
    }
}
