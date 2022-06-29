package model;

import controller.GameObject;
import main.GameConfiguration;
import main.GameConfigurationMenu;

import java.util.ArrayList;
import java.util.List;


public class Field {
    private final List<Pipe> pipes = new ArrayList<>();
    private int score = 0;
    private boolean gameOver = false;
    private final GameConfiguration config;
    private final GameConfigurationMenu configMenu;
    private final Bird bird = new Bird();

    public Field(GameConfiguration config, GameConfigurationMenu configMenu) {
        this.config = config;
        this.configMenu = configMenu;
        // CR: add ctor params
        bird.settingsBird(config.birdStartY, config.birdStartX, config.speedBird, config.G, config.deltaCoordinateY, config.deltaMoveX);
        for (int i = 0; i < config.pipeNum; i++) {
            pipes.add(i, new Pipe(config.pipeStartX + config.distanceWidthPipes *i));
        }
    }

//    public Bird getBird(){
//        return bird;
//    }

    private boolean birdInsideField(int y){
        return y < configMenu.fieldHeight && y > 0;
    }

//    public void setGameOver(){
//        gameOver = true;
//    }

//    private void birdFlyDown() {
//        bird.flyDown();
////        if(!birdInsideField(bird.birdYCoordinate())){
////            setGameOver();
////        }
//    }

    public void birdFlyUp() {
        bird.flyUp();
//        if(!birdInsideField(bird.birdYCoordinate())){
//            setGameOver();
//        }
    }

//    private void birdFlyRight() {
//        bird.moveX();
//    }

    private List<GameObject> gameObjects() {
        GameObject.BirdModel birdModel = new GameObject.BirdModel(bird.birdXCoordinate(), bird.birdYCoordinate());
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

//    public boolean isGameOver() {
//        return gameOver;
//    }

    private boolean birdCrashedByPipes(Pipe p) {
        if (((p.yBottom() - bird.birdYCoordinate() < config.birdHeight) &&
                Math.abs(p.x() - (bird.birdXCoordinate() + config.birdStartX)) < config.birdWidth)
                || ((p.yBottom() - config.distanceHeightPipes > bird.birdYCoordinate()) &&
                Math.abs(p.x() - (bird.birdXCoordinate() + config.birdStartX)) < config.birdWidth))
            return true;
        return false;
    }

    private void addScore() {
        ++score;
    }

    public List<GameObject> move() {
        bird.flyDown();
//        birdFlyRight();
        if(!birdInsideField(bird.birdYCoordinate())){
            return null;
        }
        for (Pipe p : pipes) {
            if (birdCrashedByPipes(p)) {
                return null;
            } else if (bird.birdXCoordinate() + config.birdStartX > config.pipeStartX +
                    config.pipeNum * config.distanceWidthPipes) {
                return null;
            } else if (p.x() - (bird.birdXCoordinate() + config.birdStartX) < config.birdWidth){
                if (!p.isPassed()) {
                    addScore();
                }
                p.setPassed();
            }
        }
        return gameObjects();
    }
}
