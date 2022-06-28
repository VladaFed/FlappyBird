package main;

import view.MainFrame;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GameConfiguration gameConfiguration = new GameConfiguration("config.properties");
        GameConfigurationMenu gameConfigurationMenu = new GameConfigurationMenu("menu.properties");
        gameConfiguration.readFromProperties();
        gameConfigurationMenu.readFromProperties();


        MainFrame frame = new MainFrame(gameConfigurationMenu, gameConfiguration);
        //FieldPanel fieldPanel = new FieldPanel(gameConfiguration);
    }
}
