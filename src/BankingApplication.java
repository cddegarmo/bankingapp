import java.util.Scanner;

public class BankingApplication {
    public static void main( String[] args ) {

        BankAccount dillonChecking =
            BankAccount.addAccount( "Dillon DeGarmo", "24601" );

        dillonChecking.showMenu();
    }
}

