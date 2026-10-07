public class SavingsAccount extends Account {

    private final double minimumBalance;
    private final double interestRate;

    public SavingsAccount(String accountNumber, double openingBalance,
                          double minimumBalance, double interestRate) {
        super(accountNumber, openingBalance);
        this.minimumBalance = minimumBalance;
        this.interestRate = interestRate;
    }

    @Override
    protected boolean permits(double amount) {
        return getBalance() - amount >= minimumBalance;
    }

    @Override
    protected String rejectionMessage() {
        return "Withdrawal rejected: minimum balance of " + minimumBalance + " required.";
    }

    @Override
    public void endOfMonth() {
        double interest = getBalance() * interestRate;
        credit(interest);
        System.out.println("Interest applied: " + interest);
    }
}
