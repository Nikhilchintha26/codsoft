package projects.atm_machine;

import java.util.Scanner;

public class ATM {
    float balance;
    int pin;

    public ATM(int balance,int pin) {
        this.balance = balance;
        this.pin=pin;
    }

    public void checkPin(){
        System.out.println("Enter the pin :");
        Scanner sc=new Scanner(System.in);
        int enterdPin= sc.nextInt();
        if(enterdPin==pin){
            manu();
        }else {
            System.out.println("wrong pin ");
        }

    }
    public void manu(){
        System.out.println("Enter your choice :\n 1.check Balance \n 2.Withdraw money \n 3.Deposit money \n 4.exit");
        Scanner sc=new Scanner(System.in);
        int opt=sc.nextInt();
        switch (opt){
            case 1:checkBalance(); break;
            case 2:withDraw(); break;
            case 3:deposit(); break;
            case 4:exit();break;
            default: System.out.println("unvalid option");

        }

    }

    private void exit() {
        System.out.println("Thanks for visit . ");
    }

    private void deposit() {
        System.out.println("Enter the amount to deposit :");
        Scanner sc=new Scanner(System.in);
       float amount= sc.nextFloat();
        if(amount==amount){
            balance+=amount;
            checkBalance();
        }
        manu();
    }

    private void withDraw() {
        System.out.println("enter amount ");
        Scanner sc=new Scanner(System.in);
        float amount= sc.nextFloat();
        if(balance>amount){
            balance-=amount;
            System.out.println(" the amount withdraw is"+amount);
        }else {
            System.out.println("not sufficient amount ");
        }
         manu();
    }

    private void checkBalance() {
        System.out.println("The balance in account is:"+balance);
        manu();
    }

    public static void main(String[] args) {
        ATM atm=new ATM(100,1234);
        atm.checkPin();
    }
}
