import java.util.Scanner;
import java.util.Stack;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of disks: ");
        int n = sc.nextInt();

        Stack<Integer> source = new Stack<>();
        Stack<Integer> auxiliary = new Stack<>();
        Stack<Integer> destination = new Stack<>();

        //Push disk onto source stack in decreasing order of size
        for(int i = n; i>0; i--){
            source.push(i);
        }

        int totalMoves = (int) Math.pow(2,n) - 1; //#

        //If the number of disks is odd, swap auxiliary and destination stacks
        if(n%2 ==1){
            Stack<Integer> temp = destination;
            destination = auxiliary;
            auxiliary = temp;
        }

        for(int i = 1; i<=totalMoves; i++){
            if(i%3==1){
                moveDisk(source,destination);
            }else if(i%3==2){
                moveDisk(source,auxiliary);
            }else{
                moveDisk(auxiliary,destination);
            }
        }
        System.out.println("Tower of Hanoi successfully completed!");
    }

    private static void moveDisk(Stack<Integer> source, Stack<Integer> destination){
        if(source.isEmpty()){
            destination.push(source.pop());
        }else if(destination.isEmpty()){
            destination.push(source.pop());
        }else if(source.peek() < destination.peek()){
            destination.push(source.pop());
        }else{
            source.push(destination.pop());
        }
    }
}
