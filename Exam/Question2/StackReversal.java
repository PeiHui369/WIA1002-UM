import java.util.Stack;

public class StackReversal {
    public static <T> void reverseStack(Stack<T> stack) {
        if (!stack.isEmpty()) {
            T element = stack.pop();
            reverseStack(stack);
            insertAtBottom(stack, element);
        }
    }

    private static <T> void insertAtBottom(Stack<T> stack, T element) {
        if (stack.isEmpty()) {
            stack.push(element);
        } else {
            T temp = stack.pop();
            insertAtBottom(stack, element);
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        // Test with string elements
        Stack<String> stringStack = new Stack<>();
        stringStack.push("Switch");
        stringStack.push("Motherboard");
        stringStack.push("RAM");
        stringStack.push("SSD");
        stringStack.push("CPU");
        stringStack.push("GPU");
        stringStack.push("Router");

        System.out.println("Original Stack (String): " + stackToString(stringStack));
        reverseStack(stringStack);
        System.out.println("Reversed Stack (String): " + stackToString(stringStack));

        // Test with integer elements
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(17);
        integerStack.push(21);
        integerStack.push(45);
        integerStack.push(23);
        integerStack.push(1);
        integerStack.push(99);
        integerStack.push(16);

        System.out.println("Original Stack (Integer): " + stackToString(integerStack));
        reverseStack(integerStack);
        System.out.println("Reversed Stack (Integer): " + stackToString(integerStack));
    }

    private static <T> String stackToString(Stack<T> stack) {
        StringBuilder sb = new StringBuilder();
        for (T item : stack) {
            sb.append(item).append(" ");
        }
        return sb.toString();
    }

    private static <T> Object[] stackToArray(Stack<T> stack) {
        Object[] array = new Object[stack.size()];
        int index = 0;
        for (T item : stack) {
            array[index] = item;
            index++;
        }
        return array;
    }
}
