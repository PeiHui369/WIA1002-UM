import java.util.Scanner;
import java.util.Stack;

public class L6Q4 {
    public static void main(String[] args) {
        Stack<Character> strStack = new Stack<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string (Max 15 characters):");
        String line = sc.nextLine();

        for(int index = 0; index < line.length(); index++){
            strStack.push(line.charAt(index));
        }

        String reversed = "";
        while(!strStack.isEmpty()){
            reversed += strStack.pop();
        }

        if(reversed.equals(line)){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not Palindrome");
        }

    }
}
