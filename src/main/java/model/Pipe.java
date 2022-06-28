package model;

import java.util.Random;

public class Pipe {
    private static int heightPipe;
    private static int distance;
    private int distanceHeight = heightPipe + distance;
    private static int min_location_pipe;
    private static int max_location_pipe;

    private int yBottom;
    private int yTop;
    public int x;
    private boolean passed = false;

    public Pipe(int heightPipe, int distance, int min_location_pipe, int max_location_pipe) {
        this.heightPipe = heightPipe;
        this.distance = distance;
        this.min_location_pipe = min_location_pipe;
        this.max_location_pipe = max_location_pipe;
    }

    public Pipe(int x) {
        this.x = x;
        Random rand = new Random();
        if (max_location_pipe > min_location_pipe) {
            yBottom = rand.nextInt(max_location_pipe - min_location_pipe) + min_location_pipe;
            yTop = yBottom - distanceHeight;
        }
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

    public boolean IsPassed(){
        return passed;
    }

    public void setPassed() {
        passed = true;
    }
}
