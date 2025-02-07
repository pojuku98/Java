package Bank;
public class BankAccount{
    protected int balance = 2000;
    protected String passwords;

    // Constructor for BankAccount
    public BankAccount(String passwords){
        this.passwords = passwords;
    }

    // Getters
    public int getBalance(){
        return this.balance;
    }

    // Deposit money into account
    public void deposit(int amount){
        this.balance += amount;
    }

    // Withdraw money from account, and tell customers the balance
    public void withdraw(int amount){
        if (amount <= this.balance){
            System.out.println("Here is your money: " + amount);
            this.balance -= amount;
            System.out.println("Here is your balance: " + this.balance);
        } else {
            System.out.println("Your balance is not enough: " + this.balance);
        }
        
    }
}