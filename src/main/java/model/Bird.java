package model;

public class Bird {
    private int X;
    private double G;
    private double speedBird;
    private int deltCoords;
    private int deltMoveX;
    private boolean isAlive = true;
    private int y = 300;

    public void settingsBird(int X, double speedBird, double G, int deltCoords, int deltMoveX) {
        this.X = X;
        this.speedBird = speedBird;
        this.G = G;
        this.deltCoords = deltCoords;
        this.deltMoveX = deltMoveX;
    }

    public void flyUp() {
        speedBird -= deltCoords;
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
        X += deltMoveX;
    }
}
