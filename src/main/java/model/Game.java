package model;

import main.GameConfiguration;

import java.util.ArrayList;


public class Game {
    private Bird bird = new Bird();
    private ArrayList<Pipe> pipes;
    private TableRecord tableRecord = new TableRecord();
    private int score = 0;

    static GameConfiguration gameConfiguration;

    public Game(GameConfiguration gameConfiguration) {
        pipes = new ArrayList<>();
        for (int i = 0; i < gameConfiguration.pipe_num; i++) {
            pipes.add(i, new Pipe(gameConfiguration.pipe_startX + gameConfiguration.distance_width_pipes*i));
        }
    }

    public Bird getBird(){
        return bird;
    }

    public TableRecord getRecord(){
        return tableRecord;
    }

    public ArrayList<Pipe> getPipes(){
        return pipes;
    }

    public void birdFlyDown() {
        bird.flyDown();
    }

    public int getCurrentScore() {
        return score;
    }

    public void updateScore(int sc) {
        score = sc;
    }

}
