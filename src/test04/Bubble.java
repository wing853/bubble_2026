package test04;

import javax.swing.*;

public class Bubble extends JLabel {

    private int x;
    private int y;

    private ImageIcon bubbleIcon;

    private Player player;

    // getter
    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    // setter
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public Bubble(Player player) {
        this.player = player;
        initData();
        setInitLayout();
    }

    private void initData() {
        bubbleIcon = new ImageIcon("img/bubble.png");
    }

    private void setInitLayout() {
        x = player.getX();
        y = player.getY();
        setSize(50,50);
        setLocation(x,y);
        setVisible(true);
    }

}
