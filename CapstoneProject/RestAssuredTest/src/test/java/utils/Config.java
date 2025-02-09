package utils;
import java.util.Properties;

public class Config {
    private static Properties props = new Properties();
    public static void load(){
        try {
            props.load(Config.class.getResourceAsStream("/app.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key) {
        return props.getProperty(key);
    }
}
