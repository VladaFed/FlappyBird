package controller;

import model.*;
import view.*;
import main.GameConfiguration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GamePresenter {
   
    static GameConfiguration gameConfiguration;

    private String gamerName;

    private Window win;
    private RecordPanel recordPanel = new RecordPanel();
    ArrayList<PipeView> pipesView = new ArrayList<>();

    private static Game game;

    public GamePresenter(GameConfiguration gameConfiguration) throws IOException {
        game = new Game(gameConfiguration);
        ArrayList<Pipe> pipes = game.getPipes();

        for (Pipe p : pipes) {
            pipesView.add(new PipeView(p.XPipe(), p.YBottomPipe(), p.YTopPipe(), p.isPassed()));
        }

        win = new Window(gameConfiguration, this);
    }

    private static void handleGameTimer(int period){
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                usualBirdAction();
            }
        };
        timer.schedule(timerTask, 0, period);
    }

    public void tableGameController() {
        game.getRecord().tableGame();
        String[][] data = game.getRecord().NamesRecords();
        String[] column = game.getRecord().columnNames();
        recordPanel.tableGame(data, column);
    }

    public void addName(String name, int score) {
        TableRecord.addTable(name, score);
    }

    public void newGame(String name) throws IOException {
        System.out.println(name);
        gamerName = name;
        handleGameTimer(100);
    }

    public int BirdCoordX() {
        return game.getBird().coordX();
    }

    public int BirdCoordY() {
        return game.getBird().coordY();
    }

    public boolean birdDeath() {
        addName(gamerName, game.getCurrentScore());
        recordPanel.getContentPane();
        return game.getBird().death();
    }

    public void updateClick() {
        if (game.getBird().exists()) {
            game.getBird().flyUp();
        }
    }

    public static void usualBirdAction() {
       game.birdFlyDown();
    }

    public void birdMoveX() {
        game.getBird().moveX();
    }

    public ArrayList<PipeView> getPipes() {
            return pipesView;
    }

    public void updateScore() {
        int score = 0;
        for (PipeView p : pipesView) {
            if (p.IsPassed()){
                ++score;
            }
        }
        game.updateScore(score);
    }
}
