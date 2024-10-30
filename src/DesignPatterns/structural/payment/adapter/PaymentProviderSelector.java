package DesignPatterns.structural.payment.adapter;

public class PaymentProviderSelector implements PaymentService{
    @Override
    public PaymentProvider selectPaymentServiceProvider(String paymentProvider) {
        switch (paymentProvider){
            case "PAYPAL":
                return new  PayPalPaymentAdapter();
        }
        throw new IllegalArgumentException("Illegal");
    }
}
