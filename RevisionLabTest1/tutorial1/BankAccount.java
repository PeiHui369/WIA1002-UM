package tutorial1;

public class BankAccount implements Account {
    private int balance;
    BankAccount(int balance){
        this.balance = balance;
    }

    @Override
    public int deposit(int add){
        return this.balance += add;
    }

    @Override
    public boolean withdraw(int out){
        if(this.balance>=out){
            this.balance -= out;
            return true;
        }
        return false;
    }
}
