package DesignPatterns.structural.payment.adapter;

/**
 * using interface because class extension is one time while interfaces can be implemented in many,
 * having a abstract class does help with extracting the common logics
 * But abstract class has a limitation that it has to extend the class for polymorphism to work
 * so any class that is already extending another class cannot be part of this object programming hence interface is a good choice
 *
 */
public interface PaymentProvider {

    public PaymentReceipt processPayment(PaymentDetails paymentDetails);
    public RefundReceipt issueRefund(RefundDetails refundDetails);
    public PaymentStatus getPaymentStatus(String paymentId);
}
