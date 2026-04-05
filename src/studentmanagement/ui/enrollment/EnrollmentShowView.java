package studentmanagement.ui.enrollment;

import javafx.geometry.Pos;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.TextArea;

import javafx.scene.control.TextField;

import javafx.scene.control.TitledPane;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.GridPane;

import javafx.scene.layout.VBox;

import studentmanagement.collection.MyGenericList;

import studentmanagement.model.Course;

import studentmanagement.model.Enrollment;

import studentmanagement.model.Student;

import studentmanagement.ui.common.AlertUtils;

import studentmanagement.ui.common.LayoutFactory;

public final class EnrollmentShowView {

 private EnrollmentShowView() {

 }

 public static GridPane build(BorderPane borderPane, MyGenericList<Enrollment> registrationCatalog,

 MyGenericList<Student> learnerCatalog, MyGenericList<Course> moduleCatalog) {

 GridPane grid = LayoutFactory.createFormGrid();

 Label enrollmentIDLabel = new Label("Enrollment ID: ");

 GridPane.setConstraints(enrollmentIDLabel, 0, 0);

 TextField enrollmentIDInput = new TextField();

 GridPane.setConstraints(enrollmentIDInput, 1, 0);

 TextField studentIDPreview = new TextField();

 TextField studentNamePreview = new TextField();

 TextArea studentAddressPreview = new TextArea();

 TextField studentCityPreview = new TextField();

 TextField studentStatePreview = new TextField();

 TextField studentZipPreview = new TextField();

 TextField courseIDPreview = new TextField();

 TextField courseNamePreview = new TextField();

 TextArea courseDescriptionPreview = new TextArea();

 TextField courseDepartmentPreview = new TextField();

 TextField courseInstructorPreview = new TextField();

 EnrollmentFormSupport.configurePreviewField(studentIDPreview, "Student ID");

 EnrollmentFormSupport.configurePreviewField(studentNamePreview, "Student");

 EnrollmentFormSupport.configurePreviewField(studentCityPreview, "City");

 EnrollmentFormSupport.configurePreviewField(studentStatePreview, "State");

 EnrollmentFormSupport.configurePreviewField(studentZipPreview, "ZIP");

 EnrollmentFormSupport.configurePreviewArea(studentAddressPreview, "Address");

 EnrollmentFormSupport.configurePreviewField(courseIDPreview, "Course ID");

 EnrollmentFormSupport.configurePreviewField(courseNamePreview, "Course");

 EnrollmentFormSupport.configurePreviewField(courseDepartmentPreview, "Department");

 EnrollmentFormSupport.configurePreviewField(courseInstructorPreview, "Instructor");

 EnrollmentFormSupport.configurePreviewArea(courseDescriptionPreview, "Description");

 TitledPane studentPreviewPane = EnrollmentFormSupport.buildStudentDisplayPane(

 studentIDPreview, studentNamePreview, studentAddressPreview,

 studentCityPreview, studentStatePreview, studentZipPreview

 );

 TitledPane coursePreviewPane = EnrollmentFormSupport.buildCourseDisplayPane(

 courseIDPreview, courseNamePreview, courseDescriptionPreview,

 courseDepartmentPreview, courseInstructorPreview

 );

 VBox previewColumn = new VBox(15, studentPreviewPane, coursePreviewPane);

 previewColumn.setAlignment(Pos.CENTER);

 GridPane.setConstraints(previewColumn, 0, 1, 2, 1);

 Label semesterLabel = new Label("Semester: ");

 GridPane.setConstraints(semesterLabel, 0, 2);

 TextField semesterInput = new TextField();

 semesterInput.setEditable(false);

 GridPane.setConstraints(semesterInput, 1, 2);

 Label yearLabel = new Label("Year: ");

 GridPane.setConstraints(yearLabel, 0, 3);

 TextField yearInput = new TextField();

 yearInput.setEditable(false);

 GridPane.setConstraints(yearInput, 1, 3);

 Label gradeLabel = new Label("Grade: ");

 GridPane.setConstraints(gradeLabel, 0, 4);

 TextField gradeInput = new TextField();

 gradeInput.setEditable(false);

 GridPane.setConstraints(gradeInput, 1, 4);

 Button searchButton = new Button("Search Enrollment");

 GridPane.setConstraints(searchButton, 2, 0);

 searchButton.setOnAction(e -> {

 try {

 int registrationKey = Integer.parseInt(enrollmentIDInput.getText().trim());

 Enrollment enrollment = EnrollmentFormSupport.findEnrollmentByKey(registrationCatalog, registrationKey);

 if (enrollment != null) {

 studentIDPreview.setText(String.valueOf(enrollment.getStudentId()));

 courseIDPreview.setText(String.valueOf(enrollment.getCourseId()));

 semesterInput.setText(enrollment.getSemester());

 yearInput.setText(enrollment.getYear());

 gradeInput.setText(String.valueOf(enrollment.getGrade()));

 Student student = EnrollmentFormSupport.findStudentByKey(learnerCatalog, enrollment.getStudentId());

 Course course = EnrollmentFormSupport.findCourseByKey(moduleCatalog, enrollment.getCourseId());

 if (student != null) {

 EnrollmentFormSupport.populateStudentPreview(

 student, studentNamePreview, studentAddressPreview,

 studentCityPreview, studentStatePreview, studentZipPreview

 );

 } else {

 EnrollmentFormSupport.clearStudentPreview(

 studentNamePreview, studentAddressPreview,

 studentCityPreview, studentStatePreview, studentZipPreview

 );

 }

 if (course != null) {

 EnrollmentFormSupport.populateCoursePreview(

 course, courseNamePreview, courseDescriptionPreview,

 courseDepartmentPreview, courseInstructorPreview

 );

 } else {

 EnrollmentFormSupport.clearCoursePreview(

 courseNamePreview, courseDescriptionPreview,

 courseDepartmentPreview, courseInstructorPreview

 );

 }

 } else {

 AlertUtils.showError("Form Error", "Enrollment with ID " + registrationKey + " not found.");

 }

 } catch (NumberFormatException ex) {

 AlertUtils.showError("Form Error", "Invalid enrollment ID format.");

 }

 });

 grid.getChildren().addAll(

 enrollmentIDLabel, enrollmentIDInput,

 searchButton,

 previewColumn,

 semesterLabel, semesterInput,

 yearLabel, yearInput,

 gradeLabel, gradeInput

 );

 LayoutFactory.showCentered(borderPane, grid);

 return grid;

 }

}
