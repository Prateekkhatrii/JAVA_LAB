import java.util.Scanner;

// Base class
class Account {
    String name;
    int accNo;
    String accType;
    double balance;

    Scanner sc = new Scanner(System.in);

    void acceptDetails() {
        System.out.print("Enter customer name: ");
        name = sc.nextLine();
        System.out.print("Enter account number: ");
        accNo = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter account type: ");
        accType = sc.nextLine();
        System.out.print("Enter initial balance: ");
        balance = sc.nextDouble();
    }

    void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amt = sc.nextDouble();
        balance += amt;
        System.out.println("Amount deposited successfully.");
    }

    void displayBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}

// Savings Account
class SavAcct extends Account {
    double rate = 0.05; // 5% interest

    void computeInterest() {
        double interest = balance * rate;
        balance += interest;
        System.out.println("Interest added: ₹" + interest);
    }

    void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amt = sc.nextDouble();

        if (amt <= balance) {
            balance -= amt;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

// Current Account
class CurAcct extends Account {
    double minBalance = 1000;
    double penalty = 100;

    void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amt = sc.nextDouble();

        if (amt <= balance) {
            balance -= amt;

            if (balance < minBalance) {
                balance -= penalty;
                System.out.println("Minimum balance not maintained.");
                System.out.println("Penalty of ₹" + penalty + " imposed.");
            }

            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

// Main class
public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Choose account type: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            SavAcct sa = new SavAcct();
            sa.acceptDetails();

            sa.deposit();
            sa.computeInterest();
            sa.withdraw();
            sa.displayBalance();

        } else if (choice == 2) {
            CurAcct ca = new CurAcct();
            ca.acceptDetails();

            ca.deposit();
            ca.withdraw();
            ca.displayBalance();

        } else {
            System.out.println("Invalid choice");
        }
    }
}
