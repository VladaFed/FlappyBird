package View;

import Model.Window;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Box extends JFrame implements ActionListener {
    private JLabel titleL, nameL, markL;
    private JButton startB, aboutB, exitB, recordB, startGameB;
    private JTextField nameT;

    private RecordPanel recordTable;

    JFrame frame1 = new JFrame("Menu");
    JFrame frame2 = new JFrame("Registration");

    public Box() {
        frame1.setSize(500, 250);

        Container mainP = frame1.getContentPane();
        mainP.setLayout(null);

        titleL = new JLabel("Flappy Bird");
        startB = new JButton("Registration");
        aboutB = new JButton("About");
        recordB = new JButton("Table of record");
        exitB = new JButton("Exit");


        mainP.add(titleL);
        titleL.setFont(new Font("Chiller", Font.ITALIC, 50));
        titleL.setBounds(150, 30, 200, 50);

        mainP.add(startB);
        startB.setBounds(180, 90, 140, 20);

        mainP.add(aboutB);
        aboutB.setBounds(180, 110, 140, 20);

        mainP.add(recordB);
        recordB.setBounds(180, 130, 140, 20);

        mainP.add(exitB);
        exitB.setBounds(180, 150, 140, 20);


        startB.addActionListener(this);
        aboutB.addActionListener(this);
        recordB.addActionListener(this);
        exitB.addActionListener(this);

        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        frame1.setResizable(false);

    }

    public void playerName() {
        frame2.setSize(400, 200);

        Container nameP = frame2.getContentPane();
        nameP.setLayout(null);

        nameL = new JLabel("Registration");
        markL = new JLabel("Enter name: ");
        startGameB = new JButton("Start");
        nameT = new JTextField(15);
        //nameT.setActionCommand("myTF");

        nameP.add(nameL);
        nameL.setFont(new Font("Chiller", Font.ITALIC, 50));
        nameL.setBounds(100, 30, 200, 50);

        nameP.add(markL);
        markL.setFont(new Font("Chiller", Font.ITALIC, 20));
        markL.setBounds(30, 70, 200, 50);

        nameP.add(startGameB);
        startGameB.setBounds(120, 110, 140, 20);

        nameP.add(nameT);
        nameT.setBounds(120, 87, 140, 20);

        startGameB.addActionListener(this);
        nameT.addActionListener(this);

        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
        frame2.setResizable(false);
    }


    public void actionPerformed(ActionEvent e) {
        String key = e.getActionCommand();
        String nameRes = null;
        if (key.equals("Registration")) {
            frame1.dispose();
            playerName();

            String name = nameT.getText();
            System.out.println("Name1 - " + name);
            nameRes = "";
            for (int i = name.length() - 1; i >= 0; i--)
                nameRes += name.charAt(i);
            System.out.println("Name2 - " + nameRes);
            nameT.setText(nameRes);
            //new Main();
            /*try {
                new Window();
            } catch (IOException ex) {
                ex.printStackTrace();
            }*/
        } else if (key.equals("Start")) {
            //recordTable.addTable(nameRes);
            try {
                new Window();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (key == "About") {

        } else if (key == "Table of record") {

        } else
            System.exit(0);
    }
}
