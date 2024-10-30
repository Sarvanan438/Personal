package DesignPatterns.structural.payment.adapter;

public class RefundReceipt extends PaymentInformation {
    PaymentReceipt receipt;
    static PaymentReceipt NoReceipt = new PaymentReceipt(null,null,null,null,null);
    public RefundReceipt(String paymentId, String amount, String payedBy, String payedTo, String date, PaymentReceipt receipt) {
        super(paymentId, amount, payedBy, payedTo, date);
        this.receipt = receipt;
    }

    public PaymentReceipt getReceipt() {
        if(receipt == null) return NoReceipt;
        return receipt;
    }
}
