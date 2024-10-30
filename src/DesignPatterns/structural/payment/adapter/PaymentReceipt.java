package DesignPatterns.structural.payment.adapter;

public class PaymentReceipt extends PaymentInformation{


    public PaymentReceipt(String paymentId, String amount, String payedBy, String payedTo, String date) {
        super(paymentId, amount, payedBy, payedTo, date);
    }
}

