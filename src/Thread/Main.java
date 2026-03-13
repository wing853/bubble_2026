package Thread;

public class Main {

    // 메인 쓰레드
    public static void main(String[] args) {
        // 최초 10만원 가지고 있음
        BankAccount bankAccount = new BankAccount();

        Father father = new Father(bankAccount);
        Mother mother = new Mother(bankAccount);

        // 아버지가 먼저 입금을 한다(1만원)
        father.start();
        // 어머니가 장을 보기위해 출금한다(5천원)
        mother.start();

    } // end of main

}
