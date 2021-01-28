package be.pxl.ja.streamingservice.account;

import be.pxl.ja.streamingservice.exception.InvalidDateException;

import java.time.LocalDate;

public class PaymentInfo {
    private String firstName;
    private String lastName;
    private CreditCardNumber cardNumber;
    private LocalDate expirationDate;

    public PaymentInfo(String firstName, String lastName, int day, int month, int year){
        this.firstName = firstName;
        this.lastName = lastName;
        LocalDate expDate = LocalDate.of(year,month,day);
        setExpirationDate(expDate);
    }

    public PaymentInfo() {

    }

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
        if (expirationDate.isBefore(LocalDate.now().plusMonths(1))) {
            throw new InvalidDateException(expirationDate);
        }
        this.expirationDate = expirationDate;
    }

    public void setCardNumber(CreditCardNumber cardNumber) {
        this.cardNumber = cardNumber;
    }
}
