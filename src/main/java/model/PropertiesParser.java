package model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesParser {
    private final Properties properties;

    public PropertiesParser(String filename) throws IOException {
        properties = new Properties();
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(filename);
        properties.load(stream);
    }

    private String getString(String key) {
        return properties.get(key).toString();
    }

    public int getInteger(String key) {
        return Integer.parseInt(getString(key));
    }


}
