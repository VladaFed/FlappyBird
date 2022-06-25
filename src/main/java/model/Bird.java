package model;

public class Bird {
    private int X = 300;
    private double y = 300;
    private static final double G = 0.22;
    private double speedBird = 0;
    private boolean isAlive = true;

    public void flyUp() {
        speedBird -= 4;
        y -= speedBird;
    }

    public void flyDown() {
        speedBird += G;
        y += speedBird;
    }

    public int coordX() {
        return X;
    }

    public int coordY() {
        return (int) y;
    }

    public boolean exists() {
        return isAlive;
    }

    public boolean death() {
        return isAlive = false;
    }

    public void moveX() {
        X += 8;
    }
}
