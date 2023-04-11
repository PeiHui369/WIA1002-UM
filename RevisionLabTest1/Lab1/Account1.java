package Lab1;
import java.util.ArrayList;

public class Account1{
    private int id;
    private double balance;
    private String name;
    private static double annualInterestRate;//
    private java.util.Date dateCreated;//
    ArrayList<Transaction> transactions = new ArrayList<Transaction>();//#class transaction

    //Default set with date
    public Account1(){
        dateCreated = new java.util.Date();
    }

    Account1(String name, int id, double balance){
        this.name = name;
        this.id = id;
        this.balance = balance;
        dateCreated = new java.util.Date();
    }


    public int getId(){
        return this.id;
    }

    public double getBalance(){
        return this.balance;
    }

    //#
    public java.util.ArrayList<Transaction> getTransactions(){
        return transactions;
    }

    public String getName(){
        return this.name;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setBalance(double b){
        this.balance = b;
    }

    public void setId(int id){
        this.id = id;
    }

    public static void setAnnualInterestRate(double anualInterestRate){
        Account1.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterest(){
        return balance * (annualInterestRate/1200);
    }

    public java.util.Date getDateCreated(){
        return dateCreated;
    }
    public void withdraw(double amount){
        balance -= amount;
        transactions.add(new Transaction('W', amount, balance, "")); //#
    }

    public void deposit(double amount){
        balance += amount;
        transactions.add(new Transaction('D', amount, balance, "")); //#
    }

}
