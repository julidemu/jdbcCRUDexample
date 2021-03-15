package az.mega.testdb.config;

import az.mega.testdb.model.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class DatabaseConfig {

    public static Configuration read(String file){
        Configuration configuration = new Configuration();
        try {
            Properties properties = new Properties();
            properties.load(Files.newInputStream(Path.of(file)));

            configuration.setUrl(properties.getProperty("jdbc.url"));
            configuration.setUsername(properties.getProperty("jdbc.username"));
            configuration.setPassword(properties.getProperty("jdbc.password"));

        } catch (IOException e) {
            e.printStackTrace();
        }


        return configuration;
    }
}
