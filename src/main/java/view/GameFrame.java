package view;

import controller.GameObject;
import controller.GamePresenter;
import main.GameConfiguration;
import main.GameConfigurationMenu;

import javax.swing.*;
import java.util.List;

public class GameFrame extends JFrame  {
    FieldPanel fieldPanel;

    public GameFrame(GameConfiguration configuration, GameConfigurationMenu configurationMenu, GamePresenter gamePresenter) {
        fieldPanel = new FieldPanel(gamePresenter,  this, configuration, configurationMenu);
        getContentPane().add(fieldPanel);
        setSize(configurationMenu.fieldWidth, configurationMenu.fieldHeight);
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
