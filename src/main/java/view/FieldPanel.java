package view;

import controller.GameObject;
import controller.GamePresenter;
import main.GameConfiguration;
import main.GameConfigurationMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class FieldPanel extends JPanel {
    private static final Image back = new ImageIcon("src/main/resources/pictures/back7.png").getImage();
    private static final Image bird = new ImageIcon("src/main/resources/pictures/bird7.png").getImage();
    private static final Image pipe1 = new ImageIcon("src/main/resources/pictures/pipe.png").getImage();
    private static final Image pipe2 = new ImageIcon("src/main/resources/pictures/pipe2.png").getImage();

    java.util.Timer timer;

    public String name;
    private Point clickPoint;

    GamePresenter gamePresenter;
    GameConfiguration configuration;
    GameConfigurationMenu configurationMenu;
    GameFrame parent;
    private boolean mouseListenerIsActive;

    List<GameObject> gameState = new ArrayList<>();

    private void addEventListeners() {
        mouseListenerIsActive = true;
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (mouseListenerIsActive) {
                    clickPoint = e.getPoint();
                    gamePresenter.updateClick();
                    repaint();
                }
            }
        });
    }

    public FieldPanel(GamePresenter presenter, GameFrame gameFrame, GameConfiguration config, GameConfigurationMenu configMenu) {
        gamePresenter = presenter;
        configuration = config;
        configurationMenu = configMenu;
        parent = gameFrame;

        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                gamePresenter.update();
                repaint();
            }
        };
        timer.schedule(timerTask, 0, 20);

        addEventListeners();
    }

    public void drawPipes(Graphics g) {
        for (int i = 1; i < gameState.size(); i++){
            GameObject.PipeModel current = (GameObject.PipeModel) gameState.get(i);
            if (current.x() - gamePresenter.birdCoordX() < configurationMenu.fieldWidth){
                g.drawImage(pipe1, current.x() - gamePresenter.birdCoordX(),
                        current.yBottom(), configuration.pipeWidth, configuration.pipeHeight, this);
                g.drawImage(pipe2, current.x() - gamePresenter.birdCoordX(),
                        current.yTop(), configuration.pipeWidth, configuration.pipeHeight, this);
            }
        }
    }


    public void gameOver(){
        mouseListenerIsActive = false;
        gamePresenter.gameOver();
        timer.cancel();
        parent.dispose();
    }

    public void drawBird(Graphics g) {
        int x = configuration.birdStartX;
        if (gameState.size() > 0) {
            GameObject.BirdModel birdObject = (GameObject.BirdModel)gameState.get(0);
            g.drawImage(bird, x, birdObject.y(), configuration.birdWidth, configuration.birdHeight, this);
        }
    }

    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        g.drawImage(back, configuration.backX, configuration.backY, configuration.backWidth, configuration.backHeight, this);
        drawBird(g);
        drawPipes(g);
    }

    public void setGameState(List<GameObject> obj) {
        gameState = obj;
    }
}
