package controller;

import model.*;
import model.Record;
import view.*;
import main.GameConfiguration;
import view.GameFrame;

import java.io.IOException;
import java.util.List;

public class GamePresenter {

    private String gamerName;
    private final RecordFrame recordFrame = new RecordFrame();
    private final GameFrame view;
    GameConfiguration config;

    private static Field field;

    public GamePresenter(GameConfiguration gameConfiguration) throws IOException {
        this.config = gameConfiguration;
        field = new Field(gameConfiguration);
        view = new GameFrame(gameConfiguration, this);
    }

    private void move() {
        List<GameObject> gameObjects = field.move();
        if (field.isGameOver()) {
            view.gameOver();
            return;
        }
        view.setGameState(gameObjects);
    }

    public void update(){
        usualBirdAction();
        move();
    }

    public void tableGameController() {
        List<Record> records = TableRecord.getInstance().getRecords();
        String[][] data = records.stream().map(record -> new String[] {record.name(),
                String.valueOf(record.score())}).toArray(String[][]::new);
        recordFrame.tableGame(data, config.record_panel_width, config.record_panel_height);
    }

    public void addName(String name, int score) {
        TableRecord.getInstance().addRecord(name, score);
    }

    public void newGame(String name) throws IOException {
        gamerName = name;
    }

    public int birdCoordX() {
        return field.getBird().coordX();
    }

    public void gameOver() {
        addName(gamerName, field.getCurrentScore());
        recordFrame.getContentPane();
    }

    public void updateClick() {
        if (field.birdExists()) {
            field.birdFlyUp();
            move();
        } else {
            field.getBird().death();
            gameOver();
        }
    }

    public static void usualBirdAction() {
       field.birdFlyDown();
       field.birdFlyRight();
    }
}
