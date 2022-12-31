package game.utils;

import javafx.scene.control.Alert;

// Warning message
public class AlertUtil {
    public static void alertMsg(String title,String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);

        alert.showAndWait();
    }
}
