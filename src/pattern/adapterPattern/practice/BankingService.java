package pattern.adapterPattern.practice;

public class BankingService implements DollarPaymentService {
    private Account account;

    public BankingService(Account account){
        this.account = account;
    }
    @Override
    public boolean payAsDollar(double cash) {


        if(account==null){
            throw new RuntimeException("Not found account");
        }

        double total = account.getBalance();
        account.setBalance(total-cash);
        System.out.println("Successful " + cash);
        return true;
    }
}
