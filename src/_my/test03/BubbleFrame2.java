package _my.test03;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BubbleFrame2 extends JFrame {

    private JLabel backgroundMap;
    private Player2 player2;


    public BubbleFrame2() {
        initData();
        setInitLayout();
        addEventListener();

        new Thread(new BackgroundPlayerService2(player2)).start();
    }

    private void initData() {
        setTitle("버블버블 게임");
        setSize(1000,640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backgroundMap = new JLabel(new ImageIcon("img/backgroundMap.png"));
        player2 = new Player2();
        setContentPane(backgroundMap);
    }

    private void setInitLayout() {
        backgroundMap.add(player2);
        setResizable(false);
        setVisible(true);
    }

    private void addEventListener() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_LEFT:
                        if(player2.isLeft() == false && player2.isLeftWallCrash() == false){
                            player2.left();
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if(player2.isRight() == false && player2.isRightWallCrash() == false){
                            player2.right();
                        }
                        break;
                    case KeyEvent.VK_UP:
                        player2.up();
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT :
                        player2.setLeft(false);
                        break;
                    case KeyEvent.VK_RIGHT:
                        player2.setRight(false);
                        break;

                }
            }
        });
    }

    public static void main(String[] args) {
        new BubbleFrame2();
    }
}
