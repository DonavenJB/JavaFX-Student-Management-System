package studentmanagement.ui.shell;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import studentmanagement.app.AppContext;
import studentmanagement.ui.shell.MainMenuFactory.MenuBundle;

public final class MainMenuController {

    private MainMenuController() {
    }

    public static void bind(Stage primaryStage,
                            BorderPane borderPane,
                            AppContext appContext,
                            MenuBundle menuBundle) {
        bindStudentActions(borderPane, menuBundle);
        bindDepartmentActions(borderPane, menuBundle);
        bindInstructorActions(borderPane, menuBundle);
        bindCourseActions(borderPane, menuBundle);
        bindEnrollmentActions(borderPane, menuBundle);
        bindReportActions(borderPane, menuBundle);

        menuBundle.getExitProgram().setOnAction(e -> primaryStage.close());
    }

    private static void bindStudentActions(BorderPane borderPane, MenuBundle menuBundle) {
        menuBundle.getAddStudent().setOnAction(e -> borderPane.setCenter(createPlaceholderLabel("Student create workflow coming soon.")));
        menuBundle.getEditStudent().setOnAction(e -> borderPane.setCenter(createPlaceholderLabel("Student edit workflow coming soon.")));
        menuBundle.getDisplayStudent().setOnAction(e -> borderPane.setCenter(createPlaceholderLabel("Student display workflow coming soon.")));
    }

    private static void bindDepartmentActions(BorderPane borderPane, MenuBundle menuBundle) {
        menuBundle.getAddDepartment().setOnAction(e -> borderPane.setCenter(createPlaceholderLabel("Department create workflow coming soon.")));
        menuBundle.getEditDepartment().setOnAction(e -> borderPane.setCenter(createPlaceholderLabel("Department edit workflow coming soon.")));
        menuBundle.getDisplayDepartment().setOnAction(e -> borderPane.setCenter(createPlaceholderLabel("Department display workflow coming soon.")));
    }

    private static void bindInstructorActions(BorderPane borderPane, MenuBundle menuBundle) {
        menuBundle.getAddInstructor().setOnAction(e -> borderPane.setCenter(createPlaceholderLabel("Instructor create workflow coming soon.")));
        menuBundle.getEditInstructor().setOnAction(e -> borderPane.setCenter(createPlaceholderLabel("Instructor edit workflow coming soon.")));
        menuBundle.getDisplayInstructor().setOnAction(e -> borderPane.setCenter(createPlaceholderLabel("Instructor display workflow coming soon.")));
    }

    private static void bindCourseActions(BorderPane borderPane, MenuBundle menuBundle) {
        menuBundle.getAddCourse().setOnAction(e -> borderPane.setCenter(createPlaceholderLabel("Course create workflow coming soon.")));
        menuBundle.getEditCourse().setOnAction(e -> borderPane.setCenter(createPlaceholderLabel("Course edit workflow coming soon.")));
        menuBundle.getDisplayCourse().setOnAction(e -> borderPane.setCenter(createPlaceholderLabel("Course display workflow coming soon.")));
    }

    private static void bindEnrollmentActions(BorderPane borderPane, MenuBundle menuBundle) {
        menuBundle.getAddEnrollment().setOnAction(e -> borderPane.setCenter(createPlaceholderLabel("Enrollment create workflow coming soon.")));
        menuBundle.getEditEnrollment().setOnAction(e -> borderPane.setCenter(createPlaceholderLabel("Enrollment edit workflow coming soon.")));
        menuBundle.getDisplayEnrollment().setOnAction(e -> borderPane.setCenter(createPlaceholderLabel("Enrollment display workflow coming soon.")));
    }

    private static void bindReportActions(BorderPane borderPane, MenuBundle menuBundle) {
        menuBundle.getCourseReport().setOnAction(e -> borderPane.setCenter(createPlaceholderLabel("Course report workflow coming soon.")));
        menuBundle.getStudentReport().setOnAction(e -> borderPane.setCenter(createPlaceholderLabel("Student report workflow coming soon.")));
        menuBundle.getExceptionReport().setOnAction(e -> borderPane.setCenter(createPlaceholderLabel("Exception report workflow coming soon.")));
    }

    private static Label createPlaceholderLabel(String text) {
        Label label = new Label(text);
        label.setWrapText(true);
        return label;
    }
}
