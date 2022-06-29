package view;

import controller.GamePresenter;
import main.GameConfiguration;
import main.GameConfigurationMenu;
import main.Record;
import main.TableRecord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class MainFrame extends JFrame implements ActionListener {
    private JLabel nameGameLabel, nameLabel, markLabel, warningLabel;
    private JButton registrationButton, aboutButton, exitButton, recordButton, startGameButton;
    public JTextField nameTextField = new JTextField(15);
    public String name;
    private final GameConfiguration gameConfiguration;
    private final GameConfigurationMenu gameConfigurationMenu;

    GamePresenter gamePresenter;

    JFrame frameMenu = new JFrame("Menu");
    JFrame frameRegistration = new JFrame("Registration");
    JFrame frameAbout = new JFrame("About");

    public MainFrame(GameConfigurationMenu gameConfigurationMenu, GameConfiguration gameConfiguration) {
        super("FlappyBird");
        this.gameConfigurationMenu = gameConfigurationMenu;
        this.gameConfiguration = gameConfiguration;
        frameMenu.setSize(gameConfigurationMenu.menuWidth, gameConfigurationMenu.menuHeight);
        frameMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container mainPanel = frameMenu.getContentPane();
        mainPanel.setLayout(null);

        nameGameLabel = new JLabel("Flappy Bird");
        warningLabel = new JLabel("The high score table is available after the first game");
        registrationButton = new JButton("Registration");
        aboutButton = new JButton("About");
        recordButton = new JButton("Table of record");
        exitButton = new JButton("Exit");


        mainPanel.add(nameGameLabel);
        nameGameLabel.setFont(new Font("TimesRoman", Font.BOLD, gameConfigurationMenu.flappyBirdSize));
        nameGameLabel.setBounds(gameConfigurationMenu.flappyBirdX, gameConfigurationMenu.flappyBirdY,
                gameConfigurationMenu.flappyBirdWidth, gameConfigurationMenu.flappyBirdHeight);

        mainPanel.add(warningLabel);
        warningLabel.setFont(new Font("TimesRoman", Font.BOLD, gameConfigurationMenu.warningBirdSize));
        warningLabel.setBounds(gameConfigurationMenu.warningX, gameConfigurationMenu.warningY,
                gameConfigurationMenu.warningWidth, gameConfigurationMenu.warningHeight);

        mainPanel.add(registrationButton);
        registrationButton.setBounds(gameConfigurationMenu.registrationX, gameConfigurationMenu.registrationY,
                gameConfigurationMenu.registrationWidth, gameConfigurationMenu.registrationHeight);
        registrationButton.addActionListener(event -> panelStart());

        mainPanel.add(aboutButton);
        aboutButton.setBounds(gameConfigurationMenu.aboutX, gameConfigurationMenu.aboutY,
                gameConfigurationMenu.aboutWidth, gameConfigurationMenu.aboutHeight);
        aboutButton.addActionListener(event -> printAbout());

        mainPanel.add(recordButton);
        recordButton.setBounds(gameConfigurationMenu.recordX, gameConfigurationMenu.recordY,
                gameConfigurationMenu.recordWidth, gameConfigurationMenu.recordHeight);
        recordButton.addActionListener(event -> tableGame());

        mainPanel.add(exitButton);
        exitButton.setBounds(gameConfigurationMenu.exitX, gameConfigurationMenu.exitY,
                gameConfigurationMenu.exitWidth, gameConfigurationMenu.exitHeight);
        exitButton.addActionListener(event -> System.exit(0));

        frameMenu.setLocationRelativeTo(null);
        frameMenu.setVisible(true);
        frameMenu.setResizable(false);

    }

    public void panelStart() {
        frameRegistration.setSize(gameConfigurationMenu.panelStartWidth, gameConfigurationMenu.panelStartHeight);
        frameRegistration.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container startP = frameRegistration.getContentPane();
        startP.setLayout(null);

        nameLabel = new JLabel("Registration");
        markLabel = new JLabel("Enter name: ");
        startGameButton = new JButton("Start");

        startP.add(nameLabel);
        nameLabel.setFont(new Font("TimesRoman", Font.BOLD, gameConfigurationMenu.registrationSize));
        nameLabel.setBounds(gameConfigurationMenu.registrationLabelX, gameConfigurationMenu.registrationLabelY,
                gameConfigurationMenu.registrationLabelWidth, gameConfigurationMenu.registrationLabelHeight);

        startP.add(markLabel);
        markLabel.setFont(new Font("TimesRoman", Font.BOLD, gameConfigurationMenu.enterNameSize));
        markLabel.setBounds(gameConfigurationMenu.enterNameX, gameConfigurationMenu.enterNameY,
                gameConfigurationMenu.enterNameWidth, gameConfigurationMenu.enterNameHeight);

        startP.add(startGameButton);
        startGameButton.setBounds(gameConfigurationMenu.startX, gameConfigurationMenu.startY,
                gameConfigurationMenu.startWidth, gameConfigurationMenu.startHeight);
        startGameButton.addActionListener(event -> {
            try {
                frameRegistration.dispose();
                name = nameTextField.getText();
                if (name.length() > 15 || !isValid(name)) return;
                gamePresenter = new GamePresenter(gameConfiguration, gameConfigurationMenu);
                gamePresenter.newGame(name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        startP.add(nameTextField);
        nameTextField.setBounds(gameConfigurationMenu.nameX, gameConfigurationMenu.nameY,
                gameConfigurationMenu.nameWidth, gameConfigurationMenu.nameHeight);
        nameTextField.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        frameRegistration.setLocationRelativeTo(null);
        frameRegistration.setVisible(true);
        frameRegistration.setResizable(false);
    }

    public void printAbout() {
        About panel = new About();
        frameAbout.getContentPane().add(panel);
        frameAbout.add(panel);
        frameAbout.setSize(gameConfigurationMenu.aboutPanelWidth, gameConfigurationMenu.aboutPanelHeight);
        frameAbout.setLocationRelativeTo(null);
        frameAbout.setVisible(true);

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
        String[][] records = TableRecord.getInstance().getRecords();
        new RecordFrame(records, ???);
//        if (gamePresenter != null){
//            gamePresenter.tableGameController();
//        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
}
