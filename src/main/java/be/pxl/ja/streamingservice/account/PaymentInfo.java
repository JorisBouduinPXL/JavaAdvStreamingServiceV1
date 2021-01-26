package be.pxl.ja.streamingservice.account;

import be.pxl.ja.streamingservice.exception.InvalidDateException;

import java.time.LocalDate;

public class PaymentInfo {
    private String firstName;
    private String lastName;
    private CreditCardNumber cardNumber;
    private LocalDate expirationDate;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        if (expirationDate.isAfter(LocalDate.now().minusMonths(1))) {
            throw new InvalidDateException(expirationDate);
        }
        this.expirationDate = expirationDate;
    }

    public void setCardNumber(CreditCardNumber cardNumber) {
        this.cardNumber = cardNumber;
    }
}
