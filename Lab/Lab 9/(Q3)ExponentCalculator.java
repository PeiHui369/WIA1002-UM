public class ExponentCalculator {
    public static long exponent(int x, int y){
        if(y==0){
            return 1;
        }
        return x * exponent(x, y-1);
    }

    public static void main(String[] args) {
        int base = 10;
        int exponent = 3;
        long result = exponent(base, exponent);
        System.out.println(base + " raised to the power of " + exponent + " is: "+ result);
    }
}

---
Certainly! Here's an example of a recursive method in Java called `exponent()` to perform exponentiation:

```java
public class ExponentCalculator {
    public static long exponent(int x, int y) {
        if (y == 0) {
            return 1;
        }
        
        return x * exponent(x, y - 1);
    }

    public static void main(String[] args) {
        int base = 10;
        int exponent = 3;
        long result = exponent(base, exponent);
        System.out.println(base + " raised to the power of " + exponent + " is: " + result);
    }
}
```

In this code, the `exponent()` method takes two parameters: `x` and `y`. It performs exponentiation by recursively multiplying `x` by itself `y` times. 

The base case is when `y` is 0, in which case the method returns 1 since any number raised to the power of 0 is 1. Otherwise, the method recursively multiplies `x` with `exponent(x, y - 1)` to perform the exponentiation.

In the `main()` method, an example invocation of `exponent()` is performed with `x` equal to 10 and `y` equal to 3. The result is then printed to the console:

```
10 raised to the power of 3 is: 1000
```

The method correctly performs the exponentiation of `x` raised to the power of `y` and returns the result.
