package Javarevisited;

import java.util.Stack;

public class StringReverser {
    public static String reverseString(String input){
        Stack<Character> stack = new Stack<>();

        //Push each character onto the stack
        for(int i = 0; i<input.length(); i++){
            stack.push(input.charAt(i));
        }

        StringBuilder reversedString = new StringBuilder();

        //Pop each character from the stack and append it to the new string
        while(!stack.isEmpty()){
            reversedString.append(stack.pop());
        }

        return reversedString.toString();
    }

    public static void main(String[] args) {
        String input = "code";
        String reversed = reverseString(input);
        System.out.println("Reversed string: " + reversed);
    }
}
