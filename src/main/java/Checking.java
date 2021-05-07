package main.java;

public class Checking {
    private BankAccount ac;

    private Checking(String cname, int cid) {
        ac = BankAccount.addAccount(cname, cid);
    }

    public static Checking addAccount(String cname, int cid) {
        return new Checking(cname, cid);
    }

    public int getBalance()              { return ac.getBalance();       }
    public String getCustomerName()      { return ac.getCustomerName();  }
    public int getAccountNumber()        { return ac.getAccountNumber(); }
    public void deposit(int amount)      { ac.deposit(amount);          }
    public void withdraw(int amount)     { ac.withdraw(amount);         }
    public void getPreviousTransaction() { ac.getPreviousTransaction(); }
    public void showMenu()               { ac.showMenu();               }
}
