public class StringPermuter {
    public static void permuteString(String str) {
        permuteStringHelper("",str);
    }

    public static void permuteStringHelper(String prefix, String suffix){
        int n = suffix.length();
        //Base case: if the suffix is empty, we have reached a permutation
        if(n==0){
            System.out.println(prefix);
        }else{
            //Recursive case: choose each character from the suffix and permute the remaining characters
            for(int i = 0; i<n; i++){
                permuteStringHelper(prefix + suffix.charAt(i), suffix.substring(0,i) + suffix.substring(i+1));
            }
        }
    }

    public static void main (String[] args){
        String word = "ABC";
        System.out.println("Input String: "+word);
        System.out.println("Output Permutation: ");
        permuteString(word);
    }
}

---
  Certainly! Here's an example of a recursive method in Java called `permuteString()` that finds and prints all the possible permutations of a given word:

```java
public class StringPermuter {
    public static void permuteString(String str) {
        permuteStringHelper("", str);
    }

    private static void permuteStringHelper(String prefix, String suffix) {
        int n = suffix.length();
        // Base case: if the suffix is empty, we have reached a permutation
        if (n == 0) {
            System.out.println(prefix);
        } else {
            // Recursive case: choose each character from the suffix and permute the remaining characters
            for (int i = 0; i < n; i++) {
                permuteStringHelper(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1));
            }
        }
    }

    public static void main(String[] args) {
        String word = "ABC";
        System.out.println("Input String: " + word);
        System.out.println("Output Permutation:");
        permuteString(word);
    }
}
```

In this code, the `permuteString()` method is called with a given word. The method then calls the helper function `permuteStringHelper()` with an empty prefix and the original word as the suffix. The `permuteStringHelper()` function handles the recursive logic.

In the `permuteStringHelper()` function, if the suffix is empty, we have reached a permutation, so we print the prefix. Otherwise, we iterate through each character of the suffix. For each character, we append it to the prefix, remove it from the suffix, and recursively call `permuteStringHelper()` with the updated prefix and suffix.

When executed, the code will output:

```
Input String: ABC
Output Permutation:
ABC
ACB
BAC
BCA
CAB
CBA
```

These are all the possible permutations of the input string "ABC".
