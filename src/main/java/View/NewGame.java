package View;

import Controller.GamePresenter;
import Model.Pipe;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

public class NewGame extends JPanel implements MouseListener {
    public int lastRecord;
    private Image back;
    private Image bird;
    private Image pipe1;
    private Image pipe2;

    public ArrayList<Pipe> pipes;
    //public Bird b;

    public String name;
    private Point clickPoint;

    GamePresenter gamePresenter = new GamePresenter();
    MainFrame mainFrame;

    public void mousePressed(MouseEvent e) {
        //System.out.println("mousePressed");
        clickPoint = e.getPoint();
        gamePresenter.updateClick();
    }

    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public void startGame() {
        pipes = gamePresenter.startGame();
        /*b = new Bird();
        pipes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            //Pipe tmpPipe = new Pipe(900 + 300*i);
            //pipes.add(i, new Pipe(1400 + 600*i));
            pipes.add(i, new Pipe(1400 + 600*i));
        }*/

    }

    public void pip(Graphics g) {
        for (Pipe p : pipes) {
            lastRecord = p.birdRecord();
            if (gamePresenter.birdExists()) {
                p.pipeMove();
            }

            int coord = (int)p.XPipe();

            g.drawImage(pipe1, coord, p.YBottomPipe(), 70, 1000, this);
            g.drawImage(pipe2, coord, p.YTopPipe(), 70, 1000, this);

            if (gamePresenter.birdExists()) {
                if (!p.collisions(gamePresenter.BirdCoordX(), gamePresenter.BirdCoordY())) {
                    gamePresenter.birdDeath();
                    gamePresenter.birdFall();
                    name = mainFrame.PlayerName();
                    gamePresenter.addName(name, lastRecord);
                    //System.out.println("record - " + lastRecord);
                    //System.out.println("score - " + score);
                    //restart();
                    //new Box();
                }
            }
        }
    }

    public void drawBird(Graphics g) {
        int x = 300;
        int y = gamePresenter.BirdCoordY();
        g.drawImage(bird, x, y, 70, 70, this);
    }

    public void paintComponent (Graphics g) {
        startGame();
        bird = new ImageIcon("src/main/java/Pictures/bird7.png").getImage();
        back = new ImageIcon("src/main/java/Pictures/back7.png").getImage();
        pipe1 = new ImageIcon("src/main/java/Pictures/pipe.png").getImage();
        pipe2 = new ImageIcon("src/main/java/Pictures/pipe2.png").getImage();

        g.drawImage(back, 0, 0, 2700, 790, this);

        pip(g);
        gamePresenter.birdDown();
        drawBird(g);
        //b.flyDown();
        //b.draw(g);
    }

}
