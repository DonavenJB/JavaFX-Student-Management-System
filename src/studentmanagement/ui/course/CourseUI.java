package studentmanagement.ui.course;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import studentmanagement.collection.MyGenericList;
import studentmanagement.handler.CourseHandler;
import studentmanagement.model.Course;
import studentmanagement.model.Department;
import studentmanagement.model.Instructor;

public final class CourseUI {

    private CourseUI() {
    }

    public static GridPane createModule(BorderPane borderPane, MyGenericList<Course> moduleCatalog,
                                        MyGenericList<Department> divisionCatalog,
                                        MyGenericList<Instructor> lecturerCatalog,
                                        CourseHandler courseHandler, String coursesFile) {
        return CourseCreateView.build(
            borderPane, moduleCatalog, divisionCatalog, lecturerCatalog, courseHandler, coursesFile
        );
    }

    public static GridPane showModule(BorderPane borderPane, MyGenericList<Course> moduleCatalog) {
        return CourseShowView.build(borderPane, moduleCatalog);
    }

    public static GridPane reviseModule(BorderPane borderPane, MyGenericList<Course> moduleCatalog,
                                        MyGenericList<Department> divisionCatalog,
                                        MyGenericList<Instructor> lecturerCatalog,
                                        CourseHandler courseHandler, String coursesFile) {
        return CourseEditView.build(
            borderPane, moduleCatalog, divisionCatalog, lecturerCatalog, courseHandler, coursesFile
        );
    }
}
