package Thread;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class BankAccount {

    private int money = 100_000;

    // 기능: 입금, 출금

    // 입금 기능
    public void saveMoney(int money) {
        // 블럭을 사용해서 동기화 처리
        synchronized (this) {
            // 현재 금액을 지역 변수에 저장
            int current_money = getMoney();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            setMoney(current_money + money);
            System.out.println("입금 후 현재 계좌 잔액: " + getMoney());
        }

    }

    // 출금 기능
    public synchronized int withdraw(int money) {
        int current_money = getMoney();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        setMoney(current_money - money);
        System.out.println("출금 후 현재 계좌 잔액: " + getMoney());;

        return money;
    }
}
