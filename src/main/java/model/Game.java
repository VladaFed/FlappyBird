package model;

import controller.GameObject;
import main.GameConfiguration;

import java.util.ArrayList;
import java.util.List;


public class Game {
    private Bird bird = new Bird();
    private List<Pipe> pipes;
    private int score = 0;
    private TableRecord tableRecord = new TableRecord();

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

    public List<Pipe> getPipes(){
        return pipes;
    }

    public void birdFlyDown() {
        bird.flyDown();
    }

    List<GameObject> gameObjects() {
        GameObject.BirdModel birdModel = new GameObject.BirdModel(bird.coordX(), bird.coordY());
        // TODO: pipes
//        return List.of(birdModel, )
        return null;
    }

    public int getCurrentScore() {
        return score;
    }

    public void updateScore(int sc) {
        score = sc;
    }

}
