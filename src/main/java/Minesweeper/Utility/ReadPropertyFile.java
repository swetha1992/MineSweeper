package Minesweeper.Utility;

import java.io.FileInputStream;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * reads property file constants.properties.
 */
 public class ReadPropertyFile {
    public static String getProperty(String property){
        String propertyValue = "";
        try {
            FileInputStream file = new FileInputStream("src\\main\\resources\\constants.properties");
            ResourceBundle resourceBundle = new PropertyResourceBundle(file);
            propertyValue = resourceBundle.getString(property);
        }catch (Exception e){
            e.printStackTrace();
        }
        return propertyValue;
    }
}
