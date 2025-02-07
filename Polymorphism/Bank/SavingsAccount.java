package Bank;
public class SavingsAccount extends BankAccount{
    // withdraw amount cannot bigger than this
    public int withdrawalLimit;

    // Constructor for SavingAccount
    public SavingsAccount(String passwords, int withdrawalLimit){
        super(passwords);
        this.withdrawalLimit = withdrawalLimit;
    }

    // Withdraw money from SavingAccount
    public void withdraw(int amount){
        if (amount <= this.withdrawalLimit){
            super.withdraw(amount);
        } else {
            System.out.println("Withdrawal limit exceeded.");
        }
    }
}