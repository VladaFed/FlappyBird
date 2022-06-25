package view;

import javax.swing.*;

public class AboutPanel extends JFrame {
    JFrame frame = new JFrame("About");

    public AboutPanel() {
        About panel = new About();
        frame.getContentPane().add(panel);
        frame.setSize(830, 467);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}




