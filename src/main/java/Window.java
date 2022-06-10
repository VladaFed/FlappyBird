import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Window extends JFrame implements ActionListener {

    BirdPanel birdP;

    public Window() throws IOException {
        initForm();
    }

    public void actionPerformed (ActionEvent e) {
        if (birdP != null)
            birdP.repaint();
    }

    private void initForm() {
        JFrame frame = new JFrame();
        frame.setSize(1000, 800);
        frame.setTitle("bird");

        //new Box();
        birdP = new BirdPanel();
        frame.add(birdP);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        while (true) {
            frame.repaint();
        }
    }



}
