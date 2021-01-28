package be.pxl.ja.streamingservice.account;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PaymentInfoExpirationDateTest {

    @Test
    public void CreditCardExpirationDateIsAtLeastOneMonthAfterToday(){

        PaymentInfo paymentInfo = new PaymentInfo("Joris","Bouduin",15,3,2021);

        assertTrue(paymentInfo.getExpirationDate().isAfter(LocalDate.now().plusMonths(1)));
    }

}