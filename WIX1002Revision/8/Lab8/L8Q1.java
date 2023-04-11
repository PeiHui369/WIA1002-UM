package Lab8;

import java.util.Random;

public class Number {
    int[] arr;
    Random random = new Random();


    Number(){
        arr = new int[10];
        generator(arr,100);
    }

    Number(int size){
        arr = new int [size];
        generator(arr,100);
    }

    Number(int size, int bound){
        arr = new int [size];
        generator(arr,bound);
    }

    public void generator(int[] arr, int bound){
        for(int i = 0; i<arr.length; i++){
            arr[i] = random.nextInt(bound+1);
        }
    }

    public void even(){
        System.out.print("Even numbers: ");
        for(int ele : arr){
            if(ele%2 == 0){
                System.out.print(ele + " ");
            }
        }
        System.out.println();
    }

    //?
    public boolean checkPrime(int n){
        if(n<2){return false;}
        for(int i = 2; i<n/2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void prime(){
        System.out.print("Prime numbers: ");

        for(int ele : arr){
            if(checkPrime(ele)){
                System.out.print(ele + " ");
            }
        }
        System.out.println();
    }

    public void max(){
        int max = arr[0];
        for(int ele : arr){
            if(ele > max){
                max = ele;
            }
        }
        System.out.println("Maximum: " + max);
    }

    public void min(){
        int min = arr[0];
        for(int ele : arr){
            if(ele < min){
                min = ele;
            }
        }
        System.out.println("Minimum: " + min);
    }

    public void avg(){
        int sum = 0;
        for(int ele : arr){
            sum += ele;
        }
        System.out.println("Average: " + (sum/arr.length));
    }

    public void squareNumber(){
        System.out.print("Square Number: ");
        for(int ele : arr){
            double root = Math.sqrt(ele);
            if(Math.pow(root,2) == (double)ele){
                System.out.print(ele + " ");
            }
        }
        System.out.println();
    }

    public void display(){
        for(int ele : arr){
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Number a = new Number();
        Number b = new Number(5);
        Number c = new Number(4,50);

        c.prime();
        c.even();
        c.max();
        c.min();
        c.avg();
        c.squareNumber();
        c.display();
  }   //even
    //prime
    //max
    //min
    //ave
    //square
    //Tester
}
