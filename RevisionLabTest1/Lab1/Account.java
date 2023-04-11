package Lab1;

public class Account {
    private int id =0;
    private double balance = 0;
    private static double annualInterestRate = 0; //#static
    private java.util.Date dateCreated;

    Account(){
        dateCreated = new java.util.Date();
    }

    Account(int id, double initialBalance){
        this.id = id;
        this.balance = initialBalance;
        dateCreated = new java.util.Date();
    }

    public int getId(){
        return this.id;
    }

    public double getBalance(){
        return this.balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setBalance(double b){
        this.balance = b;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setAnnualInterestRate(double a){
        this.annualInterestRate = a;
    }

    public java.util.Date getDateCreated(){
        return dateCreated;
    }

    public double getMonthlyInterestRate(){
        return annualInterestRate/1200;
    }

    public double getMonthlyInterest(){
        return this.balance * getMonthlyInterestRate();
    }

    public boolean withdraw(double out){
        if(balance>=out){
            balance-=out;
            return true;
        }
        return false;
    }

    public double deposit(double in){
        this.balance += in;
        return this.balance;
    }

    public static void main(String[] args) {
        Account a = new Account(1122,20000);
        a.setAnnualInterestRate(4.5);
        a.withdraw(2500);
        a.deposit(3000);
        System.out.println(a.getBalance());
        System.out.println(a.getMonthlyInterest());
        System.out.println(a.getDateCreated());
    }

}
