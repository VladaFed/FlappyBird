package model;

public class Bird {
    private int X;
    private double G;
    private double speedBird;
    private int deltaCoordinateY;
    private int deltaMoveX;
    private int Y;

    public void settingsBird(int Y, int X, double speedBird, double G, int deltaCoordinateY, int deltaMoveX) {
        this.Y = Y;
        this.X = X;
        this.speedBird = speedBird;
        this.G = G;
        this.deltaCoordinateY = deltaCoordinateY;
        this.deltaMoveX = deltaMoveX;
    }

    public void flyUp() {
        speedBird -= deltaCoordinateY;
        Y -= speedBird;
    }

    public void flyDown() {
        speedBird += G;
        Y += speedBird;
    }

    public int birdXCoordinate() {
        return X;
    }

    public int birdYCoordinate() {
        return Y;
    }

    public void moveX() {
        X += deltaMoveX;
    }
}
