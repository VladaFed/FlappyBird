package model;

import controller.GameObject;
import main.GameConfiguration;

import java.util.ArrayList;
import java.util.List;


public class GameModel {
    private List<Pipe> pipes;
    private int score = 0;
    private TableRecord tableRecord = new TableRecord();
    private boolean gameOver = false;
    private GameConfiguration config;
    private Bird bird = new Bird();

    public GameModel(GameConfiguration config) {
        this.config = config;
        bird.settingsBird(config.bird_startX, config.speedBird, config.G);
        Pipe settingsPipe = new Pipe(config.pipe_height, config.distance_height_pipes, config.min_location_pipe, config.max_location_pipe);
        pipes = new ArrayList<>();
        for (int i = 0; i < config.pipe_num; i++) {
            pipes.add(i, new Pipe(config.pipe_startX + config.distance_width_pipes*i));
        }
    }

    public Bird getBird(){
        return bird;
    }

    public boolean birdInsideField(int y){
        return y < config.field_height && y > 0;
    }

    public void setGameOver(){
        gameOver = true;
    }

    public void birdFlyDown() {
        bird.flyDown();
        if(!birdInsideField(bird.coordY())){
            setGameOver();
        }
    }

    public void birdFlyUp() {
        bird.flyUp();
        if(!birdInsideField(bird.coordY())){
            setGameOver();
        }
    }

    public void birdFlyRight() {
        bird.moveX();
    }

    List<GameObject> gameObjects() {
        GameObject.BirdModel birdModel = new GameObject.BirdModel(bird.coordX(), bird.coordY());
        List<GameObject> models = new ArrayList<>();
        models.add(birdModel);
        for (int i = 1; i <= pipes.size(); i++) {
            Pipe current  = pipes.get(i - 1);
            models.add(i, new GameObject.PipeModel(current.x(), current.yBottom(), current.yTop()));
        }
        return models;
    }

    public int getCurrentScore() {
        return score;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    private void updateState(){
        for (Pipe p : pipes) {
            if (((p.yBottom() - bird.coordY() < config.bird_height) &&
                    Math.abs(p.x() - (bird.coordX() + config.bird_startX)) < config.bird_width)
                    || ((p.yBottom() - config.distance_height_pipes > bird.coordY()) &&
                    Math.abs(p.x() - (bird.coordX() + config.bird_startX)) < config.bird_width)) {
                setGameOver();
            } else if (bird.coordX() + config.bird_startX  > config.pipe_startX +
                    config.pipe_num * config.distance_width_pipes) {
                setGameOver();
            } else if (p.x() - (bird.coordX() + config.bird_startX) < config.bird_width){
                if (!p.IsPassed()) {
                    addScore();
                }
                p.setPassed();
            }
        }
    }

    private void addScore() {
        ++score;
    }

    public List<GameObject> move() {
        updateState();
        return gameObjects();
    }

    public boolean birdExists() {
        return bird.exists();
    }
}
