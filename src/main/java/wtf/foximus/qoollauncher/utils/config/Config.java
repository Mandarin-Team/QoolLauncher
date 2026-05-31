package wtf.foximus.qoollauncher.utils.config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Config {

    private static final Path CONFIG_PATH = Paths.get("C:\\QoolLauncher\\launcher\\config.properties");
    private static Properties props = new Properties();

    public static void configCreate() throws IOException {
        if (!Files.exists(CONFIG_PATH)) {
            props.setProperty("version", "1.0.0");
            props.setProperty("memorry", "2048");
            props.setProperty("auto_auth", "false");

            try (BufferedWriter writer = Files.newBufferedWriter(CONFIG_PATH)) {
                props.store(writer, "QoolLauncher Configuration File");
            }
        }
    }

    public static String get(String key) throws IOException{
        if (props.isEmpty() && Files.exists(CONFIG_PATH)){
            try (BufferedReader reader = Files.newBufferedReader(CONFIG_PATH)){
                props.load(reader);
            }
        }
        return props.getProperty(key);
    }

    public static void set(String key, String value)throws IOException{
        props.setProperty(key, value);

        try (BufferedWriter writer = Files.newBufferedWriter(CONFIG_PATH)){
            props.store(writer, null);
        }
    }

}
