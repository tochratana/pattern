package structural.adapterPattern.practice;

public class App {
    static void main(String[] args) {

        Account account = new Account();
        account.setBalance(2000);
        account.setAccName("Name");
        account.setAccNumber("123-456-789");
        account.setId(1);


        DollarPaymentService dollarPaymentService = new BankingService(account);
        dollarPaymentService.payAsDollar(10.00);

        // In case Paid as Riel :
        RielCurrencyPayment rielCurrencyPayment = new RielPaymentConfig(account);
        DollarPaymentService paymentService = new AdapterPayment(rielCurrencyPayment);
        paymentService.payAsDollar(10.00);

        System.out.println(account.getBalance());

    }
}
