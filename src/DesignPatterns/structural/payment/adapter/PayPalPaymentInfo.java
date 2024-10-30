package DesignPatterns.structural.payment.adapter;

import java.util.UUID;

public class PayPalPaymentInfo {
    private String paymentToken,payedTo,amount,paypalMerchantId;

    public PayPalPaymentInfo(String payedTo, String amount) {
        this.paymentToken = UUID.randomUUID().toString();
        this.payedTo = payedTo;
        this.amount = amount;
    }
}
