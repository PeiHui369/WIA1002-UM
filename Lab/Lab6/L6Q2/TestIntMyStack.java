import java.util.Scanner;

public class TestIntMyStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer value: ");
        int num = sc.nextInt();

        MyStack<Integer> intStack = new MyStack<>();
        for(int i = 1; i<=num; i++){
            intStack.push(i);
        }

        System.out.println("Size of stack: " +intStack.getSize());

        while(!intStack.isEmpty()){
            System.out.println(intStack.pop());
        }
    }
}

/*
What is the output of the elements? What is the order, why?

If the user enters 5 as the integer value, the output of the elements and their order will be:
1
2
3
4
5

This is because the program creates a stack of integers using the 'MyStack' class, and pushes integers from 1 to 'num' (which is 5 in this case) onto the stack using a for loop. The integers are pushed in the order of 1, 2, 3, 4, 5.

Then, the program prints the size of the stack, which is 5.

Finally, the program uses a while loop to pop elements off the stack and print them. Since the last element pushed onto the stack (5) is the first one to be popped off, the integers are printed in reverse order: 5, 4, 3, 2, 1.

The elements are printed in descending order because of the LIFO (Last In First Out) behavior of the stack. The last element pushed onto the stack (in this case, 5) is the first one to be popped off, followed by the second-last element (4), and so on, until the first element pushed onto the stack (1) is the last one to be popped off. So the elements are printed in reverse order of the order in which they were pushed onto the stack.
*/
