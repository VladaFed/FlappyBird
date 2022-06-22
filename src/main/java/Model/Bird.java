package Model;

public class Bird {
    public static int x = 300;
    public static final double G = 0.002;
    public static double deltCoord = 300;
    public static double speedBird;
    //public static int x = 300;
    private boolean life = true;

    GameConfiguration gameConfiguration;

    public Bird() {}

    public double flyUp() {
        speedBird -= 0.48;
        deltCoord -= speedBird;
        return deltCoord;
    }

    public double flyDown() {
        //System.out.println("flyDown");
        speedBird += G;
        deltCoord += speedBird;
        return deltCoord;
    }

    public double fall() {
        //speedBird += 0.9;
        //deltCoord += speedBird;
        deltCoord = 300;
        return deltCoord;
    }

    public int coordX() {return x;}

    public int coordY() {
        return (int) deltCoord;
    }

    public boolean exists() {
        return life;
    }

    public boolean death() {
        return life = false;
    }



}
