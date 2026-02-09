package pattern.adapterPattern.practice;

public class RielPaymentConfig implements RielCurrencyPayment{
    private Account account;

    public RielPaymentConfig(Account account){
        this.account = account;
    }
    @Override
    public boolean payAsRiel(double cash) {

        double dollar = cash / 4000;
        double total = account.getBalance() - dollar;
        System.out.println("Riel : " + cash);

        return false;
    }
}
