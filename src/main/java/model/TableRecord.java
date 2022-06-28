package model;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class TableRecord {

    private static TableRecord INSTANCE;
    private final File file;

    public static TableRecord getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TableRecord();
        }
        return INSTANCE;
    }

    private TableRecord() {
        file = new File("src/main/resources/HighScores");
        try {
            file.createNewFile();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Failed to record the result of the game");
        }
    }

    public List<Record> getRecords() {
        List<Record> records = new ArrayList<>();
        try {
            Scanner scanRecords = new Scanner(file);
            while (scanRecords.hasNextLine()) {
                Scanner scanLine = new Scanner(scanRecords.nextLine());
                String name = scanLine.hasNext() ? scanLine.next() : "Undefined player";
                int score = scanLine.hasNext() ? parseInt(scanLine.next()) : -1;
                records.add(new Record(name, score));
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No");
        }
        return records;
    }

    private void setRecords(List<Record> records) {
        try {
            FileWriter writer = new FileWriter(file);
            for (Record line : records) {
                writer.write(line.name() + " " + line.score() + System.getProperty("line.separator"));
            }
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void addRecord(String namePlayer, int score) {
        //System.out.println(score);
        List<Record> records = getRecords();
        boolean nameExists = false;
        for (int i = 0; i < records.size(); i++) {
            Record record = records.get(i);
            if (record.name().equals(namePlayer)) {
                nameExists = true;
                if (record.score() >= score)
                    break;
                records.remove(i);
                records.add(new Record(namePlayer, score));
                break;
            }
        }
        if (!nameExists) {
            records.add(new Record(namePlayer, score));
        }
        setRecords(records);
    }
}
