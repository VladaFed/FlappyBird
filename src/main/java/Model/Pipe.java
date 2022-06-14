package Model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class Pipe extends JPanel {

    public static BufferedImage pipe1;
    public static BufferedImage pipe2;

    private static final int WIDTH_PIPE = 70;
    private static final int HEIGHT_PIPE = 1000;
    private static final int DISTANCE_WIDTH_PIPES = 800;
    private static final double WIDTH_BIRD = 70;
    private static final double HEIGHT_BIRD = 70;

    private static final int DISTANCE = 300;
    private static final int DISTANCE_HEIGHT = HEIGHT_PIPE + DISTANCE;

    private static final int min_location_pipe = 200;
    private static final int max_location_pipe = 700;
    private static final int start_posX1 = 500;
    private static final int start_posX2 = 500;

    private int posY1;
    private int posY2;
    public int posX1;
    public int num = 0;
    public int score = 0;

    Random rand;

    public ArrayList<Pipe> pipes;
    private static final double speedPipe = 2;

    public Bird b;

    public Pipe(int a) {
        posX1 = a;
        pipeArrangement();
    }

    public void pipeArrangement() {
        num += 1;
        rand = new Random();
        posY1 = rand.nextInt(max_location_pipe - min_location_pipe) + min_location_pipe;
        posY2 = posY1 - DISTANCE_HEIGHT;
        //System.out.println("Y1 - " + posY1);
        //System.out.println("Y2 - " + posY2);
    }

    public void pipeMove() {
        posX1 -= speedPipe;
        //System.out.println("PosXspeed - " + posX1);
        System.out.println("speed - " + speedPipe);
    }

    public int XPipe() {
        return posX1;
    }

    public int YBottomPipe() {
        return posY1;
    }

    public int YTopPipe() {
        return posY2;
    }

    public int birdRecord() {
        return score;
    }

    public boolean collisions(int birdX, int birdY) {
        if (posX1 <= 370 && posX1 >= 230) {
            //System.out.println("posX1 - " + posX1);
            //System.out.println("birdX - " + birdX);
            //System.out.println("birdY - " + birdY);
            if ((birdY >= (posY1 - DISTANCE)) && ((birdY + HEIGHT_BIRD) <= posY1)) {
                score++;
                return true;
            } else
                return false;
        }
        return true;
    }

    static void draw(Graphics g) {
        //g.drawImage(pipe1, posX1, posY1, WIDTH_PIPE, HEIGHT_PIPE, null);
        //g.drawImage(pipe2, posX1, posY2, WIDTH_PIPE, HEIGHT_PIPE, null);

    }

}
