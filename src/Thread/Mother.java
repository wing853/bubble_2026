package Thread;

public class Mother extends Thread {
    BankAccount bankAccount;

    public Mother(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        // 출금 처리
        bankAccount.withdraw(5000);
    }
}
