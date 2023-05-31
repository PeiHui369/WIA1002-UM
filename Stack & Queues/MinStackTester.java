package FullStackStackQueue;

public class MinStackTester {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        // Push elements to the stack
        minStack.push(5);
        minStack.push(2);
        minStack.push(10);
        minStack.push(1);

        // Print the minimum value in the stack
        System.out.println("Minimum value in the stack: " + minStack.getMin()); // Output: 1

        // Pop an element from the stack
        minStack.pop();

        // Print the minimum value in the stack after popping
        System.out.println("Minimum value in the stack after popping: " + minStack.getMin()); // Output: 2

        // Push another element to the stack
        minStack.push(3);

        // Print the minimum value in the stack after pushing again
        System.out.println("Minimum value in the stack after pushing again: " + minStack.getMin()); // Output: 2
    }
}
