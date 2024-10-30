package DesignPatterns.structural.payment.adapter;

import java.util.UUID;

public class PayPalPaymentProviderService {
    public String makePayment(PayPalPaymentInfo paymentInfo){
        // make payment
        return UUID.randomUUID().toString();
    }
    public String checkTransactionStatus(String transactionID){
        return "SUCCESS";
    }
    public String refundByTransactionId(String transactionID){
        // do refund
        return UUID.randomUUID().toString();
    }
}
