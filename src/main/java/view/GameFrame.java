package view;

import controller.GameObject;
import controller.GamePresenter;
import main.GameConfiguration;

import javax.swing.*;
import java.util.List;

public class GameFrame extends JFrame  {
    FieldPanel fieldPanel;

    public GameFrame(GameConfiguration configuration, GamePresenter gamePresenter) {
        fieldPanel = new FieldPanel(gamePresenter,  this, configuration);
        getContentPane().add(fieldPanel);
        setSize(configuration.field_width, configuration.field_height);
        setTitle("GamePanel");
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void gameOver() {
        fieldPanel.gameOver();
    }

    public void setGameState(List<GameObject> gameObjects) {
        fieldPanel.setGameState(gameObjects);
    }
}
