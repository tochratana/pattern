package structural.adapterPattern;

public class PaymentAdapter implements PaymentProcessor{

    private PayPalPayment adaptee;

    public PaymentAdapter (PayPalPayment payPalPayment){
        this.adaptee = payPalPayment;
    }


    @Override
    public void pay(int cents) {

        double dollar = cents * 0.01;
        adaptee.pay(dollar);
    }
}
