package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {

    public static String getProperty(String filePath,String property) {
        Properties properties = new Properties();
        String propertyValue = "";

        try (InputStream input = new FileInputStream(new File(filePath))) {
            // Load properties file
            properties.load(input);

            // Access properties
            propertyValue = properties.getProperty(property);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return propertyValue;
    }

}
