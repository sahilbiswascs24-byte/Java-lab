import java.util.Scanner;

// Base Account class
class Account {
    protected String customerName;
    protected String accountNumber;
    protected String accountType;
    protected double balance;

    Account(String name, String accNo, String accType, double bal) {
        this.customerName = name;
        this.accountNumber = accNo;
        this.accountType = accType;
        this.balance = bal;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Deposited: " + amount);
        displayBalance();
    }

    public void displayBalance() {
        System.out.printf("Current Balance: %.2f\n", balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            displayBalance();
        }
    }
}

// Savings Account
class SavAcct extends Account {
    private static final double INTEREST_RATE = 0.05; // 5% annual

    SavAcct(String name, String accNo, double bal) {
        super(name, accNo, "Savings", bal);
    }

    public void computeAndDepositInterest() {
        double interest = balance * (Math.pow((1 + INTEREST_RATE / 12), 12) - 1); // 1-year compound interest
        balance += interest;
        System.out.printf("Interest of %.2f has been added.\n", interest);
        displayBalance();
    }
}

// Current Account
class CurAcct extends Account {
    private static final double MIN_BALANCE = 5000.0;
    private static final double SERVICE_CHARGE = 1000.0;

    CurAcct(String name, String accNo, double bal) {
        super(name, accNo, "Current", bal);
    }

    // Check minimum balance and apply penalty if necessary
    public void checkMinimumBalance() {
        if (balance < MIN_BALANCE) {
            System.out.println("Balance below minimum! Service charge of " + SERVICE_CHARGE + " imposed.");
            balance -= SERVICE_CHARGE;
        } else {
            System.out.println("Balance meets minimum requirement. No penalty applied.");
        }
        displayBalance();
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            // Check minimum balance after withdrawal
            checkMinimumBalance();
        }
    }
}

// Main Bank System
public class BankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Welcome to the Bank System ===");

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();
        sc.nextLine(); // consume newline

        System.out.print("Enter Account Type (savings/current): ");
        String type = sc.nextLine().trim().toLowerCase();

        Account account = null;

        if ("savings".equals(type)) {
            account = new SavAcct(name, accNo, bal);
        } else if ("current".equals(type)) {
            account = new CurAcct(name, accNo, bal);
        } else {
            System.out.println("Invalid account type. Exiting.");
            sc.close();
            return;
        }

        System.out.printf("\nAccount created for %s (%s)\n", name, account.accountType);
        account.displayBalance();

        boolean exit = false;
        while (!exit) {
            System.out.println("\n---- MENU ----");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            if (account instanceof SavAcct) {
                System.out.println("4. Compute & Deposit Interest");
            } else {
                System.out.println("4. Check Minimum Balance & Apply Penalty");
            }
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double dAmt = sc.nextDouble();
                    sc.nextLine();
                    account.deposit(dAmt);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double wAmt = sc.nextDouble();
                    sc.nextLine();
                    account.withdraw(wAmt);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    if (account instanceof SavAcct) {
                        ((SavAcct) account).computeAndDepositInterest();
                    } else if (account instanceof CurAcct) {
                        ((CurAcct) account).checkMinimumBalance();
                    }
                    break;
                case 5:
                    exit = true;
                    System.out.println("Thank you for using the Bank System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}
