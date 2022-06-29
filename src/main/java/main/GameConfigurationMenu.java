package main;

import utils.PropertiesParser;

import java.io.IOException;
import java.util.Properties;

public class GameConfigurationMenu {
    public int menuHeight;
    public int menuWidth;

    public int fieldHeight;
    public int fieldWidth;

    public int recordPanelWidth;
    public int recordPanelHeight;

    public int panelStartWidth;
    public int panelStartHeight;

    public int aboutPanelHeight;
    public int aboutPanelWidth;

    public int flappyBirdSize;
    public int flappyBirdX;
    public int flappyBirdY;
    public int flappyBirdWidth;
    public int flappyBirdHeight;

    public int warningBirdSize;
    public int warningX;
    public int warningY;
    public int warningWidth;
    public int warningHeight;

    public int registrationX;
    public int registrationY;
    public int registrationWidth;
    public int registrationHeight;

    public int aboutX;
    public int aboutY;
    public int aboutWidth;
    public int aboutHeight;

    public int recordX;
    public int recordY;
    public int recordWidth;
    public int recordHeight;

    public int exitX;
    public int exitY;
    public int exitWidth;
    public int exitHeight;

    public int registrationSize;
    public int registrationLabelX;
    public int registrationLabelY;
    public int registrationLabelWidth;
    public int registrationLabelHeight;

    public int enterNameSize;
    public int enterNameX;
    public int enterNameY;
    public int enterNameWidth;
    public int enterNameHeight;

    public int startX;
    public int startY;
    public int startWidth;
    public int startHeight;

    public int nameX;
    public int nameY;
    public int nameWidth;
    public int nameHeight;

    private Properties properties;
    private PropertiesParser propertiesParser;
    private String filename;

    public GameConfigurationMenu(String filename) {
        this.filename = filename;
    }

    public void readFromProperties() throws IOException {
        propertiesParser = new PropertiesParser(filename);
        menuHeight = propertiesParser.getInteger("menuHeight");
        menuWidth = propertiesParser.getInteger("menuWidth");

        fieldHeight = propertiesParser.getInteger("fieldHeight");
        fieldWidth = propertiesParser.getInteger("fieldWidth");

        recordPanelWidth = propertiesParser.getInteger("recordPanelWidth");
        recordPanelHeight = propertiesParser.getInteger("recordPanelHeight");

        panelStartWidth = propertiesParser.getInteger("panelStartWidth");
        panelStartHeight = propertiesParser.getInteger("panelStartHeight");

        aboutPanelHeight = propertiesParser.getInteger("aboutPanelHeight");
        aboutPanelWidth = propertiesParser.getInteger("aboutPanelWidth");

        flappyBirdSize = propertiesParser.getInteger("flappyBirdSize");
        flappyBirdX = propertiesParser.getInteger("flappyBirdX");
        flappyBirdY = propertiesParser.getInteger("flappyBirdY");
        flappyBirdWidth = propertiesParser.getInteger("flappyBirdWidth");
        flappyBirdHeight = propertiesParser.getInteger("flappyBirdHeight");

        warningBirdSize = propertiesParser.getInteger("warningBirdSize");
        warningX = propertiesParser.getInteger("warningX");
        warningY = propertiesParser.getInteger("warningY");
        warningWidth = propertiesParser.getInteger("warningWidth");
        warningHeight = propertiesParser.getInteger("warningHeight");

        registrationX = propertiesParser.getInteger("registrationX");
        registrationY = propertiesParser.getInteger("registrationY");
        registrationWidth = propertiesParser.getInteger("registrationWidth");
        registrationHeight = propertiesParser.getInteger("registrationHeight");

        aboutX = propertiesParser.getInteger("aboutX");
        aboutY = propertiesParser.getInteger("aboutY");
        aboutWidth = propertiesParser.getInteger("aboutWidth");
        aboutHeight = propertiesParser.getInteger("aboutHeight");

        recordX = propertiesParser.getInteger("recordX");
        recordY = propertiesParser.getInteger("recordY");
        recordWidth = propertiesParser.getInteger("recordWidth");
        recordHeight = propertiesParser.getInteger("recordHeight");

        exitX = propertiesParser.getInteger("exitX");
        exitY = propertiesParser.getInteger("exitY");
        exitWidth = propertiesParser.getInteger("exitWidth");
        exitHeight = propertiesParser.getInteger("exitHeight");

        registrationSize = propertiesParser.getInteger("registration_size");
        registrationLabelX = propertiesParser.getInteger("registration_label_x");
        registrationLabelY = propertiesParser.getInteger("registration_label_y");
        registrationLabelWidth = propertiesParser.getInteger("registration_label_width");
        registrationLabelHeight = propertiesParser.getInteger("registration_label_height");

        enterNameSize = propertiesParser.getInteger("enterNameSize");
        enterNameX = propertiesParser.getInteger("enterNameX");
        enterNameY = propertiesParser.getInteger("enterNameY");
        enterNameWidth = propertiesParser.getInteger("enterNameWidth");
        enterNameHeight = propertiesParser.getInteger("enterNameHeight");

        startX = propertiesParser.getInteger("startX");
        startY = propertiesParser.getInteger("startY");
        startWidth = propertiesParser.getInteger("startWidth");
        startHeight = propertiesParser.getInteger("startHeight");

        nameX = propertiesParser.getInteger("nameX");
        nameY = propertiesParser.getInteger("nameY");
        nameWidth = propertiesParser.getInteger("nameWidth");
        nameHeight = propertiesParser.getInteger("nameHeight");
    }
}
