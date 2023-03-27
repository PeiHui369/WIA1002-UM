import java.util.Random;
import java.util.Stack;
public class L6Q3 {
    public static void main(String[] args) {
        Stack<Integer> unknown = new Stack<>();
        Random random = new Random();

        for(int i = 0; i<10; i++){
            unknown.push(random.nextInt(101));
        }

        System.out.println(unknown);

        System.out.println("Sum is: " +sum(unknown));
    }

    public static int sum(Stack<Integer> stack){
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}

/*
Here's an algorithm in pseudocode to find the sum of every element in a stack S:
initialize sum variable to 0
while S is not empty:
    pop top element from S and add it to sum
return sum

Here's the explanation of the algorithm:

We start by initializing a variable called 'sum' to 0, which we will use to keep track of the sum of all elements in the stack.
We then use a loop that continues as long as the stack is not empty.
Inside the loop, we pop the top element from the stack using the 'pop()' operation, and add it to the 'sum' variable.
After the loop has completed, we return the final value of 'sum', which will be the sum of all elements in the stack.
This algorithm uses only stack ADT operations, namely 'pop()' to remove the top element of the stack, and 'isEmpty()' to check if the stack is empty.

*/
