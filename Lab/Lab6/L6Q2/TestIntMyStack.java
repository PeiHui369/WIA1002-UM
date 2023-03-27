import java.util.Scanner;

public class TestIntMyStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer value: ");
        int num = sc.nextInt();

        MyStack<Integer> intStack = new MyStack<>();
        for(int i = 1; i<=num; i++){
            intStack.push(i);
        }

        System.out.println("Size of stack: " +intStack.getSize());

        while(!intStack.isEmpty()){
            System.out.println(intStack.pop());
        }
    }
}
