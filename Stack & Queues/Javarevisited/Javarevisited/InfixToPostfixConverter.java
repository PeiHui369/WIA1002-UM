package Javarevisited;

import java.util.Stack;

public class InfixToPostfixConverter {
    public static String convertToPostfix(String infix){
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<infix.length(); i++){
            char ch = infix.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                postfix.append(ch);
            }else if (ch == '('){
                stack.push(ch);
            }else if (ch == ')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    postfix.append(stack.pop());
                }
                stack.pop(); //Discard the opening parenthesis
            }else{
                while(!stack.isEmpty() && getPrecedence(ch) <= getPrecedence(stack.peek())){
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    private static int getPrecedence(char operator){
        switch(operator){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }
    public static void main(String[] args) {
        String infix = "((A-(B/C))*((A/K)-L))";
        String postfix = convertToPostfix(infix);
        System.out.println("Postfix expression: " + postfix);
    }
}
