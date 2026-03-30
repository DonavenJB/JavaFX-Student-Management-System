package studentmanagement.ui.instructor;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import studentmanagement.collection.MyGenericList;
import studentmanagement.handler.InstructorHandler;
import studentmanagement.model.Department;
import studentmanagement.model.Instructor;

public final class InstructorUI {

    private InstructorUI() {
    }

    public static GridPane createLecturer(BorderPane borderPane, MyGenericList<Instructor> lecturerCatalog,
                                          MyGenericList<Department> divisionCatalog,
                                          InstructorHandler instructorHandler, String instructorsFile) {
        return InstructorCreateView.build(borderPane, lecturerCatalog, divisionCatalog, instructorHandler, instructorsFile);
    }

    public static GridPane showLecturer(BorderPane borderPane, MyGenericList<Instructor> lecturerCatalog) {
        return InstructorShowView.build(borderPane, lecturerCatalog);
    }

    public static GridPane reviseLecturer(BorderPane borderPane, MyGenericList<Instructor> lecturerCatalog,
                                          MyGenericList<Department> divisionCatalog,
                                          InstructorHandler instructorHandler, String instructorsFile) {
        return InstructorEditView.build(borderPane, lecturerCatalog, divisionCatalog, instructorHandler, instructorsFile);
    }
}
