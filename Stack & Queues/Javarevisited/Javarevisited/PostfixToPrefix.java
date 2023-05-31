package Javarevisited;

import java.util.Stack;

public class PostfixToPrefix {
    public static String convertToPrefix(String postfix){
        Stack<String> stack = new Stack<>();

        for(int i = 0; i<postfix.length(); i++){
            char c = postfix.charAt(i);

            if(Character.isLetterOrDigit(c)){
                stack.push(String.valueOf(c));
            }else{
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String expression = c + operand1 + operand2;
                stack.push(expression);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfixExpression = "AB+CD-*";
        String prefixExpression = convertToPrefix(postfixExpression);
        System.out.println("Prefix expression: " + prefixExpression);
    }
}
