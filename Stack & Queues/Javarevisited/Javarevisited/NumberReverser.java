package Javarevisited;

import java.util.Stack;

public class NumberReverser {
    public static int reverseNumber(int number){
        Stack<Integer> stack = new Stack<>();

        //Extract digits and push them onto the stack
        while(number>0){
            int digit = number % 10;
            stack.push(digit);
            number /= 10;
        }

        int reversedNumber = 0;
        int multiplier = 1;

        //Pop digits from the stack and form the reversed number
        while(!stack.isEmpty()){
            reversedNumber += stack.pop() * multiplier;
            multiplier *= 10;
        }
        return reversedNumber;
    }

    public static void main(String[] args) {
        int number = 12345;
        int reversedNumber = reverseNumber(number);
        System.out.println("Reversed number: " + reversedNumber);
    }
}
