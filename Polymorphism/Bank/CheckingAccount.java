package Bank;
public class CheckingAccount extends BankAccount{
    // overdraft will be added when this account has not enough money.
    public int overdraftFee;

    // Constructor for CheckingAccount
    public CheckingAccount(String passwords, int overdraft){
        super(passwords);
        this.overdraftFee = overdraft;
    }

    // Withdraw money from CheckingAccount
    public void withdraw(int amount){
        if(amount <= this.balance){
            super.withdraw(amount);
        } else {
            System.out.println("Overdraft fee applied: " + (amount + this.overdraftFee));
        }
    }
}