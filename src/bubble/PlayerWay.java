package bubble;

/**
 * [enum] - 플레이어의 방향상태
 * <p>
 * enum을 사용하는 이유
 * - boolean 두 개(isLeft, isRight)
 * - 둘 다 true가 되는 잘못된 상태가 발생 할 수 있음
 * - enum은 정해진 값 중 하나만 가질 수 있어서 안전함
 * <p>
 * 사용법
 * - playerWay = PlayerWay.Left
 * - if(playerWay =PlayerWay.Left) {} // 값 비교
 * <p>
 * 왜 사용할까?
 *  * 나의 프로젝트가 논리 안에서 데이터의 범위를 지정하고 싶을때 사용
 */

public enum PlayerWay {
    LEFT, RIGHT;
}
