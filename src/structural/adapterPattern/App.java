package structural.adapterPattern;

public class App {

    static void main(String[] args) {
        int cents = 1000;
        PaymentProcessor paymentProcessor = new CreditPayment();
        paymentProcessor.pay(cents);

        PayPalPayment payPalPayment = new PayPalPayment();
        PaymentProcessor paymentAdapter = new PaymentAdapter(payPalPayment);
        paymentAdapter.pay(cents);
    }
}
