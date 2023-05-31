package Javarevisited;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumberGenerator {

    public static void generateBinaryNumbers (int n){
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");

        for(int i = 1; i<=n; i++){
            String binaryNumber = queue.poll();
            System.out.println(binaryNumber);
            // 1 out, 10 out, 11 out
            queue.offer(binaryNumber + "0");//add 10 to queue, 100, 110
            queue.offer(binaryNumber + "1");//add 11 to queue, 101, 111
        }
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Binary numbers from 1 to " + n + ":");
        generateBinaryNumbers(n);
    }
}
