package view;

import controller.GameObject;
import controller.GamePresenter;
import main.GameConfiguration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class NewGame extends JPanel {
    private static final Image back = new ImageIcon("src/main/resources/pictures/back7.png").getImage();
    private static final Image bird = new ImageIcon("src/main/resources/pictures/bird7.png").getImage();
    private static final Image pipe1 = new ImageIcon("src/main/resources/pictures/pipe.png").getImage();
    private static final Image pipe2 = new ImageIcon("src/main/resources/pictures/pipe2.png").getImage();

    java.util.Timer timer;

    public String name;
    private Point clickPoint;

    GamePresenter gamePresenter;
    GameConfiguration configuration;
    Window parent;

    List<GameObject> gameState = new ArrayList<>();

    private void addEventListeners() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clickPoint = e.getPoint();
                gamePresenter.updateClick();
                repaint();
            }
        });
    }

    public NewGame(GamePresenter presenter, Window window, GameConfiguration config) {
        gamePresenter = presenter;
        configuration = config;
        parent = window;

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
            if (current.x() - gamePresenter.BirdCoordX() < configuration.field_width){
                g.drawImage(pipe1, current.x() - gamePresenter.BirdCoordX(),
                        current.yBottom(), configuration.pipe_width, configuration.pipe_height, this);
                g.drawImage(pipe2, current.x() - gamePresenter.BirdCoordX(),
                        current.yTop(), configuration.pipe_width, configuration.pipe_height, this);
            }
        }
    }


    public void gameOver(){
        gamePresenter.gameOver();
        timer.cancel();
        parent.dispose();
    }

    public void drawBird(Graphics g) {
        int x = configuration.bird_startX;
        if (gameState.size() > 0) {
            GameObject.BirdModel birdObject = (GameObject.BirdModel) gameState.get(0);
            g.drawImage(bird, x, birdObject.y(), configuration.bird_width, configuration.bird_height, this);
        }
    }

    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        g.drawImage(back, configuration.back_x, configuration.back_y, configuration.back_width, configuration.back_height, this);
        drawBird(g);
        drawPipes(g);
    }

    public void setGameState(List<GameObject> obj) {
        gameState = obj;
    }
}
