import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static Model.Bird.startX;
import static Model.Bird.startY;
import static java.lang.System.exit;

public class BirdPanel extends JPanel implements MouseListener {
    final int MENU = 0;
    final int GAME = 1;
    private int place = GAME;


    private Random rand;
    private BufferedImage bird;
    private BufferedImage pipe1;
    private BufferedImage pipe2;
    private BufferedImage back;

    private Point clickPoint = new Point(-1, -1);

    public World world;
    public Bird b;

    private static final int WIDTH_PIPE = 70;
    private static final int HEIGHT_PIPE = 1000;
    private static final int DISTANCE_WIDTH_PIPES = 200;
    public ArrayList<Pipe> pipes;
    public Pipe p1;
    public Pipe p2;

    public BirdPanel() {
        b = new Bird();
        this.addMouseListener(this);

        try {
            bird = ImageIO.read(new File("src/main/java/Pictures/bird7.png"));
            back = ImageIO.read(new File("src/main/java/Pictures/back7.png"));
            pipe1 = ImageIO.read(new File("src/main/java/Pictures/pipe.png"));
            pipe2 = ImageIO.read(new File("src/main/java/Pictures/pipe2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pipes = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            pipes.add(new Pipe(900 + 300*i));
        }

    }

    public void startGame() {
        b.x = startX;
        b.y = startY;
        //score = 0;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mousePressed");
        clickPoint = e.getPoint();
        if (place == GAME) {
            if (b.exists()) {
                b.flyUp();
            } else {
                //new Box();
            }
        }

    }

    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}


    public void pip(Graphics g) {
        for (Pipe p : pipes) {
            if (b.exists()) {
                p.pipeMove();
            }

            int coord = (int)p.XPipe();
            g.drawImage(pipe1, coord, p.YBottomPipe(), WIDTH_PIPE, HEIGHT_PIPE, null);
            g.drawImage(pipe2, coord, p.YTopPipe(), WIDTH_PIPE, HEIGHT_PIPE, null);

            if (b.exists()) {
                if (!p.collisions(b.coordX(), b.coordY())) {
                    b.death();
                    b.fall();
                    startGame();
                    //new Box();
                }
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(back, 0, 0, 2700, 790, this);

        switch (place) {
            case GAME:
                if (b.exists()) {
                    pip(g);
                    b.flyDown();
                } else {
                    b.draw(g);
                }
            case MENU:
                //new Box();


        }

        //p2 = new Pipe(900);
        //p2.pipeMove();
        //p2.draw(g);
        b.flyDown();
        b.draw(g);

    }
}
