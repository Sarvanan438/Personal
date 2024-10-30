    package DesignPatterns.structural.payment.adapter;

    public class RefundDetails extends PaymentDetails{
        private PaymentReceipt paymentReceipt;
        public RefundDetails(String amount, String payedBy, String payedTo,PaymentReceipt paymentReceipt) {
            super(amount, payedBy, payedTo);
            this.paymentReceipt = paymentReceipt;
        }

        public PaymentReceipt getPaymentReceipt() {
            return paymentReceipt;
        }
    }
