package structural.adapterPattern.practice;

public class AdapterPayment implements DollarPaymentService{

    private RielCurrencyPayment rielCurrencyPayment;

    public AdapterPayment(RielCurrencyPayment rielCurrencyPayment){
        this.rielCurrencyPayment = rielCurrencyPayment;
    }

    @Override
    public boolean payAsDollar(double cash) {

        double riel = cash * 4000;
        rielCurrencyPayment.payAsRiel(riel);
        System.out.println("Paid : " + riel);
        return false;
    }
}
