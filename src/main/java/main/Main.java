package main;

import view.FieldPanel;
import view.MainFrame;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GameConfiguration gameConfiguration = new GameConfiguration("config.properties");
        gameConfiguration.readFromProperties();

        MainFrame frame = new MainFrame(gameConfiguration);
        FieldPanel fieldPanel = new FieldPanel(gameConfiguration);
    }
}
