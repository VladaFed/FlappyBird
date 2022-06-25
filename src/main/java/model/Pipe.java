package model;

import java.util.Random;

public class Pipe {
    private static final int HEIGHT_PIPE = 1000;

    private static final int DISTANCE = 300;
    private static final int DISTANCE_HEIGHT = HEIGHT_PIPE + DISTANCE;

    private static final int min_location_pipe = 200;
    private static final int max_location_pipe = 700;

    private int posY1;
    private int posY2;
    public int posX1;
    private boolean passed = false;

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

    public int XPipe() {
        return posX1;
    }

    public boolean isPassed() {
        return passed;
    }

    public int YBottomPipe() {
        return posY1;
    }

    public int YTopPipe() {
        return posY2;
    }
}
