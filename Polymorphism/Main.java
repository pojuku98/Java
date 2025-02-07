/*
Write a Java program to create a base class BankAccount with methods deposit() and withdraw(). 
Create two subclasses SavingsAccount and CheckingAccount. 
Override the withdraw() method in each subclass to impose different withdrawal limits and fees.
*/
import java.util.Scanner;
import Bank.*;
class Main{
    public static void main(String[] args){

        //讀取使用者輸入
        Scanner readInput = new Scanner(System.in);

        // 要求取得使用者密碼進行比對，錯誤3次即離開，正確(0000)則往下
        System.out.print("Please enter your passwords: ");  
        int i=3;
        while ( i>0 ){
            String passwords = readInput.nextLine();

            // 密碼錯誤，則進入錯誤提醒訊息
            if ( !(passwords.equals("0000")) ){
                i = Main.wrongPasswords(i);

            // 密碼正確，接著選擇存錢(0)或提款(1)
            } else {
                System.out.print("Do you want to deposit(0) or withdraw(1)? ");
                int LeftOrRight = readInput.nextInt();
                if ( LeftOrRight == 0 ){
                    //要存錢的 
                    BankAccount customer = new BankAccount(passwords);
                    System.out.print("How much deposit? ");
                    int Money = readInput.nextInt();
                    customer.deposit(Money);
                    System.out.println("Now your balance: " + customer.getBalance());
                } else {
                    //要領錢的
                    System.out.println("Which account to withdraw? Saving(0) or Checking(1)? ");
                    LeftOrRight = readInput.nextInt();
                    System.out.println("How much do you want?");
                    int Money = readInput.nextInt();
                    if ( LeftOrRight == 0 ){
                        // Saving Account
                        SavingsAccount b = new SavingsAccount(passwords, 650);
                        Main.takeMoney(b, Money);   // 500
                    } else {
                        // Checking Account
                        CheckingAccount c = new CheckingAccount(passwords, 25);
                        Main.takeMoney(c, Money);    //2025
                    }
                }
                break;
            }
            
        }
    }

    // 要求領錢
    public static void takeMoney(BankAccount a, int amount){
        a.withdraw(amount);
    }

    // 密碼錯誤提示訊息
    public static int wrongPasswords(int i){
        System.out.print("違う。");
        i--;

        // 提醒剩餘次數，若答錯滿3次則告知結束
        if ( i>0 ){
            System.out.print(" 残り" + i +"回: ");
        } else {
            System.out.print(" Close the quest. ");
        }

        return i;
    }
}
