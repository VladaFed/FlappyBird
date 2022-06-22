package Model;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TableRecord {

    private static final List<Note> table = new ArrayList<>();

    public String[] columnNames;
    public String[][] array;

    public TableRecord() {
        tableGame();
    }

    public static void addTable(String namePlayer, int score) {
        boolean nameExists = false;
        for (int i = 0; i < table.size(); i++) {
            Note note = table.get(i);
            if (note.name().equals(namePlayer)) {
                nameExists = true;
                if (note.score() >= score)
                    break;
                table.remove(i);
                table.add(new Note(namePlayer, score));
                break;
            }
            //System.out.println("NameLL - " + note.name());
        }
        if (!nameExists)
            table.add(new Note(namePlayer, score));


        try{
            FileWriter writer = new FileWriter("src/main/java/HighScores");
            for (Note line : table) {
                writer.write(line.name() + " " + line.score() + System.getProperty("line.separator"));
            }
            writer.close();
        } catch (IOException ex){ex.printStackTrace();}
    }

    public void tableGame() {
        columnNames = new String[]{
                "Name",
                "Score"
        };

        String filepath = "src/main/java/HighScore";
        Scanner scannMatrix = null;
        ArrayList<ArrayList> Matrix = new ArrayList<ArrayList>();
        try{
            scannMatrix = new Scanner(new File(filepath));
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Noo");
        }

        while(scannMatrix.hasNextLine()){
            Scanner scanLine = new Scanner(scannMatrix.nextLine());
            ArrayList<String> line = new ArrayList<String>();
            while(scanLine.hasNext()){
                line.add(new String(scanLine.next()));
            }
            Matrix.add(line);
        }

        int arrWidth = Matrix.size();
        int arrLength = Matrix.get(0).size();
        array = new String[arrWidth][arrLength];
        for(int y = 0; y < Matrix.size(); y++){
            for(int x = 0; x < Matrix.get(y).size(); x++){
                array[y][x] = (String)Matrix.get(y).get(x);
            }
        }
    }

    public String[] columnNames() {
        return columnNames;
    }

    public String[][] NamesRecords() {
        return array;
    }

    public record Note(String name, Integer score) {
        public String toString() {
            return name + " " + score;
        }
    }
}
