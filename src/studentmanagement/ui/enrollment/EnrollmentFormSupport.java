package studentmanagement.ui.enrollment;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import studentmanagement.collection.MyGenericList;
import studentmanagement.model.Course;
import studentmanagement.model.Enrollment;
import studentmanagement.model.Student;
import studentmanagement.ui.common.FormUtils;
import studentmanagement.ui.common.LayoutFactory;

public final class EnrollmentFormSupport {

    private EnrollmentFormSupport() {
    }

    public static void configurePreviewField(TextField field, String promptText) {
        field.setEditable(false);
        field.setFocusTraversable(false);
        field.setPromptText(promptText);
        field.setPrefWidth(240);
        field.setStyle("-fx-control-inner-background: #eeeeee; -fx-opacity: 1;");
    }

    public static void configurePreviewArea(TextArea area, String promptText) {
        area.setEditable(false);
        area.setWrapText(true);
        area.setFocusTraversable(false);
        area.setPromptText(promptText);
        area.setPrefColumnCount(20);
        area.setPrefRowCount(2);
        area.setStyle("-fx-control-inner-background: #eeeeee; -fx-opacity: 1;");
    }

    public static TitledPane buildStudentPreviewPane(TextField studentIDField, Button searchStudent,
                                                     TextField studentNamePreview, TextArea studentAddressPreview,
                                                     TextField studentCityPreview, TextField studentStatePreview,
                                                     TextField studentZipPreview) {
        GridPane paneGrid = LayoutFactory.createFormGrid();
        paneGrid.add(new Label("Student ID:"), 0, 0);
        paneGrid.add(studentIDField, 1, 0);
        paneGrid.add(searchStudent, 2, 0);
        paneGrid.add(new Label("Name:"), 0, 1);
        paneGrid.add(studentNamePreview, 1, 1, 2, 1);
        paneGrid.add(new Label("Address:"), 0, 2);
        paneGrid.add(studentAddressPreview, 1, 2, 2, 1);
        paneGrid.add(new Label("City:"), 0, 3);
        paneGrid.add(studentCityPreview, 1, 3, 2, 1);
        paneGrid.add(new Label("State:"), 0, 4);
        paneGrid.add(studentStatePreview, 1, 4, 2, 1);
        paneGrid.add(new Label("ZIP:"), 0, 5);
        paneGrid.add(studentZipPreview, 1, 5, 2, 1);

        TitledPane titledPane = new TitledPane("Student Preview", paneGrid);
        titledPane.setCollapsible(false);
        titledPane.setAnimated(false);
        titledPane.setPrefWidth(420);
        return titledPane;
    }

    public static TitledPane buildCoursePreviewPane(TextField courseIDField, Button searchCourse,
                                                    TextField courseNamePreview, TextArea courseDescriptionPreview,
                                                    TextField courseDepartmentPreview, TextField courseInstructorPreview) {
        GridPane paneGrid = LayoutFactory.createFormGrid();
        paneGrid.add(new Label("Course ID:"), 0, 0);
        paneGrid.add(courseIDField, 1, 0);
        paneGrid.add(searchCourse, 2, 0);
        paneGrid.add(new Label("Course Name:"), 0, 1);
        paneGrid.add(courseNamePreview, 1, 1, 2, 1);
        paneGrid.add(new Label("Description:"), 0, 2);
        paneGrid.add(courseDescriptionPreview, 1, 2, 2, 1);
        paneGrid.add(new Label("Department:"), 0, 3);
        paneGrid.add(courseDepartmentPreview, 1, 3, 2, 1);
        paneGrid.add(new Label("Instructor:"), 0, 4);
        paneGrid.add(courseInstructorPreview, 1, 4, 2, 1);

        TitledPane titledPane = new TitledPane("Course Preview", paneGrid);
        titledPane.setCollapsible(false);
        titledPane.setAnimated(false);
        titledPane.setPrefWidth(420);
        return titledPane;
    }

    public static TitledPane buildStudentDisplayPane(TextField studentIDPreview, TextField studentNamePreview,
                                                     TextArea studentAddressPreview, TextField studentCityPreview,
                                                     TextField studentStatePreview, TextField studentZipPreview) {
        GridPane paneGrid = LayoutFactory.createFormGrid();
        paneGrid.add(new Label("Student ID:"), 0, 0);
        paneGrid.add(studentIDPreview, 1, 0);
        paneGrid.add(new Label("Name:"), 0, 1);
        paneGrid.add(studentNamePreview, 1, 1);
        paneGrid.add(new Label("Address:"), 0, 2);
        paneGrid.add(studentAddressPreview, 1, 2);
        paneGrid.add(new Label("City:"), 0, 3);
        paneGrid.add(studentCityPreview, 1, 3);
        paneGrid.add(new Label("State:"), 0, 4);
        paneGrid.add(studentStatePreview, 1, 4);
        paneGrid.add(new Label("ZIP:"), 0, 5);
        paneGrid.add(studentZipPreview, 1, 5);

        TitledPane titledPane = new TitledPane("Student Preview", paneGrid);
        titledPane.setCollapsible(false);
        titledPane.setAnimated(false);
        titledPane.setPrefWidth(420);
        return titledPane;
    }

    public static TitledPane buildCourseDisplayPane(TextField courseIDPreview, TextField courseNamePreview,
                                                    TextArea courseDescriptionPreview, TextField courseDepartmentPreview,
                                                    TextField courseInstructorPreview) {
        GridPane paneGrid = LayoutFactory.createFormGrid();
        paneGrid.add(new Label("Course ID:"), 0, 0);
        paneGrid.add(courseIDPreview, 1, 0);
        paneGrid.add(new Label("Course Name:"), 0, 1);
        paneGrid.add(courseNamePreview, 1, 1);
        paneGrid.add(new Label("Description:"), 0, 2);
        paneGrid.add(courseDescriptionPreview, 1, 2);
        paneGrid.add(new Label("Department:"), 0, 3);
        paneGrid.add(courseDepartmentPreview, 1, 3);
        paneGrid.add(new Label("Instructor:"), 0, 4);
        paneGrid.add(courseInstructorPreview, 1, 4);

        TitledPane titledPane = new TitledPane("Course Preview", paneGrid);
        titledPane.setCollapsible(false);
        titledPane.setAnimated(false);
        titledPane.setPrefWidth(420);
        return titledPane;
    }

    public static Student findStudentByKey(MyGenericList<Student> learnerCatalog, int learnerKey) {
        for (int i = 0; i < learnerCatalog.size(); i++) {
            Student student = learnerCatalog.get(i);
            if (student.getStudentId() == learnerKey) {
                return student;
            }
        }
        return null;
    }

    public static Course findCourseByKey(MyGenericList<Course> moduleCatalog, int moduleKey) {
        for (int i = 0; i < moduleCatalog.size(); i++) {
            Course course = moduleCatalog.get(i);
            if (course.getCourseId() == moduleKey) {
                return course;
            }
        }
        return null;
    }

    public static Enrollment findEnrollmentByKey(MyGenericList<Enrollment> registrationCatalog, int registrationKey) {
        for (int i = 0; i < registrationCatalog.size(); i++) {
            Enrollment enrollment = registrationCatalog.get(i);
            if (enrollment.getRegistrationId() == registrationKey) {
                return enrollment;
            }
        }
        return null;
    }

    public static int findEnrollmentIndexByKey(MyGenericList<Enrollment> registrationCatalog, int registrationKey) {
        for (int i = 0; i < registrationCatalog.size(); i++) {
            if (registrationCatalog.get(i).getRegistrationId() == registrationKey) {
                return i;
            }
        }
        return -1;
    }

    public static boolean containsEnrollmentKey(MyGenericList<Enrollment> registrationCatalog, int registrationKey) {
        return findEnrollmentIndexByKey(registrationCatalog, registrationKey) != -1;
    }

    public static void populateStudentPreview(Student student, TextField studentNamePreview, TextArea studentAddressPreview,
                                              TextField studentCityPreview, TextField studentStatePreview,
                                              TextField studentZipPreview) {
        studentNamePreview.setText(student.getName());
        studentAddressPreview.setText(student.getStreetLine());
        studentCityPreview.setText(student.getCity());
        studentStatePreview.setText(student.getState());
        studentZipPreview.setText(student.getZipCode());
    }

    public static void clearStudentPreview(TextField studentNamePreview, TextArea studentAddressPreview,
                                           TextField studentCityPreview, TextField studentStatePreview,
                                           TextField studentZipPreview) {
        FormUtils.clearTextInputs(studentNamePreview, studentAddressPreview,
                studentCityPreview, studentStatePreview, studentZipPreview);
    }

    public static void populateCoursePreview(Course course, TextField courseNamePreview, TextArea courseDescriptionPreview,
                                             TextField courseDepartmentPreview, TextField courseInstructorPreview) {
        courseNamePreview.setText(course.getCourseName());
        courseDescriptionPreview.setText(course.getCourseDescription());
        courseDepartmentPreview.setText(course.getDepartmentName());
        courseInstructorPreview.setText(course.getInstructorName());
    }

    public static void clearCoursePreview(TextField courseNamePreview, TextArea courseDescriptionPreview,
                                          TextField courseDepartmentPreview, TextField courseInstructorPreview) {
        FormUtils.clearTextInputs(courseNamePreview, courseDescriptionPreview,
                courseDepartmentPreview, courseInstructorPreview);
    }
}
