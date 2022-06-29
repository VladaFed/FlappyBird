package view;

import javax.swing.*;
import java.awt.*;

public class RecordFrame extends JFrame {
    private static final String[] columnNames = {"Name", "Score"};

    public void tableGame(String[][] data, int panelWidth, int panelHeight) {
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        this.getContentPane().add(scrollPane);
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
