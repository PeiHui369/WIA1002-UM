import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class L5Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Random random = new Random();

        System.out.println("Enter number of students: ");
        int N = sc.nextInt();

        int[] scores = new int[N];
        int sum = 0;

        for(int i = 0; i<N; i++){
            scores[i] = random.nextInt(101);
            sum+=scores[i];
        }

        System.out.println("List of scores: " + Arrays.toString(scores));
        Arrays.sort(scores);
        System.out.println("The highest score: " +scores[scores.length-1]);
        System.out.println("The lowest score: " +scores[0]);
        System.out.println("The average score: " + sum/N);

    }
}

/*
Enter number of students: 
10
List of scores: [29, 80, 88, 14, 97, 0, 66, 59, 24, 9]
The highest score: 97
The lowest score: 0
The average score: 46

*/
