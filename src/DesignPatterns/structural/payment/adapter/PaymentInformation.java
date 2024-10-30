package DesignPatterns.structural.payment.adapter;

public class PaymentInformation{
    private String paymentId,amount,payedBy, payedTo,date;

    public PaymentInformation(String paymentId, String amount, String payedBy, String payedTo, String date) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.payedBy = payedBy;
        this.payedTo = payedTo;
        this.date = date;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getAmount() {
        return amount;
    }

    public String getPayedBy() {
        return payedBy;
    }

    public String getPayedTo() {
        return payedTo;
    }

    public String getDate() {
        return date;
    }
}
