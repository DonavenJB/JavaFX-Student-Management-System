package studentmanagement.ui.common;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;

public final class FormUtils {

    private FormUtils() {
    }

    public static void clearFields(TextField... fields) {
        clearTextInputs(fields);
    }

    public static void clearTextInputs(TextInputControl... controls) {
        for (TextInputControl control : controls) {
            if (control != null) {
                control.clear();
            }
        }
    }

    public static void resetComboBoxes(ComboBox<?>... comboBoxes) {
        for (ComboBox<?> comboBox : comboBoxes) {
            if (comboBox != null) {
                comboBox.getSelectionModel().clearSelection();
                comboBox.setValue(null);
            }
        }
    }

    public static void setEditable(boolean editable, TextInputControl... controls) {
        for (TextInputControl control : controls) {
            if (control != null) {
                control.setEditable(editable);
            }
        }
    }

    public static void setDisabled(boolean disabled, Control... controls) {
        for (Control control : controls) {
            if (control != null) {
                control.setDisable(disabled);
            }
        }
    }
}
