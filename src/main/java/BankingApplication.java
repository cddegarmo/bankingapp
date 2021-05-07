package main.java;

public class BankingApplication {
    public static void main(String[] args) {
        BankAccount savings = BankAccount.addAccount("Peter Gibbons", 23452);
        BankAccount checking = BankAccount.addAccount("Peter Gibbons", 23453);
        checking.showMenu();
    }
}

