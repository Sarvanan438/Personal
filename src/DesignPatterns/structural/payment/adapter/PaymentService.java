package DesignPatterns.structural.payment.adapter;

public interface PaymentService {
    public PaymentProvider selectPaymentServiceProvider(String paymentProvider);
}
