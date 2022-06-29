package main;

import utils.PropertiesParser;

import java.io.IOException;
import java.util.Properties;

public class GameConfiguration {
    public int backX;
    public int backY;
    public int backWidth;
    public int backHeight;

    public int birdWidth;
    public int birdHeight;
    public int birdStartX;
    public int birdStartY;
    public double speedBird;
    public double G;
    public int deltaCoordinateY;
    public int deltaMoveX;

    public int pipeWidth;
    public int pipeHeight;
    public int distanceWidthPipes;
    public int distanceHeightPipes;
    public int pipeSpeed;
    public int pipeStartX;
    public int pipeNum;
    public int minLocationPipe;
    public int maxLocationPipe;

    private Properties properties;
    private PropertiesParser propertiesParser;
    private String filename;

    public GameConfiguration(String filename) {
        this.filename = filename;
    }

    public void readFromProperties() throws IOException {
        propertiesParser = new PropertiesParser(filename);

        backX = propertiesParser.getInteger("backX");
        backY = propertiesParser.getInteger("backY");
        backWidth = propertiesParser.getInteger("backWidth");
        backHeight = propertiesParser.getInteger("backHeight");

        birdWidth = propertiesParser.getInteger("birdWidth");
        birdHeight = propertiesParser.getInteger("birdHeight");
        birdStartX = propertiesParser.getInteger("birdStartX");
        birdStartY = propertiesParser.getInteger("birdStartY");
        speedBird = propertiesParser.getDouble("speedBird");
        G = propertiesParser.getDouble("G");
        deltaCoordinateY = propertiesParser.getInteger("deltaCoordinateY");
        deltaMoveX = propertiesParser.getInteger("deltaMoveX");

        pipeWidth = propertiesParser.getInteger("pipeWidth");
        pipeHeight = propertiesParser.getInteger("pipeHeight");
        distanceWidthPipes = propertiesParser.getInteger("distanceWidthPipes");
        distanceHeightPipes = propertiesParser.getInteger("distanceHeightPipes");
        pipeSpeed = propertiesParser.getInteger("pipeSpeed");
        pipeStartX = propertiesParser.getInteger("pipeStartX");
        pipeNum = propertiesParser.getInteger("pipeNum");
        minLocationPipe = propertiesParser.getInteger("minLocationPipe");
        maxLocationPipe = propertiesParser.getInteger("maxLocationPipe");
    }

}
