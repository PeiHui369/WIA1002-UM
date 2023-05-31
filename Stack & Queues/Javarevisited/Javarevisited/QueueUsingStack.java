package Javarevisited;

import java.util.Stack;

public class QueueUsingStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingStack(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int value){
        stack1.push(value);
    }

    public int dequeue(){
        if(stack2.isEmpty()){
            //Transfer element from stack1 to stack2
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();

        //Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        //Dequeue elements
        System.out.println(queue.dequeue()); //Output: 1
        System.out.println(queue.dequeue()); //Output: 2

        // Enqueue more elements
        queue.enqueue(4);
        queue.enqueue(5);

        // Dequeue elements
        System.out.println(queue.dequeue()); // Output: 3
        System.out.println(queue.dequeue()); // Output: 4

        // Check if the queue is empty
        System.out.println(queue.isEmpty()); // Output: false

        // Dequeue remaining element
        System.out.println(queue.dequeue()); // Output: 5

        // Check if the queue is empty
        System.out.println(queue.isEmpty()); // Output: true
    }
}
