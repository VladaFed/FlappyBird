package view;

import javax.swing.*;
import java.awt.*;

public class RecordPanel extends JFrame {
    JFrame frameTable = new JFrame("Table of record");

    public RecordPanel() {}

    public void tableGame(String[][] data, String[] columnNames) {
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        frameTable.getContentPane().add(scrollPane);
        frameTable.setPreferredSize(new Dimension(450, 200));
        frameTable.pack();
        frameTable.setLocationRelativeTo(null);
        frameTable.setVisible(true);
    }


}
