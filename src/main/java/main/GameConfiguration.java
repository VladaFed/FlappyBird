package main;

import utils.PropertiesParser;

import java.io.IOException;
import java.util.Properties;

public class GameConfiguration {
    public int field_height;
    public int field_width;
    public int menu_height;
    public int menu_width;
    public int record_panel_width;
    public int record_panel_height;

    public int back_x;
    public int back_y;
    public int back_width;
    public int back_height;
    public int deltCoords;
    public int deltMoveX;

    public int bird_width;
    public int bird_height;
    public int bird_startX;
    public double speedBird;
    public double G;

    public int pipe_width;
    public int pipe_height;
    public int distance_width_pipes;
    public int distance_height_pipes;
    public int pipe_speed;
    public int pipe_startX;
    public int pipe_num;
    public int min_location_pipe;
    public int max_location_pipe;

    private Properties properties;
    private PropertiesParser propertiesParser;
    private String filename;

    public GameConfiguration(String filename) {
        this.filename = filename;
    }

    public void readFromProperties() throws IOException {
        propertiesParser = new PropertiesParser(filename);
        menu_height = propertiesParser.getInteger("menu_height");
        menu_width = propertiesParser.getInteger("menu_width");

        field_height = propertiesParser.getInteger("field_height");
        field_width = propertiesParser.getInteger("field_width");

        record_panel_width = propertiesParser.getInteger("record_panel_width");
        record_panel_height = propertiesParser.getInteger("record_panel_height");

        back_x = propertiesParser.getInteger("back_x");
        back_y = propertiesParser.getInteger("back_y");
        back_width = propertiesParser.getInteger("back_width");
        back_height = propertiesParser.getInteger("back_height");

        bird_width = propertiesParser.getInteger("bird_width");
        bird_height = propertiesParser.getInteger("bird_height");
        bird_startX = propertiesParser.getInteger("bird_startX");
        speedBird = propertiesParser.getDouble("speedBird");
        G = propertiesParser.getDouble("G");
        deltCoords = propertiesParser.getInteger("deltCoords");
        deltMoveX = propertiesParser.getInteger("deltMoveX");

        pipe_width = propertiesParser.getInteger("pipe_width");
        pipe_height = propertiesParser.getInteger("pipe_height");
        distance_width_pipes = propertiesParser.getInteger("distance_width_pipes");
        distance_height_pipes = propertiesParser.getInteger("distance_height_pipes");
        pipe_speed = propertiesParser.getInteger("pipe_speed");
        pipe_startX = propertiesParser.getInteger("pipe_startX");
        pipe_num = propertiesParser.getInteger("pipe_num");
        min_location_pipe = propertiesParser.getInteger("min_location_pipe");
        max_location_pipe = propertiesParser.getInteger("max_location_pipe");
    }

}
