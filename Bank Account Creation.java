import java.util.Scanner;

class BankAccount{
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    //constructor to initialse the account details
    public  BankAccount(String accountNumber,String accountHolderName,double initialBalance){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }
    //method to deposit money
    public void deposit(double amount){
        if(amount>0){
            balance += amount;
            System.out.println("Deposited: Rs " + amount);
        }
        else{
            System.out.println("Deposited amount is invalid!!");
        }
    }
    //method for withdrawal of money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: Rs" + amount);
        } 
        else {
            System.out.println("INSUFFICIENT FUNDS in your account!!!");
        }
    }
    //method for checking the balance in account
    public void checkBalance(){
        System.out.println("Current Balance : Rs " + balance);
    }
    
    //method for dispalying the details
    public void displayAccountDetails(){
        System.out.println("Account number : " +accountNumber);
        System.out.println("Account holder name : " + accountHolderName);
        System.out.println("Balance Rs:  " + balance);
    }
}

public class BankCreation{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the account number:");
        String accountNumber = scan.nextLine();

        System.out.println("Enetr the account holder name:");
        String accountHolderName = scan.nextLine();

        System.out.println("Enter the initial deposit amount");
        double initialDeposit = scan.nextDouble();

        // Creating  a new Account object
        BankAccount account = new BankAccount(accountNumber,accountHolderName,initialDeposit); 

        boolean flag = false;
        while(!flag){
            System.out.println("\nBank Account Management System");
            System.out.println("1. Deposit");
            System.out.println("2. Withdrawal");
            System.out.println("3. Check Balance");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Choose an option from the above: ");

            int op = scan.nextInt();

            switch(op){
                case 1:
                System.out.println("Enter the deposit amount:");
                double depositAmount = scan.nextDouble();
                account.deposit(depositAmount);
                break;
                case 2:
                System.out.println("Enter the amount to withdraw:");
                double withdrawAmount = scan.nextDouble();
                account.withdraw(withdrawAmount);
                break;
                case 3:
                account.checkBalance();
                break;
                case 4:
                account.displayAccountDetails();
                break;
                case 5:
                System.out.println("Exiting .....");
                flag = true;
                break;
                default:
                System.out.println("There was an error!! Please enter a valid option.");
                break;               
            }
        }
        scan.close();
    }
}




