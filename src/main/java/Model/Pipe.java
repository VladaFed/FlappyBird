package Model;

import java.util.Random;

public class Pipe {
    private static final int HEIGHT_PIPE = 1000;
    private static final double HEIGHT_BIRD = 70;

    private static final int DISTANCE = 300;
    private static final int DISTANCE_HEIGHT = HEIGHT_PIPE + DISTANCE;

    private static final int min_location_pipe = 200;
    private static final int max_location_pipe = 700;

    private int posY1;
    private int posY2;
    public int posX1;
    public static int score = 0;
    private static final double speedPipe = 1;

    Random rand;

    public Pipe(int l) {
        posX1 = l;
        pipeArrangement();
    }

    public void pipeArrangement() {
        rand = new Random();
        posY1 = rand.nextInt(max_location_pipe - min_location_pipe) + min_location_pipe;
        posY2 = posY1 - DISTANCE_HEIGHT;
    }

    public void pipeMove() {
        posX1 -= speedPipe;
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
        if (posX1 <= 370 && posX1 > 230) {
            if ((birdY >= (posY1 - DISTANCE)) && ((birdY + HEIGHT_BIRD) <= posY1)) {
                return true;
            } else {
                score = 0;
                return false;
            }
        } else if (posX1 == 230) {
            if ((birdY >= (posY1 - DISTANCE)) && ((birdY + HEIGHT_BIRD) <= posY1)) {
                score++;
                return true;
            } else
                score = 0;
            return false;
        }
        return true;
    }


}
