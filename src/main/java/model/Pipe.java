package model;

import java.util.Random;

public class Pipe {
    private static final int HEIGHT_PIPE = 1000;

    private static final int DISTANCE = 300;
    private static final int DISTANCE_HEIGHT = HEIGHT_PIPE + DISTANCE;

    private static final int min_location_pipe = 200;
    private static final int max_location_pipe = 700;

    private int yBottom;
    private int yTop;
    public int x;

    public Pipe(int x) {
        this.x = x;
        Random rand = new Random();
        yBottom = rand.nextInt(max_location_pipe - min_location_pipe) + min_location_pipe;
        yTop = yBottom - DISTANCE_HEIGHT;
    }

    public int x() {
        return x;
    }

    public int yBottom() {
        return yBottom;
    }

    public int yTop() {
        return yTop;
    }
}
