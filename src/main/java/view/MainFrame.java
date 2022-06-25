package view;

import controller.GamePresenter;
import main.GameConfiguration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainFrame extends JFrame implements ActionListener {
    private JLabel titleL, nameL, markL;
    private JButton registrationB, aboutB, exitB, recordB, startGameB;
    public JTextField nameT = new JTextField(15);
    public String name;
    private final GameConfiguration gameConfiguration;

    GamePresenter gamePresenter;

    JFrame frame1 = new JFrame("Menu");
    JFrame frame2 = new JFrame("Registration");


    public MainFrame(GameConfiguration gConfiguration) {
        super("FlappyBird");
        gameConfiguration = gConfiguration;
        frame1.setSize(gameConfiguration.menu_height, gameConfiguration.menu_width);
        frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container mainP = frame1.getContentPane();
        mainP.setLayout(null);

        titleL = new JLabel("Flappy Bird");
        registrationB = new JButton("Registration");
        aboutB = new JButton("About");
        recordB = new JButton("Table of record");
        exitB = new JButton("Exit");


        mainP.add(titleL);
        titleL.setFont(new Font("Chiller", Font.ITALIC, 50));
        titleL.setBounds(150, 30, 200, 50);

        mainP.add(registrationB);
        registrationB.setBounds(180, 90, 140, 20);
        registrationB.addActionListener(event -> panelStart());

        mainP.add(aboutB);
        aboutB.setBounds(180, 110, 140, 20);
        aboutB.addActionListener(event -> printAbout());

        mainP.add(recordB);
        recordB.setBounds(180, 130, 140, 20);
        recordB.addActionListener(event -> tableGame());

        mainP.add(exitB);
        exitB.setBounds(180, 150, 140, 20);
        exitB.addActionListener(event -> System.exit(0));

        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        frame1.setResizable(false);

    }

    public void panelStart() {
        frame2.setSize(400, 200);
        frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container nameP = frame2.getContentPane();
        nameP.setLayout(null);

        nameL = new JLabel("Registration");
        markL = new JLabel("Enter name: ");
        startGameB = new JButton("Start");

        nameP.add(nameL);
        nameL.setFont(new Font("Chiller", Font.ITALIC, 50));
        nameL.setBounds(100, 30, 200, 50);

        nameP.add(markL);
        markL.setFont(new Font("Chiller", Font.ITALIC, 20));
        markL.setBounds(30, 70, 200, 50);

        nameP.add(startGameB);
        startGameB.setBounds(120, 110, 140, 20);
        startGameB.addActionListener(event -> {
            try {
                frame2.dispose();
                name = nameT.getText();
                gamePresenter = new GamePresenter(gameConfiguration);
                gamePresenter.newGame(name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        nameP.add(nameT);
        nameT.setBounds(120, 87, 140, 20);
        nameT.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
        frame2.setResizable(false);
    }

    public void printAbout() {
        // CR: make the same way as records / registation
        AboutPanel aboutPanel = new AboutPanel();
        //aboutPanel.repaint();
    }

    public void tableGame() {
        if (gamePresenter != null){
            gamePresenter.tableGameController();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
}
