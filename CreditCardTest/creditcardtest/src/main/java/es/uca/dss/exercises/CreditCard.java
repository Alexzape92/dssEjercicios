package es.uca.dss.exercises;


/**
 * Credit card class
 */
public class CreditCard {
    private String cardNumber;
    private String cardholderName;
    private String expirationDate;
    private int cvv;
    private float associatedAccountBalance = 1000f;

    public CreditCard(String cardNumber, String cardholderName, String expirationDate, int cvv) {
        this.cardNumber = cardNumber;
        this.cardholderName = cardholderName;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public int getCvv() {
        return cvv;
    }

    public float getAssociatedAccountBalance() {
        return associatedAccountBalance;
    }

    public void makePayment(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        else if(amount > associatedAccountBalance) {
            throw new IllegalArgumentException("Amount must be less than or equal to the balance");
        }
        else {
            associatedAccountBalance -= amount;
        }
    }
}
