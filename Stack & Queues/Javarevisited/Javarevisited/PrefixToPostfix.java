package Javarevisited;

import java.util.Stack;

public class PrefixToPostfix {
    public static String convertPrefixToPostfix(String prefix) {
        Stack<String> stack = new Stack<>();

        for (int i = prefix.length() - 1; i >= 0; i--) {
            char ch = prefix.charAt(i);

            if (isOperand(ch)) {
                stack.push(Character.toString(ch));
            } else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String postfix = operand1 + operand2 + ch;
                stack.push(postfix);
            }
        }

        return stack.pop();
    }

    private static boolean isOperand(char ch) {
        return Character.isLetter(ch) || Character.isDigit(ch);
    }

    public static void main(String[] args) {
        String prefixExpression = "*+AB-CD";
        String postfixExpression = convertPrefixToPostfix(prefixExpression);
        System.out.println("Postfix expression: " + postfixExpression);
    }
}
