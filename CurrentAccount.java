public class CurrentAccount extends Account {

    private final double overdraftLimit;
    private final double monthlyFee;

    public CurrentAccount(String accountNumber, double openingBalance,
                          double overdraftLimit, double monthlyFee) {
        super(accountNumber, openingBalance);
        this.overdraftLimit = overdraftLimit;
        this.monthlyFee = monthlyFee;
    }

    @Override
    protected boolean permits(double amount) {
        return getBalance() - amount >= -overdraftLimit;
    }

    @Override
    protected String rejectionMessage() {
        return "Withdrawal rejected: overdraft limit of " + overdraftLimit + " exceeded.";
    }

    @Override
    protected void afterWithdraw() {
        if (getBalance() < 0) {
            System.out.println("Account is in overdraft (within limit).");
        }
    }

    @Override
    public void endOfMonth() {
        debit(monthlyFee);
        System.out.println("Maintenance fee deducted: " + monthlyFee);
    }
}
