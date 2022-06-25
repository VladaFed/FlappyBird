package view;

import main.GameConfiguration;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FieldPanel extends JPanel {

    private BufferedImage bird;
    private BufferedImage pipe1;
    private BufferedImage pipe2;
    private BufferedImage back;
    private BufferedImage about;

    GameConfiguration gameConfiguration;

    public FieldPanel(GameConfiguration gameConfiguration) {
        try {
            bird = ImageIO.read(new File("src/main/java/Pictures/bird7.png"));
            back = ImageIO.read(new File("src/main/java/Pictures/back7.png"));
            pipe1 = ImageIO.read(new File("src/main/java/Pictures/pipe.png"));
            pipe2 = ImageIO.read(new File("src/main/java/Pictures/pipe2.png"));
            about = ImageIO.read(new File("src/main/java/Pictures/about.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawStartPanel(g);
    }

    private void drawStartPanel(Graphics g) {
        g.drawImage(back, 0, 0, 2700, 790, this);
    }

}
