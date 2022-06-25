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
    // CR: private static final
    private Image back;
    private Image bird;
    private Image pipe1;
    private Image pipe2;

    java.util.Timer timer;

    public List<PipeView> pipes;

    public String name;
    private Point clickPoint;

    GamePresenter gamePresenter;
    GameConfiguration configuration;
    Window parent;

    List<GameObject> gameState;

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

    private void birdMove(){
        gamePresenter.birdMoveX();
    }

    public NewGame(GamePresenter presenter, Window window, GameConfiguration config) {
        gamePresenter = presenter;
        configuration = config;
        parent = window;

        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                repaint();
            }
        };
        timer.schedule(timerTask, 0, 20);

        bird = new ImageIcon("src/main/java/Pictures/bird7.png").getImage();
        back = new ImageIcon("src/main/java/Pictures/back7.png").getImage();
        pipe1 = new ImageIcon("src/main/java/Pictures/pipe.png").getImage();
        pipe2 = new ImageIcon("src/main/java/Pictures/pipe2.png").getImage();

        addEventListeners();
    }

    public void crashedBird(Graphics g) {
        pipes = gamePresenter.getPipes();
        for (PipeView p : pipes) {
            if (p.XPipe() - gamePresenter.BirdCoordX() < configuration.field_width){
                g.drawImage(pipe1, p.XPipe() - gamePresenter.BirdCoordX(),
                        p.YBottomPipe(), configuration.pipe_width, configuration.pipe_height, this);
                g.drawImage(pipe2, p.XPipe() - gamePresenter.BirdCoordX(),
                        p.YTopPipe(), configuration.pipe_width, configuration.pipe_height, this);

                if (((p.YBottomPipe() - gamePresenter.BirdCoordY() < configuration.bird_height) &&
                        Math.abs(p.XPipe() - (gamePresenter.BirdCoordX() + configuration.bird_startX)) < configuration.bird_width)
                    || ((p.YBottomPipe() - configuration.distance_height_pipes > gamePresenter.BirdCoordY()) &&
                        Math.abs(p.XPipe() - (gamePresenter.BirdCoordX() + configuration.bird_startX)) < configuration.bird_width)) {
                    gameOver();
                } else if (gamePresenter.BirdCoordX() + configuration.bird_startX  > configuration.pipe_startX + configuration.pipe_num*configuration.distance_width_pipes) {
                    gameOver();
                } else if (p.XPipe() - (gamePresenter.BirdCoordX() + configuration.bird_startX) < configuration.bird_width){
                    p.setPassed();
                }
            }
        }
    }

    //|| ((p.YTopPipe() - gamePresenter.BirdCoordY() < configuration.bird_height/2) &&
      //      Math.abs(p.XPipe() - (gamePresenter.BirdCoordX() + 300 )) < configuration.bird_width/2)
    //|| ((gamePresenter.BirdCoordY() - p.YTopPipe() < configuration.bird_height) &&
      //      Math.abs(p.XPipe() - (gamePresenter.BirdCoordX() + 300 )) < configuration.bird_width))

    private void gameOver(){
        gamePresenter.updateScore();
        gamePresenter.birdDeath();
        timer.cancel();
        parent.dispose();
    }

    public boolean birdInsideField(int y){
        return y < configuration.field_height && y > 0;
    }

    public void drawBird(Graphics g) {
        int x = configuration.bird_startX;
        int y = gamePresenter.BirdCoordY();
        if (birdInsideField(y)){
            g.drawImage(bird, x, y, configuration.bird_width, configuration.bird_height, this);
        } else {
            gameOver();
        }
    }

    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        //g.drawImage(back, -1 * (gamePresenter.BirdCoordX() % gamePresenter.BirdCoordX()), 0, 2700, 790, this);
        g.drawImage(back, 0, 0, 2700, 790, this);

        crashedBird(g);
        birdMove();
        GamePresenter.usualBirdAction();
        drawBird(g);
    }

}
