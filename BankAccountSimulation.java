package IntershipTasks;
import java.util.*;

class Account {
    protected String accHolderName;
    protected int accountNo;
    protected double balance;
    ArrayList<String> transHistory=new ArrayList<>();
    public Account(String accHolderName,int accountNo,double balance){
        this.accHolderName=accHolderName;
        this.accountNo=accountNo;
        this.balance=balance;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(int amount){
        balance+=amount;
        System.out.println("balance after deposit of amount "+amount+" is:"+getBalance());
        transHistory.add("amount deposited to your account:"+ amount);
    }
    public void withDraw(int amount){
        if(amount>balance){
            System.out.println("Failed to Withdraw. Insufficient Balance...");
        }
        else{
            balance-=amount;
            System.out.println("balance after withdraw of amount"+amount+" is:"+getBalance());
            transHistory.add("amount withdrawn from your account:"+ amount);
        }
    }
    public void printTransHistory(){
        System.out.println("\n-------Transaction Hsistory------");
        for(String t: transHistory){
            System.out.println(t);
        }
    }
}
class SavingsAccount extends Account{
    double minBal=500;
    public SavingsAccount(String accHolderName,int accountNo,double balance){
        super(accHolderName, accountNo, balance);
    }
    @Override
    public void withDraw(int amount){
        if(balance-amount>=minBal){
            super.withDraw(amount);
        }
        else{
            transHistory.add("Failed to withdraw because of min balance rule");
            System.out.println("cannot withdraw "+amount+" mininimum balance "+minBal+" must maintain but you have only "+getBalance());
        }
    }
}
public class BankAccountSimulation {
    public static void main(String[] args) {
        SavingsAccount s=new SavingsAccount("narendra", 12345, 1450.30);
        System.out.println("your balance:"+s.getBalance());
        s.deposit(500);
        s.withDraw(700);
        s.withDraw(1000);
        s.printTransHistory();
    }
}
