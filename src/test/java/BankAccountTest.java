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

   @Test
   public void testDuplication() {
      BankAccount ba = BankAccount.addAccount("John Doe", 12345);
      assertThrows(IllegalArgumentException.class,
                   () -> BankAccount.addAccount("John Doe", 12345));
   }

   @Test
   public void testTransfers() {
      BankAccount ba1 = BankAccount.addAccount("John Doe", 12345);
      BankAccount ba2 = BankAccount.addAccount("John Doe", 12346);
      assertAll(
           () -> assertEquals(0, ba1.getBalance()),
           () -> assertEquals(0, ba2.getBalance()));
      ba1.deposit(10000);
      ba1.transfer(5000, 12346);
      assertEquals(5000, ba2.getBalance());
      assertEquals(5000, ba2.getPrevious());
      assertEquals(-5000, ba1.getPrevious());
      assertEquals(5000, ba1.getBalance());
   }
}
