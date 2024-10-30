package DesignPatterns.structural.payment.adapter;

public class PaymentStatus {
   private String paymentId;
    private String status;

    public PaymentStatus(String paymentId, String status) {
        this.paymentId = paymentId;
        this.status = status;
    }

    public String getPaymentId() {
        return this.paymentId;
    }

    public String getStatus() {
        return status;
    }
}
