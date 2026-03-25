package studentmanagement.ui.common;

import javafx.scene.control.Alert;

public final class AlertUtils {

 private AlertUtils() {

 }

 public static void showAlert(Alert.AlertType alertType, String title, String message) {

 Alert alert = new Alert(alertType);

 alert.setContentText(message);

 alert.setTitle(title);

 alert.setHeaderText(null);

 alert.showAndWait();

 }

 public static void showError(String title, String message) {

 showAlert(Alert.AlertType.ERROR, title, message);

 }

 public static void showInfo(String title, String message) {

 showAlert(Alert.AlertType.INFORMATION, title, message);

 }

}
