package test04;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BubbleFrame extends JFrame {

    private JLabel backgroundMap;
    private Player player;

    public BubbleFrame() {
        initData();
        setInitLayout();
        addEventListener();
        // 충돌 감지 백그라운드 서비스 시작
        new Thread(new BackgroundPlayerService(player)).start();
    }

    private void initData() {
        setTitle("버블버블 게임");
        setSize(1000,640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backgroundMap = new JLabel(new ImageIcon("img/backgroundMap.png"));
        setContentPane(backgroundMap);

        player = new Player();
    }

    private void setInitLayout() {
        setLayout(null);
        setResizable(false); // 창 크기 고정
        setLocationRelativeTo(null); // 화면 정중앙 배치(프레임)

        backgroundMap.add(player);
        setVisible(true);
    }

    private void addEventListener() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        player.setLeft(false);
                        break;
                    case KeyEvent.VK_RIGHT:
                        player.setRight(false);
                        break;
                }

            }

            @Override
            public void keyPressed(KeyEvent e) {
                // 방향키 코드를 Player의 이동 메서드 연결
                switch (e.getKeyCode()){
                    case KeyEvent.VK_LEFT:
                        // 이동 중이 아니고 벽에 충돌하지 않은 상태일 때 left 메서드 호출
                        if(player.isLeft() == false && player.isLeftWallCrash() == false) {
                            player.left();
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        // 이동 중이 아니고 벽에 충돌하지 않은 상태일 때 right 메서드 호출
                        if(player.isRight() == false && player.isRightWallCrash() == false){
                            player.right();
                        }
                        break;
                    case KeyEvent.VK_UP:
                        player.up();
                        break;
                    case KeyEvent.VK_SPACE:
                        fireBubble();
                        break;
                }
            }
        });
    }

    // todo 임시 버블 클래스 생성
    private void fireBubble() {
        Bubble bubble = new Bubble(player);
        backgroundMap.add(bubble);
        // 동적으로 컴포턴트가 그려기지 때문에 버그 발생 가능
        backgroundMap.revalidate(); // 레이아웃 재 계산
        backgroundMap.repaint(); // 화면 다시 그리기
    }

    public static void main(String[] args) {
        new BubbleFrame();
    }

} // end of class
