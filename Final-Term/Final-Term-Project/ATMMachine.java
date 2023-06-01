import java.util.*;
import static java.lang.System.out;
public class ATMMachine{
    private Integer key, choice;
    public static void main(String[] args){
        ATMMachine atm=new ATMMachine();
        atm.displayHeads();
    }
    public void displayHeads(){
        out.println("====================================================");  
        out.println("        WELCOME TO THIS SIMPLE ATM MACHINE          ");
        out.println("====================================================");  
        out.println();
        displayTransactions();
    }
    public void displayTransactions(){
        out.println();
        out.println("Please Select ATM Transactions");
        out.println("Press [1] Deposit");
        out.println("Press [2] Withdraw");
        out.println("Press [3] Balance Inquiry");
        out.println("Press [4] Exit");
        out.println();
        setChoice();
    }
    public void setChoice(){
        try{
            Scanner read=new Scanner(System.in);
            out.print("What Would You Like To Do? ");
            key=read.nextInt();
            switch(key){
                case 1:
                    keyDeposit();
                    break;
                case 2:
                    keyWithdraw();
                    break;
                case 3:
                    keyBalance();
                    break;
                case 4:
                    out.println("Transaction Exited");
                    retryChoice();
                    break;
                default:
                    out.println("Please Choose Only From The Above Trasanction");
                    retryChoice();
            }
        }
        catch(InputMismatchException str){
            out.println("Numbers Only Please...");
            retryChoice();
        }
    }
    public void retryChoice(){
        try{
            out.println();
            Scanner read=new Scanner(System.in);
            out.println("Would You Like To Try Another Transaction?");
            out.println();
            out.println("Press [1] Yes");
            out.println("Press [2] No");
            out.print("Enter Choice: ");
            choice=read.nextInt();
            switch(choice){
                case 1:
                    displayTransactions();
                    break;
                case 2:    
                    out.println("Thank You For Using This Simple ATM Machine...");
                    break;
                default: 
                    out.println("Please Choose From Above Only...");
                    retryChoice();
                }
        }
        catch(InputMismatchException str){
            out.println("Wrong Input... EXITING...");
        }
    }
    public void keyDeposit(){
        try{
            Scanner read=new Scanner(System.in);
            out.println();
            out.print("Enter The Amount Of Money To Deposit: ");
            Deposit.deposit=read.nextDouble();
            out.println("You Deposited The Amount Of "+Deposit.deposit);
            BalanceInquiry.balances=Deposit.deposit+BalanceInquiry.balances;
            retryChoice();
        }
        catch(InputMismatchException str){
            out.println("Invalid Input");
            retryChoice();
        }
    }
    public void keyWithdraw(){
        try{
            Scanner read=new Scanner(System.in);
            out.println("To Withdraw, Make Sure That You Have Sufficient Balance In Your Account.");
            out.print("Enter Amount Of Money To Withdraw: ");
            Withdraw.withdraw=read.nextDouble();
            if(BalanceInquiry.balances==0){
                out.println("No Money Deposited.");
            }
            else if(Withdraw.withdraw>BalanceInquiry.balances){
                out.println("Insufficient Balance. Can't Perform Withdrawal."); 
            }
            else{
                BalanceInquiry.balances=BalanceInquiry.balances-Withdraw.withdraw;
                out.println("You Withdraw The Amount of "+Withdraw.withdraw);
            }
            retryChoice();
        }
        catch(InputMismatchException str){
            out.println("Invalid Input");
        }
    }
    public void keyBalance(){
        out.println("Your Current Balance Is: "+BalanceInquiry.getBalance());
        retryChoice();
    }
}