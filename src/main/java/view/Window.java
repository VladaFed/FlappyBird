package view;

import controller.GamePresenter;
import main.GameConfiguration;

import javax.swing.*;
import java.io.IOException;

public class Window extends JFrame  {

    public Window(GameConfiguration configuration, GamePresenter gamePresenter) throws IOException {
        NewGame newGame = new NewGame(gamePresenter,  this, configuration);
        getContentPane().add(newGame);
        setSize(configuration.field_width, configuration.field_height);
        setTitle("GamePanel");
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
