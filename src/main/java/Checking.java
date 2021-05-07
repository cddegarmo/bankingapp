public class Checking {
    private BankAccount ac;

    private Checking(String cname, String cid) {
        ac = BankAccount.addAccount(cname, cid);
    }

    public static Checking addAccount(String cname, String cid) {
        return new Checking(cname, cid);
    }

    public int getBalance()          { return ac.getBalance();          }
    public String getCustomerName()  { return ac.getCustomerName();     }
    public String getCustomerId()    { return ac.getCustomerId();       }

    public void deposit(int amount)      { ac.deposit(amount);          }
    public void withdraw(int amount)     { ac.withdraw(amount);         }
    public void getPreviousTransaction() { ac.getPreviousTransaction(); }
    public void showMenu()               { ac.showMenu();               }
}
