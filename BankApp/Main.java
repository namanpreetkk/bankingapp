import java.util.ArrayList;
import java.util.Scanner;

// Account class
class Account {
    private String ownername;
    private double balance;  // fixed: should be lowercase 'balance'
    private ArrayList<String> transactions;

    // Constructor
    public Account(String ownername) {
        this.ownername = ownername;
        this.balance = 0.0;
        this.transactions = new ArrayList<>(); // fixed: proper way to create ArrayList
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited Rs: " + amount);
            System.out.println("Deposited Rs: " + amount);
        } else {
            System.out.println("Please enter a valid amount");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount; // fixed: not 'withdraw -= amount'
            transactions.add("Withdrawn Rs: " + amount);
            System.out.println("Withdrawn Rs: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount");
        }
    }

    // Show balance method
    public void showBalance() {
        System.out.println("Current Balance Rs: " + balance);
    }

    // Show transaction history
    public void showTransactions() {
        System.out.println("Transaction History:");
        for (String t : transactions) {  // fixed: variable name 'transactions' not 'transaction'
            System.out.println("- " + t);
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // fixed: correct way to read from System.in
        Account account = new Account("Naman");

        int choice;
        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Show Transactions");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmt = scanner.nextDouble();
                    account.deposit(depositAmt);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmt = scanner.nextDouble(); // fixed: variable name
                    account.withdraw(withdrawAmt);             // fixed: call correct method
                    break;

                case 3:
                    account.showBalance(); // fixed: method name and case
                    break;

                case 4:
                    account.showTransactions(); // fixed: method name and case
                    break;

                case 0:
                    System.out.println("Thank you for banking!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
