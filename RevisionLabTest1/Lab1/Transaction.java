package Lab1;
public class Transaction {
    private java.util.Date date;
    private char type;
    private double amount;
    private double balance;
    private String description;

    Transaction(char type, double amount, double balance, String description){
        date = new java.util.Date(); //
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    //##
    public java.util.Date getDate() {    return date;  }
    public char getType() {    return type;  }
    public double getAmount() {    return amount;  }
    public double getBalance() {    return balance;  }
    public String getDescription() {    return description;  }
}
