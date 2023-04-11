package Lab5;

import java.util.Random;
import java.util.Scanner;

public class L5Q3 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of employee: ");
        int N = sc.nextInt();

        int[][] workHours = new int[N][7];

        for(int i = 0; i<N; i++){
            for(int j = 0; j<7; j++){
                workHours[i][j] = random.nextInt(8)+1;
            }
        }

        int sum;
        System.out.println("Displaying the work hours in 7 days and the total hours for each employee...");
        for(int i = 0; i<N; i++){
            sum = 0;
            System.out.println("Employee " + (i+1) + ":");
            for(int j = 0; j<7;j++){
                System.out.println("Day " + (j+1) + ": " + workHours[i][j]);
                sum += workHours[i][j];
            }
            System.out.println("Total work hours: " + sum);
            System.out.println();
        }
    }
}
