public abstract class Account {

    private final String accountNumber;
    private double balance;

    public Account(String accountNumber, double openingBalance) {
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }

    public final void deposit(double amount) {
        if (amount > 0) {
            credit(amount);
        } else {
            System.out.println("Deposit must be positive.");
        }
    }

    public final void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal must be positive.");
        } else if (!permits(amount)) {
            System.out.println(rejectionMessage());
        } else {
            debit(amount);
            afterWithdraw();
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void credit(double amount) {
        balance += amount;
    }

    protected void debit(double amount) {
        balance -= amount;
    }

    protected void afterWithdraw() {
    }

    protected abstract boolean permits(double amount);

    protected abstract String rejectionMessage();

    public abstract void endOfMonth();
}
