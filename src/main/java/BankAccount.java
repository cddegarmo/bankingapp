import java.util.Scanner;

public class BankAccount {
    private int balance = 0;
    private int previousTransaction = 0;
    private final String customerName;
    private final String customerId;

    private BankAccount(String cname, String cid) {
        customerName = cname;
        customerId = cid;
    }

    public static BankAccount addAccount(String cname, String cid) {
        return new BankAccount(cname, cid);
    }

    public int getBalance()         { return balance;      }
    public String getCustomerName() { return customerName; }
    public String getCustomerId()   { return customerId;   }

    public void deposit(int amount) {
        if(amount > 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    public void withdraw(int amount) {
        if(amount > balance)
            System.out.println("Overdraft warning. Current balance: " + balance);
        else {
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    public void getPreviousTransaction() {
        if(previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if(previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    public void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Welcome " + customerName);
            System.out.println("Your ID is " + customerId);
            System.out.println("\n");
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous transaction");
            System.out.println("E. Exit");
            System.out.println("=============================");
            System.out.println("Enter an option" );
            System.out.println("=============================");
            option = scanner.next().charAt(0);

            switch(option) {
                case 'A':
                    System.out.println("-----------------------");
                    System.out.println("Balance: " + balance);
                    System.out.println("-----------------------");
                    System.out.println();
                    break;

                case 'B':
                    System.out.println("-----------------------");
                    System.out.println("Enter an amount to deposit:");
                    System.out.println("-----------------------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;

                case 'C':
                    System.out.println("-----------------------");
                    System.out.println("Enter an amount to withdraw:");
                    System.out.println("-----------------------");
                    int withdrawn = scanner.nextInt();
                    withdraw(withdrawn);
                    System.out.println();
                    break;

                case 'D':
                    System.out.println("-----------------------");
                    getPreviousTransaction();
                    System.out.println("-----------------------");
                    System.out.println();
                    break;

                case 'E':
                    System.out.println("***************************");
                    break;

                default:
                    System.out.println("Invalid entry. Please try again.");
                    break;
            }

        } while(option != 'E');

        System.out.println("Thank you for banking with us. Please come again.");
    }
}
