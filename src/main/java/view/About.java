package view;

import javax.swing.*;
import java.awt.*;

public class About extends JPanel {
    public void paintComponent (Graphics g) {
        Image image = new ImageIcon("src/main/resources/pictures/about.png").getImage();
        g.drawImage(image, 0, 0, this);
    }
}

