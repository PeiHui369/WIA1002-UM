package Javarevisited;

import java.util.Stack;

public class PostfixEvaluator {
    public static int evaluatePostfix (String postfix){
        Stack<Integer> stack = new Stack<>();

        for(char c : postfix.toCharArray()){
            if(Character.isDigit(c)){
                int operand = Character.getNumericValue(c);
                stack.push(operand);
            }else{
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(c, operand1, operand2);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    private static int performOperation(char operator, int operand1, int operand2){
        switch(operator){
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        String postfixExpression = "24*";
        int result = evaluatePostfix(postfixExpression);
        System.out.println("Result: " + result); //Output: 8
    }
}

