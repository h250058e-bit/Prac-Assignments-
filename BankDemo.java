import java.util.List;

public class BankDemo {

    public static void main(String[] args) {
        List<Account> accounts = List.of(
                new SavingsAccount("S204", 900.0, 250.0, 0.08),
                new CurrentAccount("C318", 400.0, 300.0, 25.0));

        double[] requests = {700.0, 500.0};

        for (int round = 0; round < requests.length; round++) {
            double amount = requests[round];

            if (round > 0) {
                System.out.println();
            }
            System.out.println("=== Round " + (round + 1) + ": withdraw " + (int) amount + " ===");

            for (Account account : accounts) {
                String label = account.getAccountNumber();
                if (round == 0) {
                    label += " (" + account.getClass().getSimpleName() + ")";
                }

                System.out.println("-- " + label + " start balance: " + account.getBalance());
                account.withdraw(amount);
                System.out.println("Balance after withdraw: " + account.getBalance());
                account.endOfMonth();
                System.out.println("Balance after end of month: " + account.getBalance());
            }
        }
    }
}
