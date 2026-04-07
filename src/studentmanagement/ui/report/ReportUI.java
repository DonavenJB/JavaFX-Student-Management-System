package studentmanagement.ui.report;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import studentmanagement.collection.MyGenericList;
import studentmanagement.model.Course;
import studentmanagement.model.Enrollment;
import studentmanagement.model.Student;

public final class ReportUI {

    private ReportUI() {
    }

    public static GridPane buildSummary(BorderPane borderPane, MyGenericList<Enrollment> registrationCatalog,
                                        MyGenericList<Student> learnerCatalog, MyGenericList<Course> moduleCatalog) {
        return CourseReportView.build(borderPane, registrationCatalog, learnerCatalog, moduleCatalog);
    }

    public static GridPane buildCourseReport(BorderPane borderPane, MyGenericList<Enrollment> registrationCatalog,
                                             MyGenericList<Student> learnerCatalog, MyGenericList<Course> moduleCatalog) {
        return CourseReportView.build(borderPane, registrationCatalog, learnerCatalog, moduleCatalog);
    }

    public static GridPane buildStudentReport(BorderPane borderPane, MyGenericList<Enrollment> registrationCatalog,
                                              MyGenericList<Student> learnerCatalog, MyGenericList<Course> moduleCatalog) {
        return StudentReportView.build(borderPane, registrationCatalog, learnerCatalog, moduleCatalog);
    }

    public static GridPane buildExceptionReport(BorderPane borderPane, MyGenericList<Enrollment> registrationCatalog,
                                                MyGenericList<Student> learnerCatalog, MyGenericList<Course> moduleCatalog) {
        return ExceptionReportView.build(borderPane, registrationCatalog, learnerCatalog, moduleCatalog);
    }
}
