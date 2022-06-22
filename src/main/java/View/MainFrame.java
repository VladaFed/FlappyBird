package View;

import Controller.GamePresenter;
import Model.GameConfiguration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainFrame extends JFrame implements ActionListener {
    private JLabel titleL, nameL, markL;
    private JButton registrationB, aboutB, exitB, recordB, startGameB, doneB;
    public JTextField nameT = new JTextField(15);
    public String name;

    RecordPanel recordPanel = new RecordPanel();
    GamePresenter gamePresenter = new GamePresenter();

    JFrame frame1 = new JFrame("Menu");
    JFrame frame2 = new JFrame("Registration");
    //JFrame frameTable = new JFrame("Table of record");


    public MainFrame(GameConfiguration gameConfiguration) {
        frame1.setSize(gameConfiguration.menu_height, gameConfiguration.menu_width);

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


        //registrationB.addActionListener(this);
        //aboutB.addActionListener(this);
        //recordB.addActionListener(this);
        //exitB.addActionListener(this);

        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        frame1.setResizable(false);

    }

    public void panelStart() {
        String nameGame = "a";
        frame2.setSize(400, 200);

        Container nameP = frame2.getContentPane();
        nameP.setLayout(null);

        nameL = new JLabel("Registration");
        markL = new JLabel("Enter name: ");
        startGameB = new JButton("Start");
        doneB = new JButton("Done");
        //nameT = new JTextField(15);
        //nameT.setActionCommand("myTF");

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
                GamePresenter.newGame();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        nameP.add(nameT);
        nameT.setBounds(120, 87, 140, 20);
        nameT.addActionListener(this);

        nameP.add(doneB);
        doneB.setBounds(260, 87, 70, 20);
        doneB.addActionListener(this);
        //doneB.addActionListener(event -> name = nameT.getText());
        //System.out.println("NameDoneBoxView - " + name);

        //startGameB.addActionListener(this);
        //nameT.addActionListener(this);

        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
        frame2.setResizable(false);
    }

    public void printAbout() {
        AboutPanel aboutPanel = new AboutPanel();
        //while (true)
        //aboutPanel.repaint();
    }

    public void tableGame() {
        gamePresenter.tableGameController();
        //recordPanel.tableGame();
    }

    public String PlayerName() {
        return name;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String key = e.getActionCommand();
        if (key.equals("Done")) {
            name = nameT.getText();
            //System.out.println("NameDoneBoxView - " + name);
        }
    }
}
