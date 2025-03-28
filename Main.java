import java.util.Scanner;

class BankAccount {
    private int balance;

    public BankAccount() {
        this.balance = 0;
    }

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }
    
    public int withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return balance;
        } else {
            System.out.println("账户余额不足");
            return balance;
        }
    }

    public void deposit(int amount) {
        balance += amount;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialBalance = scanner.nextInt();
        int withdrawAmount = scanner.nextInt();
        int depositAmount = scanner.nextInt();

        if (initialBalance < 0 || withdrawAmount < 0 || depositAmount < 0) {
            System.out.println("输入的数据不能为负数");
            scanner.close();
            return;
        }

        BankAccount account = new BankAccount(initialBalance);

        System.out.println("账户的初始余额是:" + account.getBalance());

        int balanceAfterWithdraw = account.withdraw(withdrawAmount);
        if (balanceAfterWithdraw == initialBalance) {
            System.out.println("账户的初始余额是:" + initialBalance);
            scanner.close();
            return;
        }
        System.out.println("取款后,账户的余额是:" + balanceAfterWithdraw);
        account.deposit(depositAmount);
        System.out.println("存款后,账户的余额是:" + account.getBalance());
        scanner.close();
    }
}