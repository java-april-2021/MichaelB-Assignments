import java.util.Random;
public  class BankAccount{
    private String acctNumber;
    private double checkingBalance, savingsBalance;
    private static int numberOfAccounts = 0;
    private static int total_amount = 0;

    public BankAccount(){
        this.acctNumber = randAcctNum();
        numberOfAccounts++;
    }
    //random number generator
    private String randAcctNum(){
        String acctNum;
        char num[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        StringBuilder account = new StringBuilder();
        for(int i = 0; i < 10; i++){
            account.append(num[(int) Math.floor(Math.random() * 9)]);
        }
        acctNum = account.toString();
        return acctNum;
    }

    //getter methods
    public String getAccountNum(){
        return acctNumber;
    }
    public double getCheckingBalance(){
        return checkingBalance;
    }

    public double getSavingsBalance(){
        return savingsBalance;
    }

    //setter methods

    public void depositChecking(double desposit){
        this.checkingBalance += desposit;
        total_amount += desposit;
    }

    public void depositSavings(double desposit){
        this.savingsBalance += desposit;
        total_amount += desposit;
    }

    public String withdrawChecking(double withdraw){
        String fail = "Insuffient funds for transaction";
        String success = "Transaction sucessful";
        if( (getCheckingBalance() - withdraw) < 0){
            System.out.println(fail);
            return fail;
        }
        this.checkingBalance -= withdraw;
        total_amount -= withdraw;
        System.out.println(success);
        return success;
    }

    public String withdrawSavings(double withdraw){
        String fail = "Insuffient funds for transaction";
        String success = "Transaction sucessful";
        if((getSavingsBalance() - withdraw) < 0){
            System.out.println(fail);
            return fail;
        }
        this.savingsBalance -= withdraw;
        total_amount -= withdraw;
        System.out.println(success);
        return success;
    }

    public static void totalFunds(){
        System.out.printf("Total funds in the bank: %d\n", total_amount);
    }

    public static void totalAccount(){
        System.out.printf("Total number of account: %d\n", numberOfAccounts);
    }
}