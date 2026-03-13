package bubble;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundBubbleService implements Runnable {
    private BufferedImage image;
    private Bubble bubble;
    private final int RED_CORD = -65536;
    private int x;
    private int y;

    public BackgroundBubbleService(Bubble bubble) {
        this.bubble = bubble;
        x = bubble.getX();
        y = bubble.getY();
        try {
            image = ImageIO.read(new File("img/backgroundMapService.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (true) {
            if (bubble.isLeftMoving()) {
                x = bubble.getX();
                y = bubble.getY();
                if (image.getRGB(x, y) == RED_CORD) {
                    bubble.setCrush(true);
                }
            }

            if (bubble.isRightMoving()) {
                x = bubble.getX() + 60;
                y = bubble.getY();
                if (image.getRGB(x, y) == RED_CORD) {
                    bubble.setCrush(true);
                }
            }

        }
    }

}
