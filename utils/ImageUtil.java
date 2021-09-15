package game.utils;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImageUtil {


    public static Image getImage(String filepath) {
        try {
            FileInputStream inputStream = new FileInputStream(filepath);
            return new Image(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
