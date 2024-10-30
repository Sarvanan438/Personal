package DesignPatterns.structural.payment.adapter;

import java.util.Date;

public class PayPalPaymentAdapter implements PaymentProvider{
    PayPalPaymentProviderService service ;
    PayPalPaymentAdapter(){
        service = PayPalPaymentProviderCreator.createProvider();
    }
    @Override
    public PaymentReceipt processPayment(PaymentDetails paymentDetails) {
        PayPalPaymentInfo payPalPaymentInfo = this.createPayPalPaymentInfo(paymentDetails);
        String transcationID = this.service.makePayment(payPalPaymentInfo);
        return this.createPaymentReceipt(transcationID,paymentDetails);
    }

    @Override
    public RefundReceipt issueRefund(RefundDetails refundDetails) {
        String transactionID = "";
        if(refundDetails.getPaymentReceipt().getPaymentId()==null){
            PaymentReceipt receipt=this.processPayment(new PaymentDetails(refundDetails.getAmount(), refundDetails.getPayedBy(), refundDetails.getPayedTo()));
            return new RefundReceipt(receipt.getPaymentId(), receipt.getAmount(), receipt.getPayedBy(),receipt.getPayedTo(),receipt.getDate(),refundDetails.getPaymentReceipt());

        }
        transactionID= this.service.refundByTransactionId(refundDetails.getPaymentId());
        return new RefundReceipt(transactionID, refundDetails.getAmount(), refundDetails.getPayedBy(), refundDetails.getPayedTo(), new Date().toString(),refundDetails.getPaymentReceipt());
    }

    @Override
    public PaymentStatus getPaymentStatus(String paymentId) {
        String status = this.service.checkTransactionStatus(paymentId);
        return new PaymentStatus(paymentId,status);
    }

    public PayPalPaymentInfo createPayPalPaymentInfo(PaymentDetails paymentDetails){
        return new PayPalPaymentInfo(paymentDetails.getPayedTo(),paymentDetails.getAmount());
    }

    public PaymentReceipt createPaymentReceipt(String transactionId,PaymentDetails paymentDetails){
        return new PaymentReceipt(transactionId,paymentDetails.getAmount(),paymentDetails.getPayedBy(),paymentDetails.getPayedTo(),new Date().toString());
    }
}
