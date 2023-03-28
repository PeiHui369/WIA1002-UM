import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
To solve this problem, we can use a queue data structure to keep track of the shares bought on each day.
We will dequeue the shares from the queue using the FIFO protocol when we sell them.

1. Create an empty queue to keep track of the shares bought on each day.
2. Read in the input sequence of transactions, one at a time.
3. For each transaction, parse out the number of shares bought or sold, and the price per share.
4. If the transaction is a "buy" transaction, enqueue the specified number of shares to the queue.
5. If the transaction is a "sell" transaction, calculate the capital gain or loss for the shares sold.
6. Dequeue shares from the queue using the FIFO protocol, until the specified number of shares have been sold.
7. Calculate the capital gain or loss for the shares sold using the FIFO protocol, and add it to the total gain or loss for the sequence.
8. Print out the total gain or loss for the sequence
 */
public class StockTransaction {
    public static void main(String[] args) {
        Queue<Integer> sharesBought = new LinkedList<Integer>();

        int totalGainOrLoss = 0;

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");

            //“buy x share(s) at $y each” or “sell x share(s) at $y each,”
            int numShares = Integer.parseInt(tokens[1]);
            int pricePerShare = Integer.parseInt(tokens[4]);

            if(tokens[0].equals("buy")){
                for(int i = 0; i<numShares; i++){
                    sharesBought.offer(pricePerShare);
                }
            }else if(tokens[0].equals("sell")){
                int sharesSold = numShares;
                while(sharesSold > 0){
                    int sharesOnDayBought = sharesBought.poll(); //To retrieve & remove head of PQ
                    int gainOrLossPerShare = pricePerShare - sharesOnDayBought;
                    totalGainOrLoss += gainOrLossPerShare;
                    sharesSold--;
                }
            }
        }
        System.out.println("Total gain or loss: $" +totalGainOrLoss);
    }
}

/*
Let's go through each part of the code:

1. We create an empty queue called sharesBought to keep track of the shares bought on each day. We also create a variable called totalGainOrLoss to keep track of the total gain or loss for the sequence.

2. We read in the input sequence of transactions, one at a time, using a Scanner object.

3. For each transaction, we parse out the number of shares bought or sold, and the price per share.

4. If the transaction is a "buy" transaction, we enqueue the specified number of shares to the sharesBought queue.

5. If the transaction is a "sell" transaction, we calculate the capital gain or loss for the shares sold.

6. We dequeue shares from the sharesBought queue using the FIFO protocol, until the specified number of shares have been sold.

7. We calculate the capital gain or loss for the shares sold using the FIFO protocol, and add it to the totalGainOrLoss variable.

8. We print out the totalGainOrLoss variable as the final output of the program.

Note that this program assumes that the input transactions are well-formed and do not contain any errors. It also assumes that there are always enough shares in the sharesBought queue to satisfy a "sell" transaction. If these assumptions do not hold

 */
