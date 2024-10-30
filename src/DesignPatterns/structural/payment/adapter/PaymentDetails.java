package DesignPatterns.structural.payment.adapter;

import java.util.Date;
import java.util.UUID;

public class PaymentDetails extends PaymentInformation{

    public PaymentDetails( String amount, String payedBy, String payedTo) {
        super(UUID.randomUUID().toString(), amount, payedBy, payedTo, new Date().toString());
    }
}
