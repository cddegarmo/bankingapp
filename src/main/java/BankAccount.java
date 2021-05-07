package main.java;

import java.util.*;

public class BankAccount {
    private static final Map<Integer, BankAccount> accounts = new HashMap<>();

    private int balance = 0;
    private int previousTransaction = 0;
    private final String customerName;
    private final int accountNumber;

    private BankAccount(String cname, int accNo) {
        customerName = cname;
        accountNumber = accNo;
    }

    public static BankAccount addAccount(String cname, int accNO) {
        BankAccount account = new BankAccount(cname, accNO);
        accounts.putIfAbsent(accNO, account);
        return account;
    }

    public int getBalance()         { return balance;             }
    public String getCustomerName() { return customerName;        }
    public int getAccountNumber()   { return accountNumber;       }
    public int getPrevious()        { return previousTransaction; }

    public static void getBalances() {
        for (BankAccount account : accounts.values())
            System.out.println(account.getAccountNumber() + ": " + account.getBalance());
    }

    public void deposit(int amount) {
        if(amount > 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    public void withdraw(int amount) {
        if(amount > balance) {
            System.out.println("Overdraft warning. Current balance: " + balance);
            previousTransaction = 0;
        } else {
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    public void transfer(int amount, int accountNumber) {
        BankAccount target = retrieve(accountNumber);
        if (amount <= balance)
            target.deposit(amount);
        withdraw(amount);
    }

    private BankAccount retrieve(int accountNumber) {
        BankAccount account = accounts.get(accountNumber);
        return account;
    }

    public void getPreviousTransaction() {
        if(previousTransaction > 0)
            System.out.println("Deposited: " + previousTransaction);
        else if(previousTransaction < 0)
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        else
            System.out.println("No transaction occurred");
    }

    public void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Welcome " + customerName);
            System.out.println("Your account number is " + accountNumber);
            System.out.println();
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Transfer");
            System.out.println("E. Exit");
            System.out.println("=============================");
            System.out.println("Enter an option" );
            System.out.println("=============================");
            option = scanner.next().charAt(0);

            switch(option) {
                case 'A':
                    System.out.println("-----------------------");
                    System.out.println("Balances");
                    getBalances();
                    System.out.println("-----------------------");
                    break;

                case 'B':
                    System.out.println("-----------------------");
                    System.out.println("Enter an amount to deposit:");
                    System.out.println("-----------------------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    break;

                case 'C':
                    System.out.println("-----------------------");
                    System.out.println("Enter an amount to withdraw:");
                    System.out.println("-----------------------");
                    int withdrawn = scanner.nextInt();
                    withdraw(withdrawn);
                    break;

                case 'D':
                    getBalances();
                    System.out.println("-----------------------");
                    System.out.println("Enter an amount to transfer:");
                    System.out.println("-----------------------");
                    int transfer = scanner.nextInt();
                    System.out.println("-----------------------");
                    System.out.println("Enter an account number:");
                    System.out.println("-----------------------");
                    int target = scanner.nextInt();
                    transfer(transfer, target);
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
