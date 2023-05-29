public class StringSubstitutor {
    public static String substituteAI(String str){
        if(str.length() == 0){
            return str;
        }

        char firstChar = str.charAt(0);

        if(firstChar == 'a'){
            return 'i' + substituteAI(str.substring(1));
        }else if(firstChar == 'A'){
            return 'A' + substituteAI(str.substring(1));
        }else{
            return firstChar + substituteAI(str.substring(1));
        }
    }

    public static void main(String[] args) {
        String input1 = "flabbergasted";
        String output1 = substituteAI(input1);
        System.out.println("Input String: " + input1);
        System.out.println("Output String: " + output1);

        String input2 = "Astronaut";
        String output2 = substituteAI(input2);
        System.out.println("Input String: " + input2);
        System.out.println("Output String: " + output2);

    }
}

---
Certainly! Here's an example of a recursive function in Java called `substituteAI()` that substitutes lowercase "a" characters with "i" characters in a given string:

```java
public class StringSubstitutor {
    public static String substituteAI(String str) {
        if (str.length() == 0) {
            return str;
        }

        char firstChar = str.charAt(0);

        if (firstChar == 'a') {
            return 'i' + substituteAI(str.substring(1));
        } else if (firstChar == 'A') {
            return 'A' + substituteAI(str.substring(1));
        } else {
            return firstChar + substituteAI(str.substring(1));
        }
    }

    public static void main(String[] args) {
        String input1 = "flabbergasted";
        String output1 = substituteAI(input1);
        System.out.println("Input String: " + input1);
        System.out.println("Output String: " + output1);

        String input2 = "Astronaut";
        String output2 = substituteAI(input2);
        System.out.println("Input String: " + input2);
        System.out.println("Output String: " + output2);
    }
}
```

In this code, the `substituteAI()` function takes a string as input and recursively substitutes lowercase "a" characters with "i" characters. The function checks the first character of the string. If it is a lowercase "a", it substitutes it with "i" and recursively calls `substituteAI()` on the remaining substring. If the first character is an uppercase "A", it skips the substitution and proceeds with the recursion. If the first character is neither "a" nor "A", it simply appends it to the result and proceeds with the recursion.

When executed, the code will output:

```
Input String: flabbergasted
Output String: flibbergisted

Input String: Astronaut
Output String: Astroniut
```

The lowercase "a" in the first input string is substituted with "i", while the uppercase "A" remains unchanged. In the second input string, no substitution is made as it starts with an uppercase "A".
