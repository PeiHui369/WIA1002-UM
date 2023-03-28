import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        //Convert the input string to lowercase and remove all non-letter characters
        inputString = inputString.toLowerCase().replaceAll("[^a-z]","");

        //Create a Queue to hold the characters in the input string
        Queue<Character> queue = new LinkedList<Character>();

        //Add each character of the input string to the Queue
        for(int i = 0; i<inputString.length(); i++){
            queue.add(inputString.charAt(i));
        }

        //Create a StringBuilder to hold the reversed input string
        StringBuilder reversedString = new StringBuilder();

        //Remove each character from the Queue and add it to the StringBuilder
        while(!queue.isEmpty()){
            reversedString.append(queue.remove());
        }

        //Check if the input string is equal to the reversed string
        if(inputString.equals(reversedString.toString())) {
            System.out.println("The input string is a palindrome.");
        }else{
            System.out.println("The input string is not a palindrome.");
        }
    }
}

/*
The program first prompts the user to enter a string.
It then converts the input string to lowercase and removes all non-letter characters using the 'replaceAll()' method.
It creates a 'Queue' of 'Character' objects to hold the characters in the input string,
and adds each character to the 'Queue' using a 'for' loop.
It then creates a 'StringBuilder' to hold the reversed input string,
and removes each character from the 'Queue' and adds it to the 'StringBuilder' using a 'while' loop.
Finally, it checks if the original input string is equal to the reversed string using the 'equals()' method, and prints out whether or not the input string is a palindrome.

In regular expressions, '[^a-z]' is a character class that matches any character that is not a lowercase letter.
The '^' inside the brackets '[]' is a negation operator that indicates that the character class should match any character that is not in the set of characters specified by the class.
In this case, the set of characters specified is 'a' through 'z', so '[^a-z]' will match any character that is not a lowercase letter.


 */