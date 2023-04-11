package Lab8;

public class BankAccount {
    String name, IC_passportNumber;
    double balance;

    BankAccount(String name, String IC_passportNumber, double initialDeposit){
        this.name = name;
        this.IC_passportNumber = IC_passportNumber;
        this.balance = initialDeposit;
    }

    public double deposit(double depositAmount){
        return (this.balance += depositAmount);
    }

    public boolean withdraw(double withdrawAmount){
        if(withdrawAmount > balance){
            return false;
        }
        this.balance -= withdrawAmount;
        return true;
    }

    public void displayInfo(){
        System.out.printf("Name: %s\nIC/Passport Number: %s\nBalance: %.2f\n",name,IC_passportNumber,balance);
    }

    public static void main(String[] args) {
        BankAccount a = new BankAccount("Jyune", "369",1000000.00);
        a.displayInfo();

        a.deposit(100);
        a.displayInfo();

        a.withdraw(1);
        a.displayInfo();
    }
}
