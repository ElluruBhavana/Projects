import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    @SuppressWarnings("unused")
    private String accountHolderName;
    private double balance;
    private String pin;

    // Constructor to initialize account details
    public BankAccount(String accountNumber, String accountHolderName, double initialBalance, String pin) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.pin = pin;
        System.out.println("Account created with initial balance: Rs " + initialBalance);
    }

    // Method to authenticate user with PIN
    public boolean authenticate(String inputPin) {
        return this.pin.equals(inputPin);
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: Rs " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: Rs " + amount);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Current balance: Rs " + balance);
    }

    // Getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }
}

public class BankManagementSystem {
    private static ArrayList<BankAccount> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Method to create a new account
    private static void createAccount() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String accountHolderName = scanner.nextLine();

        double initialDeposit = 0;
        while (true) {
            try {
                System.out.print("Enter Initial Deposit Amount: ");
                initialDeposit = Double.parseDouble(scanner.nextLine());
                if (initialDeposit < 0) {
                    System.out.println("Initial deposit must be positive.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please enter a numeric value.");
            }
        }

        String pin;
        while (true) {
            System.out.print("Set a 4-digit PIN: ");
            pin = scanner.nextLine();
            if (pin.matches("\\d{4}")) {
                break;
            } else {
                System.out.println("Invalid PIN. Please enter a 4-digit numeric PIN.");
            }
        }

        BankAccount account = new BankAccount(accountNumber, accountHolderName, initialDeposit, pin);
        accounts.add(account);
        System.out.println("Account created successfully!");
    }

    // Method to find an account by account number
    private static BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (accountNumber.equals(account.getAccountNumber())) {
                return account;
            }
        }
        return null;
    }

    // Method to authenticate and log into an account
    private static void login() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        BankAccount account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter 4-digit PIN: ");
        String pin = scanner.nextLine();

        if (!account.authenticate(pin)) {
            System.out.println("Incorrect PIN. Access denied.");
            return;
        }

        System.out.println("Login successful!");
        boolean exit = false;
        while (!exit) {
            System.out.println("\nBank Account Management System");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid option. Please enter a number between 1 and 4.");
                continue;
            }
            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = Double.parseDouble(scanner.nextLine());
                        account.deposit(depositAmount);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount. Please enter a numeric value.");
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = Double.parseDouble(scanner.nextLine());
                        account.withdraw(withdrawAmount);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount. Please enter a numeric value.");
                    }
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 4.");
            }
        }
    }

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nWelcome to the Bank Management System");
            System.out.println("1. Create New Account");
            System.out.println("2. Login to Existing Account");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid option. Please enter a number between 1 and 3.");
                continue;
            }

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Exiting the system...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 3.");
            }
        }

        scanner.close();
    }
}
