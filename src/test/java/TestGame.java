import main.GameConfiguration;
import model.Field;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class TestGame {
    int PIPE_WIDTH = 70;
    int PIPE_STARTX = 1400;

    @Test
    public void gameConfigurationParserTest() throws IOException {
        GameConfiguration gameConfiguration = new GameConfiguration("config.properties");
        gameConfiguration.readFromProperties();

        assertEquals(PIPE_WIDTH, gameConfiguration.pipe_width);
    }

    @Test
    public void gameOverModelTest() throws IOException {
        GameConfiguration gameConfiguration = new GameConfiguration("config.properties");
        gameConfiguration.readFromProperties();

        Field model = new Field(gameConfiguration);

        model.setGameOver();

        assertEquals(true, model.isGameOver());
    }
}
