package es.uca.dss.exercises;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Unit test for CreditCard.
 */
public class CreditCardTest 
{
    @Test
    public void constructorTest(){
        //Configuration
        String cardNumber = "1234567890123456";
        String cardholderName = "John Doe";
        String expirationDate = "01/01/2020";
        int cvv = 123;

        //Processing
        CreditCard creditCard = new CreditCard(cardNumber, cardholderName, expirationDate, cvv);

        //Verifying
        assertEquals(cardNumber, creditCard.getCardNumber());
        assertEquals(cardholderName, creditCard.getCardholderName());
        assertEquals(expirationDate, creditCard.getExpirationDate());
        assertEquals(cvv, creditCard.getCvv());
    }

    @Test
    public void makeCorrectPaymentTest(){
        //Configuration
        String cardNumber = "1234567890123456";
        String cardholderName = "John Doe";
        String expirationDate = "01/01/2020";
        int cvv = 123;
        CreditCard creditCard = new CreditCard(cardNumber, cardholderName, expirationDate, cvv);
        float associatedAccountBalance = creditCard.getAssociatedAccountBalance();
        float amount = 100f;

        //Processing
        creditCard.makePayment(amount);

        //Verifying
        assertEquals(associatedAccountBalance - amount, creditCard.getAssociatedAccountBalance(), 0.001);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void makeIncorrectPaymentTest(){
        //Configuration
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Amount must be positive");
        String cardNumber = "1234567890123456";
        String cardholderName = "John Doe";
        String expirationDate = "01/01/2020";
        int cvv = 123;
        CreditCard creditCard = new CreditCard(cardNumber, cardholderName, expirationDate, cvv);
        float amount = -100f;

        //Processing
        creditCard.makePayment(amount);
    }

    @Test
    public void makeTooBigPaymentTest(){
        //Configuration
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Amount must be less than or equal to the balance");
        String cardNumber = "1234567890123456";
        String cardholderName = "John Doe";
        String expirationDate = "01/01/2020";
        int cvv = 123;
        CreditCard creditCard = new CreditCard(cardNumber, cardholderName, expirationDate, cvv);
        float amount = 1000.1f;

        //Processing
        creditCard.makePayment(amount);
    }
}
