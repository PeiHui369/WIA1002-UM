One popular technique in data structure is the generic stack implementation.
Write a program to [implement generic stack]
Your program must contain the following methods:

i) Constructor for the generic stack class:
Default constructor

ii) isEmpty
Return whether or not the generic stack is empty

iii) isFull
Return whether or not the generic stack is full

iv) peek
Return the value of the top element in the generic stack without removing it

v) push
Add element to the top of generic stack

vi) pushMany
Add several elements to the generic stack using comma as split delimiter

vii) pop
Remove element from the top of the generic stack

viii) popMiddle
Remove element from the middle position if the number of element in the generic stack is odd number

ix) popAll
Remove all elements from the generic stack

x) display
Display all elements in the generic stack

Write all methods from Table 1 as well as your main method in the same program file.
Your main() method should follow the suggestion shown in Figure 1(a).
Modify and test your methods so you get the same output shown in Figure 1(b).

------------------------------------------------------------------------------------------------------
package PastYear2020;

public class GenericStack<T> {
    private Object[] stack;
    private int top;
    private int maxSize;

    GenericStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new Object[maxSize];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) stack[top];
    }

    public void push(T element) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        System.out.print("Push: " + element + "\n");
        stack[++top] = element;
    }

    public void pushMany(String str) {
        System.out.print("Push many into stack...\n");
        String[] items = str.split(",");
        for (String item : items) {
            push((T) item.trim());
        }
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        T element = (T) stack[top];
        stack[top--] = null;
        return element;
    }

    public T popMiddle() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        if ((top + 1) % 2 == 0) {
            System.out.println("Current count of stack is even number, so cannot pop middle index...");
            return null;
        }
        int middle = top / 2;
        T element = (T) stack[middle];
        for (int i = middle; i < top; i++) {
            stack[i] = stack[i + 1];
        }
        stack[top--] = null;
        return element;
    }

    public void popAll() {
        System.out.println("There are " + (top + 1) + " items in the stack. Pop all...");
        while (!isEmpty()) {
            T ele = pop();
            System.out.print("Removing " + ele + " ..\n");
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("\nStack is empty, nothing to display...");
            return;
        }
        System.out.print("\nThere are " + (top + 1) + " items in the stack. Displaying...\n");
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GenericStack<String> stack1 = new GenericStack<String>(7);
        stack1.push("apple");
        stack1.display();
        stack1.pushMany("broccoli, chicken sandwich, donut, french fries, juice, maruku");
        stack1.display();
        System.out.println("Pop the top of the stack: " + stack1.pop());
        System.out.println("Pop the top of the stack: " + stack1.pop());
        stack1.display();
        System.out.println("Pop middle of the stack: " + stack1.popMiddle());
        stack1.display();
        System.out.println("Pop middle of the stack: " + stack1.popMiddle());
        System.out.println("-----------------------------------------------");
        GenericStack<Integer> stack2 = new GenericStack<Integer>(10);
        stack2.push(1);
        stack2.push(2);
        stack2.pushMany("3,4,5,6,7");
        stack2.display();
        stack2.popAll();
        stack2.display();
    }
}

