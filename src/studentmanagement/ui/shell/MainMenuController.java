package studentmanagement.ui.shell;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import studentmanagement.app.AppContext;
import studentmanagement.ui.course.CourseUI;
import studentmanagement.ui.department.DepartmentUI;
import studentmanagement.ui.enrollment.EnrollmentUI;
import studentmanagement.ui.instructor.InstructorUI;
import studentmanagement.ui.report.ReportUI;
import studentmanagement.ui.shell.MainMenuFactory.MenuBundle;
import studentmanagement.ui.student.StudentUI;

public final class MainMenuController {

    private MainMenuController() {
    }

    public static void bind(Stage primaryStage,
                            BorderPane borderPane,
                            AppContext appContext,
                            MainMenuFactory.MenuBundle menuBundle) {

        bindStudentActions(borderPane, appContext, menuBundle);
        bindDepartmentActions(borderPane, appContext, menuBundle);
        bindInstructorActions(borderPane, appContext, menuBundle);
        bindCourseActions(borderPane, appContext, menuBundle);
        bindEnrollmentActions(borderPane, appContext, menuBundle);
        bindReportActions(borderPane, appContext, menuBundle);

        menuBundle.getExitProgram().setOnAction(e -> primaryStage.close());
    }

    private static void bindStudentActions(BorderPane borderPane,
                                           AppContext appContext,
                                           MainMenuFactory.MenuBundle menuBundle) {
        menuBundle.getAddStudent().setOnAction(e ->
            StudentUI.createLearner(
                borderPane,
                appContext.getLearnerCatalog(),
                appContext.getStudentHandler(),
                appContext.getStudentsFile()
            )
        );

        menuBundle.getEditStudent().setOnAction(e ->
            StudentUI.reviseLearner(
                borderPane,
                appContext.getLearnerCatalog(),
                appContext.getStudentHandler(),
                appContext.getStudentsFile()
            )
        );

        menuBundle.getDisplayStudent().setOnAction(e ->
            StudentUI.showLearner(borderPane, appContext.getLearnerCatalog())
        );
    }

    private static void bindDepartmentActions(BorderPane borderPane,
                                              AppContext appContext,
                                              MainMenuFactory.MenuBundle menuBundle) {
        menuBundle.getAddDepartment().setOnAction(e ->
            DepartmentUI.createDivision(
                borderPane,
                appContext.getDivisionCatalog(),
                appContext.getDepartmentHandler(),
                appContext.getDepartmentsFile()
            )
        );

        menuBundle.getEditDepartment().setOnAction(e ->
            DepartmentUI.reviseDivision(
                borderPane,
                appContext.getDivisionCatalog(),
                appContext.getDepartmentHandler(),
                appContext.getDepartmentsFile()
            )
        );

        menuBundle.getDisplayDepartment().setOnAction(e ->
            DepartmentUI.showDivision(borderPane, appContext.getDivisionCatalog())
        );
    }

    private static void bindInstructorActions(BorderPane borderPane,
                                              AppContext appContext,
                                              MainMenuFactory.MenuBundle menuBundle) {
        menuBundle.getAddInstructor().setOnAction(e ->
            InstructorUI.createLecturer(
                borderPane,
                appContext.getLecturerCatalog(),
                appContext.getDivisionCatalog(),
                appContext.getInstructorHandler(),
                appContext.getInstructorsFile()
            )
        );

        menuBundle.getEditInstructor().setOnAction(e ->
            InstructorUI.reviseLecturer(
                borderPane,
                appContext.getLecturerCatalog(),
                appContext.getDivisionCatalog(),
                appContext.getInstructorHandler(),
                appContext.getInstructorsFile()
            )
        );

        menuBundle.getDisplayInstructor().setOnAction(e ->
            InstructorUI.showLecturer(borderPane, appContext.getLecturerCatalog())
        );
    }

    private static void bindCourseActions(BorderPane borderPane,
                                          AppContext appContext,
                                          MainMenuFactory.MenuBundle menuBundle) {
        menuBundle.getAddCourse().setOnAction(e ->
            CourseUI.createModule(
                borderPane,
                appContext.getModuleCatalog(),
                appContext.getDivisionCatalog(),
                appContext.getLecturerCatalog(),
                appContext.getCourseHandler(),
                appContext.getCoursesFile()
            )
        );

        menuBundle.getEditCourse().setOnAction(e ->
            CourseUI.reviseModule(
                borderPane,
                appContext.getModuleCatalog(),
                appContext.getDivisionCatalog(),
                appContext.getLecturerCatalog(),
                appContext.getCourseHandler(),
                appContext.getCoursesFile()
            )
        );

        menuBundle.getDisplayCourse().setOnAction(e ->
            CourseUI.showModule(borderPane, appContext.getModuleCatalog())
        );
    }

    private static void bindEnrollmentActions(BorderPane borderPane,
                                              AppContext appContext,
                                              MainMenuFactory.MenuBundle menuBundle) {
        menuBundle.getAddEnrollment().setOnAction(e ->
            EnrollmentUI.createRegistration(
                borderPane,
                appContext.getRegistrationCatalog(),
                appContext.getLearnerCatalog(),
                appContext.getModuleCatalog(),
                appContext.getEnrollmentHandler(),
                appContext.getEnrollmentsFile()
            )
        );

        menuBundle.getEditEnrollment().setOnAction(e ->
            EnrollmentUI.reviseRegistration(
                borderPane,
                appContext.getRegistrationCatalog(),
                appContext.getLearnerCatalog(),
                appContext.getModuleCatalog(),
                appContext.getEnrollmentHandler(),
                appContext.getEnrollmentsFile()
            )
        );

        menuBundle.getDisplayEnrollment().setOnAction(e ->
        EnrollmentUI.showRegistration(
            borderPane,
            appContext.getRegistrationCatalog(),
            appContext.getLearnerCatalog(),
            appContext.getModuleCatalog()
        )
    );
    }

    private static void bindReportActions(BorderPane borderPane,
                                          AppContext appContext,
                                          MainMenuFactory.MenuBundle menuBundle) {
        menuBundle.getCourseReport().setOnAction(e ->
            ReportUI.buildCourseReport(
                borderPane,
                appContext.getRegistrationCatalog(),
                appContext.getLearnerCatalog(),
                appContext.getModuleCatalog()
            )
        );

        menuBundle.getStudentReport().setOnAction(e ->
            ReportUI.buildStudentReport(
                borderPane,
                appContext.getRegistrationCatalog(),
                appContext.getLearnerCatalog(),
                appContext.getModuleCatalog()
            )
        );

        menuBundle.getExceptionReport().setOnAction(e ->
            ReportUI.buildExceptionReport(
                borderPane,
                appContext.getRegistrationCatalog(),
                appContext.getLearnerCatalog(),
                appContext.getModuleCatalog()
            )
        );
    }
}
