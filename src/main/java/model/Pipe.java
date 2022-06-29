package model;

import java.util.Random;

public class Pipe {
    private static int heightPipe;
    private static int distance;
    private int distanceHeight = heightPipe + distance;
    private static int minLocationPipe;
    private static int maxLocationPipe;

    private int yBottom;
    private int yTop;
    public int x;
    private boolean passed = false;

    public Pipe(int heightPipe, int distance, int minLocationPipe, int maxLocationPipe) {
        this.heightPipe = heightPipe;
        this.distance = distance;
        this.minLocationPipe = minLocationPipe;
        this.maxLocationPipe = maxLocationPipe;
    }

    public Pipe(int x) {
        this.x = x;
        Random rand = new Random();
        if (maxLocationPipe > minLocationPipe) {
            yBottom = rand.nextInt(maxLocationPipe - minLocationPipe) + minLocationPipe;
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
