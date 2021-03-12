
public class BankingApplication {
    public static void main(String[] args) {

        BankAccount dillonChecking =
            BankAccount.addAccount("Dillon DeGarmo","24601");

        Checking ck = Checking.addAccount("Dillon DeGarmo", "24601");
        ck.showMenu();
    }
}

