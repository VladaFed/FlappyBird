import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Box extends JFrame implements ActionListener {
    private JLabel titleL;
    private JButton startB, aboutB, exitB;

    static JFrame frame1 = new JFrame("Menu");

    public Box() {
        frame1.setSize(500, 250);
        Container mainP = frame1.getContentPane();
        mainP.setLayout(null);

        titleL = new JLabel("Flappy Bird");
        startB = new JButton("Start");
        aboutB = new JButton("About");
        exitB = new JButton("Exit");

        mainP.add(titleL);
        titleL.setFont(new Font("Chiller", Font.ITALIC, 50));
        titleL.setBounds(150, 30, 200, 50);

        mainP.add(startB);
        startB.setBounds(200, 80, 100, 20);

        mainP.add(aboutB);
        aboutB.setBounds(200, 100, 100, 20);

        mainP.add(exitB);
        exitB.setBounds(200, 120, 100, 20);

        startB.addActionListener(this);
        aboutB.addActionListener(this);
        exitB.addActionListener(this);

        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        frame1.setResizable(false);

    }


    public void actionPerformed(ActionEvent e) {
        String key = e.getActionCommand();
        if (key == "Start") {
            frame1.dispose();
            try {
                new Window();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (key == "About") {

        } else
            System.exit(0);
    }
}
