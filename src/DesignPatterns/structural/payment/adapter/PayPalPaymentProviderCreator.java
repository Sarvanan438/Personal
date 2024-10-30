package DesignPatterns.structural.payment.adapter;

public class PayPalPaymentProviderCreator{
    private static PayPalPaymentProviderService instance = null;
    public static PayPalPaymentProviderService createProvider(){
        if(PayPalPaymentProviderCreator.instance ==null){
            PayPalPaymentProviderCreator.instance =  new PayPalPaymentProviderService();
        }
        return instance;
    }
}
