package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.Properties;

public class PropertiesUtils {

    public static Properties getProperties() throws IOException {

        String result;
        InputStream inputStream = null;
        Properties properties = new Properties();
        try {
            String propFileName = "config.properties";

            inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("Property file '" + propFileName + "' not found in the classpath");
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            if(inputStream != null){
                inputStream.close();
            }
        }

        return properties;
    }
}
