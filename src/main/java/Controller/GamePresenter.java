package Controller;

import Model.*;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GamePresenter { ;
    static GameConfiguration gameConfiguration;

    TableRecord tableRecord = new TableRecord();
    RecordPanel recordPanel = new RecordPanel();
    //TableRecord tableRecord;
    //RecordPanel recordPanel;
    //static FieldPanel fieldPanel = new FieldPanel(gameConfiguration);
    NewGame newGame;
    Bird bird = new Bird();
    public ArrayList<Pipe> pipes;
    //Pipe pipe1;

    public GamePresenter() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                handleTimer();
            }
        };
        timer.schedule(timerTask, 0, 500);
    }

    public void tableGameController() {
        tableRecord.tableGame();
        String[][] data = tableRecord.NamesRecords();
        String[] column = tableRecord.columnNames();
        recordPanel.tableGame(data, column);
    }

    public void addName(String name, int score) {
        tableRecord.addTable(name, score);
    }

    public static void newGame() throws IOException {
        Window window = new Window();
    }

    public ArrayList<Pipe> startGame() {
        //bird = new Bird();
        pipes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            //Pipe tmpPipe = new Pipe(900 + 300*i);
            //pipes.add(i, new Pipe(1400 + 600*i));
            pipes.add(i, new Pipe(1400 + 600*i));
        }
        return pipes;
        //newGame.repaint();
    }

    public double birdDown() {
        return bird.flyDown();
    }

    public double birdFall() {
        return bird.fall();
    }

    public boolean birdExists() {
        return bird.exists();
    }

    public int BirdCoordX() {
        return bird.coordX();
    }

    public int BirdCoordY() {
        return bird.coordY();
    }

    public boolean birdDeath() {
        return bird.death();
    }

    public double updateClick() {
        //fieldPanel.setField();
        if (bird.exists()) {
            return bird.flyUp();
        }
        //newGame.repaint();
        return 0;
    }

    public void handleTimer() {
        bird.flyDown();
        //field.update();
        //frame.repaint();
        //if (hasEnded()) {
          //  timer.stop();
          //  frame.end();
        //}
    }

}
