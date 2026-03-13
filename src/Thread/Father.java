package Thread;

public class Father extends Thread {
    BankAccount bankAccount;

    public Father(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        // 입금 처리
        bankAccount.saveMoney(10000);
    }
}
