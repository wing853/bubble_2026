package _my.test03;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundPlayerService2 implements Runnable{

    private BufferedImage image;
    private Player2 player2;

    public BackgroundPlayerService2(Player2 player2) {
            this.player2 = player2;
        try {
            image = ImageIO.read(new File("img/backgroundMapService.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while(true) {
            Color leftColor = new Color(image.getRGB(player2.getX(),player2.getY() + 25));
            Color rightColor = new Color(image.getRGB(player2.getX() + 50,player2.getY()+25));

            if(isRed(leftColor)){
                player2.setLeftWallCrash(true);
                player2.setLeft(false);
            } else {
                player2.setLeftWallCrash(false);
            }

            if(isRed(rightColor)){
                player2.setRightWallCrash(true);
                player2.setRight(false);
            } else {
                player2.setRightWallCrash(false);
            }

        }
    }

    private boolean isRed(Color color) {
        return color.getRed() == 255 && color.getBlue() == 0 && color.getGreen() == 0;
    }
}
