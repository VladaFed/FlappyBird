
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bird {
    static private BufferedImage bird;
    public static int x = 300;
    public static int y = 300;
    public static double deltCoord = 300;
    public static double speedBird = 0;

    public static final double G = 0.0001;
    public static int startX = 300;
    public static int startY = 300;

    private static final double WIDTH_BIRD = 70;
    private static final double HEIGHT_BIRD = 70;
    private boolean life = true;


    public Bird() {
        try {
            bird = ImageIO.read(new File("src/main/java/Pictures/bird7.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void flyUp() {
        speedBird -= 0.07;
        deltCoord -= speedBird;
    }

    public void flyDown() {
        speedBird += G;
        deltCoord += speedBird;
    }

    public void fall() {
        speedBird += 0.5;
        deltCoord += speedBird;
    }

    public int coordX() {
        return x;
    }

    public int coordY() {
        return (int) deltCoord;
    }

    public boolean exists() {
        return life;
    }

    public void death() {
        life = false;
    }



    static void draw(Graphics g) {
        y = (int) deltCoord;
        g.drawImage(bird, x, y, 70, 70, null);
    }


}
