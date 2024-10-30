package DesignPatterns.structural.payment.adapter;

public class PaymentSystemSimulator {
    public static void main(String[]args){
        PaymentProvider provider = new PaymentProviderSelector()
                                    .selectPaymentServiceProvider("PAYPAL");

        provider.getPaymentStatus("1231231");
    }
}
