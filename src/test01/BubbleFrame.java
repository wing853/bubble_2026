package test01;

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
                // 방향키 코드를 Player의 이동 메서드 연결
                switch (e.getKeyCode()){
                    case KeyEvent.VK_LEFT:
                        player.left();
                        break;
                    case KeyEvent.VK_RIGHT:
                        player.right();
                        break;
                    case KeyEvent.VK_KP_UP:
                        player.up();
                        break;
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        new BubbleFrame();
    }

} // end of class
