package view;

import controller.GameObject;
import controller.GamePresenter;
import main.GameConfiguration;

import javax.swing.*;
import java.util.List;

public class Window extends JFrame  {
    NewGame newGame;

    public Window(GameConfiguration configuration, GamePresenter gamePresenter) {
        newGame = new NewGame(gamePresenter,  this, configuration);
        getContentPane().add(newGame);
        setSize(configuration.field_width, configuration.field_height);
        setTitle("GamePanel");
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void gameOver() {
        newGame.gameOver();
    }

    public void setGameState(List<GameObject> gameObjects) {
        newGame.setGameState(gameObjects);
    }
}
