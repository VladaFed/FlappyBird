package controller;

import model.*;
import model.Record;
import view.*;
import main.GameConfiguration;
import view.Window;

import java.io.IOException;
import java.util.List;

public class GamePresenter {

    private String gamerName;
    private final RecordPanel recordPanel = new RecordPanel();
    Window view;
    GameConfiguration config;

    private static GameModel gameModel;

    public GamePresenter(GameConfiguration gameConfiguration) throws IOException {
        this.config = gameConfiguration;
        gameModel = new GameModel(gameConfiguration);
        view = new Window(gameConfiguration, this);
    }

    private void move() {
        List<GameObject> gameObjects = gameModel.move();
        if (view != null){
            if (gameModel.isGameOver()) {
                view.gameOver();
                return;
            }
            view.setGameState(gameObjects);
        }
    }

    public void update(){
        usualBirdAction();
        move();
    }

    public void tableGameController() {
        List<Record> records = TableRecord.getInstance().getRecords();
        String[][] data = records.stream().map(record -> new String[] {record.name(),
                String.valueOf(record.score())}).toArray(String[][]::new);
        recordPanel.tableGame(data, config.record_panel_width, config.record_panel_height);
    }

    public void addName(String name, int score) {
        TableRecord.getInstance().addRecord(name, score);;
    }

    public void newGame(String name) throws IOException {
        gamerName = name;
    }

    public int BirdCoordX() {
        return gameModel.getBird().coordX();
    }

    public void gameOver() {
        addName(gamerName, gameModel.getCurrentScore());
        recordPanel.getContentPane();
    }

    public void updateClick() {
        if (gameModel.birdExists()) {
            gameModel.birdFlyUp();
            move();
        } else {
            gameModel.getBird().death();
            gameOver();
        }
    }

    public static void usualBirdAction() {
       gameModel.birdFlyDown();
       gameModel.birdFlyRight();
    }
}
