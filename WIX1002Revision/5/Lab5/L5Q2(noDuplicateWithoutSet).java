package Lab5;

import java.util.Random;

public class L5Q2{
    public static void main(String[] args) {
        int n = 10; //Number of random integers to generate
        int start = 0; //Starting range (inclusive)
        int end = 20; //Ending range (inclusive)

        int[] numbers = new int [n];
        Random random = new Random();

        //Generate non-duplicate random integers
        for(int i = 0; i<n; i++){
            int num = random.nextInt((end-start)+1)+start;
            //Check if the generated number already exists in the array
            while(contains(numbers, num)){ //#WHILE to keep checking
                num = random.nextInt((end-start)+1)+start;
            }
            numbers[i] = num;
        }

        //Print the generated random integers
        System.out.println("Generated Random Integers: ");
        for(int num : numbers){
            System.out.println(num);
        }
    }

    //Helper method to check if an array contains a given element
    public static boolean contains(int[] arr, int num){
        for (int j : arr) {
            if (j == num) {
                return true;
            }
        }
        return false;
    }

}
