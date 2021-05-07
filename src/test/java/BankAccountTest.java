package test.java;

import main.java.BankAccount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
   @Test
   public void testCreate() {
      BankAccount ba = BankAccount.addAccount("John Doe", 12345);
      assertAll(
           () -> assertEquals(0, ba.getBalance()),
           () -> assertEquals(0, ba.getPrevious()),
           () -> assertEquals(12345, ba.getAccountNumber()),
           () -> assertTrue("John Doe".equals(ba.getCustomerName())));
   }

   @Test
   public void testDeposits() {
      BankAccount ba = BankAccount.addAccount("John Doe", 12345);
      assertEquals(0, ba.getBalance());
      ba.deposit(0);
      assertEquals(0, ba.getBalance());
      ba.deposit(4000);
      assertEquals(4000, ba.getBalance());
      ba.deposit(3478);
      assertEquals(7478, ba.getBalance());
      assertEquals(3478, ba.getPrevious());
   }

   @Test
   public void testWithdrawals() {
      BankAccount ba = BankAccount.addAccount("John Doe", 12345);
      ba.deposit(20000);
      ba.withdraw(20001);
      assertEquals(20000, ba.getBalance());
      assertEquals(0, ba.getPrevious());
      ba.withdraw(12037);
      assertEquals(7963, ba.getBalance());
   }
}
