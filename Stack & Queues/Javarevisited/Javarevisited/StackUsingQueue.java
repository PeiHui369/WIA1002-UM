package Javarevisited;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue{
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackUsingQueue(){
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int value){
        queue1.offer(value);
        while(!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }
        Queue<Integer> temp = queue1;
        queue2 = temp;
    }

    public boolean isEmpty(){
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public int pop(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return queue2.poll();
    }

    public int top(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return queue2.peek();
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop()); // Output: 3
        System.out.println(stack.top()); // Output: 2
        System.out.println(stack.isEmpty()); // Output: false

        stack.push(4);
        System.out.println(stack.pop()); // Output: 4
        System.out.println(stack.pop()); // Output: 2
        System.out.println(stack.isEmpty()); // Output: false
    }

}