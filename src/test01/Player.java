package test01;

import javax.swing.*;

public class Player extends JLabel implements Moveable {

    // 플레이어의 현재 좌표 상태값
    private int x;
    private int y;

    // 좌우 방향 이미지
    private ImageIcon playerR;
    private ImageIcon playerL;

    public Player() {
        initData();
        setInitLayout();
    }

    private void initData() {
        playerR = new ImageIcon("img/playerR.png");
        playerL = new ImageIcon("img/playerL.png");
    }

    private void setInitLayout() {
        // 캐릭터 초기 위치 설정
        x = 55;
        y = 535;
        setSize(50, 50);
        super.setIcon(playerR); // 초기 방향 설정
        setLocation(x, y);
    }

    @Override
    public void left() {
        setIcon(playerL);
        System.out.println("player left() 호출");
    }

    @Override
    public void right() {
        setIcon(playerR);
        System.out.println("player right() 호출");
    }

    @Override
    public void up() {
        System.out.println("player up() 호출");
    }

    @Override
    public void down() {
        System.out.println("player down() 호출");
    }
}
