package test06;

public interface Moveable {

    void left();
    void right();
    void up();

    // Adapter 클래스가 너무 많이 생겨서 default 문법을
    // 인터페이스에서 사용 할 수 있도록 제공
    // 즉, default 키워드를 쓰면 인터페이스 안에서 일반 메서드를 선언 가능
    default void down() {};

}
