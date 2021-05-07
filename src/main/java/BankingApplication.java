
public class BankingApplication {
    public static void main(String[] args) {

        BankAccount checking =
            BankAccount.addAccount("John Doe", "54367");

        Checking ck = Checking.addAccount("Jane Doe", "24601");
        ck.showMenu();
    }
}

