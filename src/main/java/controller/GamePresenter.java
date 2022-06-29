package controller;

import main.GameConfigurationMenu;
import main.TableRecord;
import model.*;
import main.Record;
import view.*;
import main.GameConfiguration;
import view.GameFrame;

import java.io.IOException;
import java.util.List;

public class GamePresenter {

    private String gamerName;
    private final RecordFrame recordFrame = new RecordFrame();
    GameFrame view;
    GameConfiguration config;
    GameConfigurationMenu configMenu;

    private static Field field;

    public GamePresenter(GameConfiguration gameConfiguration, GameConfigurationMenu gameConfigurationMenu) throws IOException {
        this.config = gameConfiguration;
        this.configMenu = gameConfigurationMenu;
        field = new Field(gameConfiguration, gameConfigurationMenu);
        view = new GameFrame(gameConfiguration, gameConfigurationMenu, this);
    }

    public void update(){
        List<GameObject> gameObjects = field.move();
        if (gameObjects == null) {
            view.gameOver();
            addName(gamerName, field.getCurrentScore());
            timer.cancel();
        }
        else {
            view.setGameState(gameObjects);
        }
//        if (view != null){
//            if (field.isGameOver()) {
//                view.gameOver();
//                addName(gamerName, field.getCurrentScore());
//                timer.cancel();
//                return;
//            }
//            view.setGameState(gameObjects);
    }

//    public void tableGameController() {
//        List<Record> records = TableRecord.getInstance().getRecords();
//        String[][] data = records.stream().map(record -> new String[] {record.name(),
//                String.valueOf(record.score())}).toArray(String[][]::new);
//        recordFrame.tableGame(data, configMenu.recordPanelWidth, configMenu.recordPanelHeight);
//    }

    public void addName(String name, int score) {
        TableRecord.getInstance().addRecord(name, score);
    }

    public void newGame(String name) throws IOException {
        gamerName = name;
    }

//    public int birdCoordX() {
//        return field.getBird().birdXCoordinate();
//    }

//    public void gameOver() {
//        addName(gamerName, field.getCurrentScore());
//        recordFrame.getContentPane();
//    }

    public void updateClick() {
        field.birdFlyUp();
//        List<GameObject> gameObjects = field.move();
//        if (gameObjects == null) {
//            view.gameOver();
//            addName(gamerName, field.getCurrentScore());
//            timer.cancel();
//        }
//        else {
//            view.setGameState(gameObjects);
//        }
//        if (view != null){
//            if (field.isGameOver()) {
//                view.gameOver();
//                addName(gamerName, field.getCurrentScore());
//                timer.cancel();
//                return;
//            }
//            view.setGameState(gameObjects);
    }

//    public void usualBirdAction() {
//       field.birdFlyDown();
//       field.birdFlyRight();
//    }
}
