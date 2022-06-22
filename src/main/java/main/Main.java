package main;

import Model.GameConfiguration;
import View.MainFrame;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //GameSettings gameSettings = GameSettings.fromFile("resources/config.properties");
        //MainFrame frame = new MainFrame(gameSettings);

        GameConfiguration gameConfiguration = new GameConfiguration("config.properties");
        gameConfiguration.readFromProperties();

        MainFrame frame = new MainFrame(gameConfiguration);
        //FieldPanel fieldPanel = new FieldPanel(gameConfiguration);
        //fieldPanel.start();

    }
}
