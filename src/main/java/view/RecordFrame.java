package view;

import javax.swing.*;
import java.awt.*;

public class RecordFrame extends JFrame {
    private static final String[] columnNames = {"Name", "Score"};
    JFrame frameTable = new JFrame("Table of record");

    public void tableGame(String[][] data, int panelWidth, int panelHeight) {
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        frameTable.getContentPane().add(scrollPane);
        frameTable.setPreferredSize(new Dimension(panelWidth, panelHeight));
        frameTable.pack();
        frameTable.setLocationRelativeTo(null);
        frameTable.setVisible(true);
    }

}
