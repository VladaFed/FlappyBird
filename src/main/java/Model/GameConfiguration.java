package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GameConfiguration {
    public int field_height;
    public int field_width;
    public int menu_height;
    public int menu_width;

    public int bird_width;
    public int bird_height;
    public int bird_startX;
    public int bird_startY;
    public int bird_speed;

    public int pipe_width;
    public int pipe_height;
    public int distance_width_pipes;
    public int distance_height_pipes;
    public int pipe_speed;

    private Properties properties;
    private PropertiesParser propertiesParser;
    private String filename;

    public GameConfiguration(String filename) {
        this.filename = filename;
    }

    /*public GameConfiguration(Properties configProperties)  {
        propertiesParser = new PropertiesParser(configProperties);
    }*/



    public void readFromProperties() throws IOException {
        propertiesParser = new PropertiesParser(filename);
        menu_height = propertiesParser.getInteger("menu_height");
        menu_width = propertiesParser.getInteger("menu_width");

        field_height = propertiesParser.getInteger("field_height");
        field_width = propertiesParser.getInteger("field_width");

        bird_width = propertiesParser.getInteger("bird_width");
        bird_height = propertiesParser.getInteger("bird_height");
        bird_startX = propertiesParser.getInteger("bird_startX");
        bird_startY = propertiesParser.getInteger("bird_startY");
        bird_speed = propertiesParser.getInteger("bird_speed");

        pipe_width = propertiesParser.getInteger("pipe_width");
        pipe_height = propertiesParser.getInteger("pipe_height");
        distance_width_pipes = propertiesParser.getInteger("distance_width_pipes");
        distance_height_pipes = propertiesParser.getInteger("distance_height_pipes");
        pipe_speed = propertiesParser.getInteger("pipe_speed");
    }
}
