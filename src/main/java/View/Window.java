package View;

import Controller.GamePresenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Window extends JFrame implements ActionListener {

    public static JFrame frame = new JFrame();
    GamePresenter gamePresenter;
    NewGame newGame;

    public Window() throws IOException {
        NewGame newGame = new NewGame();
        frame.getContentPane().add(newGame);
        frame.setSize(1000, 800);
        frame.setTitle("bird");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        /*while (true) {
            frame.repaint();
            //frame.revalidate();
        }*/
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //newGame = new NewGame();
        //frame.getContentPane().add(newGame);
        //newGame.revalidate();
        //newGame.repaint();
    }
}
