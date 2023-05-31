package Javarevisited;

import java.util.Stack;

public class PrefixToInfix {
    public static String convertPrefixToInfix(String prefix) {
        Stack<String> stack = new Stack<>();

        for (int i = prefix.length() - 1; i >= 0; i--) {
            char ch = prefix.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                stack.push(String.valueOf(ch));
            } else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String infix = "(" + operand1 + ch + operand2 + ")";
                stack.push(infix);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String prefixExpression = "*-A/BC-/AKL";
        String infixExpression = convertPrefixToInfix(prefixExpression);
        System.out.println("Infix expression: " + infixExpression);
    }
}
