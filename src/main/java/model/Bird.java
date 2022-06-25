package model;

public class Bird {
    private int X = 300;
    private double y = 300;
    private final double G = 0.22;
    private double deltCoord = 300;
    private double speedBird = 0;
    private boolean life = true;

    public Bird() {}

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
        return life;
    }

    public boolean death() {
        return life = false;
    }

    public void moveX() {
        X += 8;
    }
}
