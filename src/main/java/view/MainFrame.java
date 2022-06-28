package view;

import controller.GamePresenter;
import main.GameConfiguration;
import main.GameConfigurationMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainFrame extends JFrame implements ActionListener {
    private JLabel titleL, nameL, markL, warningL;
    private JButton registrationB, aboutB, exitB, recordB, startGameB;
    public JTextField nameT = new JTextField(15);
    public String name;
    private final GameConfiguration gameConfiguration;
    private final GameConfigurationMenu gameConfigurationMenu;

    GamePresenter gamePresenter;

    JFrame frame1 = new JFrame("Menu");
    JFrame frame2 = new JFrame("Registration");
    JFrame about = new JFrame("About");

    public MainFrame(GameConfigurationMenu gameConfigurationMenu, GameConfiguration gameConfiguration) {
        super("FlappyBird");
        this.gameConfigurationMenu = gameConfigurationMenu;
        this.gameConfiguration = gameConfiguration;
        frame1.setSize(gameConfigurationMenu.menu_width, gameConfigurationMenu.menu_height);
        frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container mainP = frame1.getContentPane();
        mainP.setLayout(null);

        titleL = new JLabel("Flappy Bird");
        warningL = new JLabel("The high score table is available after the first game");
        registrationB = new JButton("Registration");
        aboutB = new JButton("About");
        recordB = new JButton("Table of record");
        exitB = new JButton("Exit");


        mainP.add(titleL);
        titleL.setFont(new Font("Chiller", Font.ITALIC, gameConfigurationMenu.flappy_bird_size));
        titleL.setBounds(gameConfigurationMenu.flappy_bird_x, gameConfigurationMenu.flappy_bird_y,
                gameConfigurationMenu.flappy_bird_width, gameConfigurationMenu.flappy_bird_height);

        mainP.add(warningL);
        warningL.setFont(new Font("Chiller", Font.ITALIC, gameConfigurationMenu.warning_bird_size));
        warningL.setBounds(gameConfigurationMenu.warning_x, gameConfigurationMenu.warning_y,
                gameConfigurationMenu.warning_width, gameConfigurationMenu.warning_height);

        mainP.add(registrationB);
        registrationB.setBounds(gameConfigurationMenu.registration_x, gameConfigurationMenu.registration_y,
                gameConfigurationMenu.registration_width, gameConfigurationMenu.registration_height);
        registrationB.addActionListener(event -> panelStart());

        mainP.add(aboutB);
        aboutB.setBounds(gameConfigurationMenu.about_x, gameConfigurationMenu.about_y,
                gameConfigurationMenu.about_width, gameConfigurationMenu.about_height);
        aboutB.addActionListener(event -> printAbout());

        mainP.add(recordB);
        recordB.setBounds(gameConfigurationMenu.record_x, gameConfigurationMenu.record_y,
                gameConfigurationMenu.record_width, gameConfigurationMenu.record_height);
        recordB.addActionListener(event -> tableGame());

        mainP.add(exitB);
        exitB.setBounds(gameConfigurationMenu.exit_x, gameConfigurationMenu.exit_y,
                gameConfigurationMenu.exit_width, gameConfigurationMenu.exit_height);
        exitB.addActionListener(event -> System.exit(0));

        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        frame1.setResizable(false);

    }

    public void panelStart() {
        frame2.setSize(gameConfigurationMenu.panel_start_width, gameConfigurationMenu.panel_start_height);
        frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container startP = frame2.getContentPane();
        startP.setLayout(null);

        nameL = new JLabel("Registration");
        markL = new JLabel("Enter name: ");
        startGameB = new JButton("Start");

        startP.add(nameL);
        nameL.setFont(new Font("Chiller", Font.ITALIC, gameConfigurationMenu.registration_size));
        nameL.setBounds(gameConfigurationMenu.registration_label_x, gameConfigurationMenu.registration_label_y,
                gameConfigurationMenu.registration_label_width, gameConfigurationMenu.registration_label_height);

        startP.add(markL);
        markL.setFont(new Font("Chiller", Font.ITALIC, gameConfigurationMenu.enter_name_size));
        markL.setBounds(gameConfigurationMenu.enter_name_x, gameConfigurationMenu.enter_name_y,
                gameConfigurationMenu.enter_name_width, gameConfigurationMenu.enter_name_height);

        startP.add(startGameB);
        startGameB.setBounds(gameConfigurationMenu.start_x, gameConfigurationMenu.start_y,
                gameConfigurationMenu.start_width, gameConfigurationMenu.start_height);
        startGameB.addActionListener(event -> {
            try {
                frame2.dispose();
                name = nameT.getText();
                if (name.length() > 15 || !isValid(name)) return;
                gamePresenter = new GamePresenter(gameConfiguration);
                gamePresenter.newGame(name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        startP.add(nameT);
        nameT.setBounds(gameConfigurationMenu.name_x, gameConfigurationMenu.name_y,
                gameConfigurationMenu.name_width, gameConfigurationMenu.name_height);
        nameT.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
        frame2.setResizable(false);
    }

    public void printAbout() {
        About panel = new About();
        about.getContentPane().add(panel);
        about.setSize(gameConfigurationMenu.about_panel_width, gameConfigurationMenu.about_panel_height);
        about.setLocationRelativeTo(null);
        about.setVisible(true);

    }

    private boolean isValid(String name) {
        if(name.length() == 0) return false;
        for(int i = 0; i < name.length(); i++) {
            if(name.charAt(i) == ' ') {
                return false;
            }
        }
        return true;
    }

    public void tableGame() {
        if (gamePresenter != null){
            gamePresenter.tableGameController();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
}
