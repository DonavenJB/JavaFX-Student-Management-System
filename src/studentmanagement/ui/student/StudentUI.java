package studentmanagement.ui.student;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import studentmanagement.collection.MyGenericList;
import studentmanagement.handler.StudentHandler;
import studentmanagement.model.Student;

public final class StudentUI {

    private StudentUI() {
    }

    public static GridPane createLearner(BorderPane borderPane, MyGenericList<Student> learnerCatalog,
                                         StudentHandler studentHandler, String studentsFile) {
        return StudentCreateView.build(borderPane, learnerCatalog, studentHandler, studentsFile);
    }

    public static GridPane showLearner(BorderPane borderPane, MyGenericList<Student> learnerCatalog) {
        return StudentShowView.build(borderPane, learnerCatalog);
    }

    public static GridPane reviseLearner(BorderPane borderPane, MyGenericList<Student> learnerCatalog,
                                         StudentHandler studentHandler, String studentsFile) {
        return StudentEditView.build(borderPane, learnerCatalog, studentHandler, studentsFile);
    }
}
