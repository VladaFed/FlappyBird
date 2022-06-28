package main;

import utils.PropertiesParser;

import java.io.IOException;
import java.util.Properties;

public class GameConfigurationMenu {
    public int menu_height;
    public int menu_width;

    public int field_height;
    public int field_width;

    public int panel_start_width;
    public int panel_start_height;

    public int about_panel_height;
    public int about_panel_width;

    public int flappy_bird_size;
    public int flappy_bird_x;
    public int flappy_bird_y;
    public int flappy_bird_width;
    public int flappy_bird_height;

    public int warning_bird_size;
    public int warning_x;
    public int warning_y;
    public int warning_width;
    public int warning_height;

    public int registration_x;
    public int registration_y;
    public int registration_width;
    public int registration_height;

    public int about_x;
    public int about_y;
    public int about_width;
    public int about_height;

    public int record_x;
    public int record_y;
    public int record_width;
    public int record_height;

    public int exit_x;
    public int exit_y;
    public int exit_width;
    public int exit_height;

    public int registration_size;
    public int registration_label_x;
    public int registration_label_y;
    public int registration_label_width;
    public int registration_label_height;

    public int enter_name_size;
    public int enter_name_x;
    public int enter_name_y;
    public int enter_name_width;
    public int enter_name_height;

    public int start_x;
    public int start_y;
    public int start_width;
    public int start_height;

    public int name_x;
    public int name_y;
    public int name_width;
    public int name_height;

    private Properties properties;
    private PropertiesParser propertiesParser;
    private String filename;

    public GameConfigurationMenu(String filename) {
        this.filename = filename;
    }

    public void readFromProperties() throws IOException {
        propertiesParser = new PropertiesParser(filename);
        menu_height = propertiesParser.getInteger("menu_height");
        menu_width = propertiesParser.getInteger("menu_width");

        field_height = propertiesParser.getInteger("field_height");
        field_width = propertiesParser.getInteger("field_width");

        panel_start_width = propertiesParser.getInteger("panel_start_width");
        panel_start_height = propertiesParser.getInteger("panel_start_height");

        about_panel_height = propertiesParser.getInteger("about_panel_height");
        about_panel_width = propertiesParser.getInteger("about_panel_width");

        flappy_bird_size = propertiesParser.getInteger("flappy_bird_size");
        flappy_bird_x = propertiesParser.getInteger("flappy_bird_x");
        flappy_bird_y = propertiesParser.getInteger("flappy_bird_y");
        flappy_bird_width = propertiesParser.getInteger("flappy_bird_width");
        flappy_bird_height = propertiesParser.getInteger("flappy_bird_height");

        warning_bird_size = propertiesParser.getInteger("warning_bird_size");
        warning_x = propertiesParser.getInteger("warning_x");
        warning_y = propertiesParser.getInteger("warning_y");
        warning_width = propertiesParser.getInteger("warning_width");
        warning_height = propertiesParser.getInteger("warning_height");

        registration_x = propertiesParser.getInteger("registration_x");
        registration_y = propertiesParser.getInteger("registration_y");
        registration_width = propertiesParser.getInteger("registration_width");
        registration_height = propertiesParser.getInteger("registration_height");

        about_x = propertiesParser.getInteger("about_x");
        about_y = propertiesParser.getInteger("about_y");
        about_width = propertiesParser.getInteger("about_width");
        about_height = propertiesParser.getInteger("about_height");

        record_x = propertiesParser.getInteger("record_x");
        record_y = propertiesParser.getInteger("record_y");
        record_width = propertiesParser.getInteger("record_width");
        record_height = propertiesParser.getInteger("record_height");

        exit_x = propertiesParser.getInteger("exit_x");
        exit_y = propertiesParser.getInteger("exit_y");
        exit_width = propertiesParser.getInteger("exit_width");
        exit_height = propertiesParser.getInteger("exit_height");
        registration_label_x = propertiesParser.getInteger("registration_label_x");

        registration_size = propertiesParser.getInteger("registration_size");
        registration_label_x = propertiesParser.getInteger("registration_label_x");
        registration_label_y = propertiesParser.getInteger("registration_label_y");
        registration_label_width = propertiesParser.getInteger("registration_label_width");
        registration_label_height = propertiesParser.getInteger("registration_label_height");

        enter_name_size = propertiesParser.getInteger("enter_name_size");
        enter_name_x = propertiesParser.getInteger("enter_name_x");
        enter_name_y = propertiesParser.getInteger("enter_name_y");
        enter_name_width = propertiesParser.getInteger("enter_name_width");
        enter_name_height = propertiesParser.getInteger("enter_name_height");

        start_x = propertiesParser.getInteger("start_x");
        start_y = propertiesParser.getInteger("start_y");
        start_width = propertiesParser.getInteger("start_width");
        start_height = propertiesParser.getInteger("start_height");

        name_x = propertiesParser.getInteger("name_x");
        name_y = propertiesParser.getInteger("name_y");
        name_width = propertiesParser.getInteger("name_width");
        name_height = propertiesParser.getInteger("name_height");
    }
}
