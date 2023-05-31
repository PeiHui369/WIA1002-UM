package Javarevisited;

public class ArrayStack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public ArrayStack (int capacity){
        maxSize = capacity;
        stackArray = new int [maxSize];
        top = -1;
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public void push (int value){
        if(isFull()){
            throw new IllegalStateException("Stack is full. Cannot push element.");
        }
        top++;
        stackArray[top] = value;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int pop(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty. Cannot pop element.");
        }
        int poppedValue = stackArray[top];
        top--;
        return poppedValue;
    }

    public int peek(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty. Cannot peek element.");
        }
        return stackArray[top];
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);

        stack.push(5);
        stack.push(2);
        stack.push(10);

        System.out.println(stack.pop()); // Output: 10
        System.out.println(stack.peek()); // Output: 2
        System.out.println(stack.isEmpty()); // Output: false
    }
}

