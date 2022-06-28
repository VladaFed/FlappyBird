package model;

public class Bird {
    private int X;
    private double G;
    private double speedBird;
    private boolean isAlive = true;
    private int y = 300;

    public void settingsBird(int X, double speedBird, double G) {
        this.X = X;
        this.speedBird = speedBird;
        this.G = G;
    }

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
        return y;
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
