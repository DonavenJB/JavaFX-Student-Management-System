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

import studentmanagement.handler.EnrollmentHandler;

import studentmanagement.model.Course;

import studentmanagement.model.Enrollment;

import studentmanagement.model.Student;

import studentmanagement.ui.common.AlertUtils;

import studentmanagement.ui.common.FormUtils;

import studentmanagement.ui.common.LayoutFactory;

public final class EnrollmentCreateView {

 private EnrollmentCreateView() {

 }

 public static GridPane build(BorderPane borderPane, MyGenericList<Enrollment> registrationCatalog,

 MyGenericList<Student> learnerCatalog, MyGenericList<Course> moduleCatalog,

 EnrollmentHandler enrollmentHandler, String enrollmentsFile) {

 GridPane grid = LayoutFactory.createFormGrid();

 Label enrollmentIDLabel = new Label("Enrollment ID: ");

 GridPane.setConstraints(enrollmentIDLabel, 0, 0);

 TextField enrollmentID = new TextField();

 GridPane.setConstraints(enrollmentID, 1, 0);

 TextField studentIDField = new TextField();

 Button searchStudent = new Button("Search Student");

 TextField studentNamePreview = new TextField();

 TextArea studentAddressPreview = new TextArea();

 TextField studentCityPreview = new TextField();

 TextField studentStatePreview = new TextField();

 TextField studentZipPreview = new TextField();

 TextField courseIDField = new TextField();

 Button searchCourse = new Button("Search Course");

 TextField courseNamePreview = new TextField();

 TextArea courseDescriptionPreview = new TextArea();

 TextField courseDepartmentPreview = new TextField();

 TextField courseInstructorPreview = new TextField();

 EnrollmentFormSupport.configurePreviewField(studentNamePreview, "No student selected");

 EnrollmentFormSupport.configurePreviewField(studentCityPreview, "City");

 EnrollmentFormSupport.configurePreviewField(studentStatePreview, "State");

 EnrollmentFormSupport.configurePreviewField(studentZipPreview, "ZIP");

 EnrollmentFormSupport.configurePreviewArea(studentAddressPreview, "Address will appear here");

 EnrollmentFormSupport.configurePreviewField(courseNamePreview, "No course selected");

 EnrollmentFormSupport.configurePreviewField(courseDepartmentPreview, "Department");

 EnrollmentFormSupport.configurePreviewField(courseInstructorPreview, "Instructor");

 EnrollmentFormSupport.configurePreviewArea(courseDescriptionPreview, "Course description will appear here");

 TitledPane studentPreviewPane = EnrollmentFormSupport.buildStudentPreviewPane(

 studentIDField, searchStudent, studentNamePreview, studentAddressPreview,

 studentCityPreview, studentStatePreview, studentZipPreview

 );

 TitledPane coursePreviewPane = EnrollmentFormSupport.buildCoursePreviewPane(

 courseIDField, searchCourse, courseNamePreview, courseDescriptionPreview,

 courseDepartmentPreview, courseInstructorPreview

 );

 VBox previewColumn = new VBox(15, studentPreviewPane, coursePreviewPane);

 previewColumn.setAlignment(Pos.CENTER);

 GridPane.setConstraints(previewColumn, 0, 1, 2, 1);

 Label semesterLabel = new Label("Semester: ");

 GridPane.setConstraints(semesterLabel, 0, 2);

 TextField semesterInput = new TextField();

 GridPane.setConstraints(semesterInput, 1, 2);

 Label yearLabel = new Label("Year: ");

 GridPane.setConstraints(yearLabel, 0, 3);

 TextField yearInput = new TextField();

 GridPane.setConstraints(yearInput, 1, 3);

 Label gradeLabel = new Label("Grade: ");

 GridPane.setConstraints(gradeLabel, 0, 4);

 TextField gradeInput = new TextField();

 GridPane.setConstraints(gradeInput, 1, 4);

 Button createEnrollment = new Button("Create Enrollment");

 GridPane.setConstraints(createEnrollment, 1, 5);

 searchStudent.setOnAction(e -> {

 try {

 int learnerKey = Integer.parseInt(studentIDField.getText().trim());

 Student student = EnrollmentFormSupport.findStudentByKey(learnerCatalog, learnerKey);

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

 AlertUtils.showError("Invalid Student ID", "This Student ID does not exist.");

 }

 } catch (NumberFormatException ex) {

 EnrollmentFormSupport.clearStudentPreview(

 studentNamePreview, studentAddressPreview,

 studentCityPreview, studentStatePreview, studentZipPreview

 );

 AlertUtils.showError("Invalid Student ID", "You have entered an invalid student ID.");

 }

 });

 searchCourse.setOnAction(e -> {

 try {

 int moduleKey = Integer.parseInt(courseIDField.getText().trim());

 Course course = EnrollmentFormSupport.findCourseByKey(moduleCatalog, moduleKey);

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

 AlertUtils.showError("Invalid Course ID", "This Course ID does not exist.");

 }

 } catch (NumberFormatException ex) {

 EnrollmentFormSupport.clearCoursePreview(

 courseNamePreview, courseDescriptionPreview,

 courseDepartmentPreview, courseInstructorPreview

 );

 AlertUtils.showError("Invalid Course ID", "You have entered an invalid course ID.");

 }

 });

 createEnrollment.setOnAction(e -> {

 try {

 int registrationKey = Integer.parseInt(enrollmentID.getText().trim());

 int learnerKey = Integer.parseInt(studentIDField.getText().trim());

 int moduleKey = Integer.parseInt(courseIDField.getText().trim());

 String termLabel = semesterInput.getText().trim();

 String termYear = yearInput.getText().trim();

 char markValue = gradeInput.getText().isEmpty() ? 'N' : gradeInput.getText().charAt(0);

 if (termLabel.isEmpty() || termYear.isEmpty()) {

 AlertUtils.showError("Form Error", "Please enter all fields.");

 return;

 }

 if (EnrollmentFormSupport.containsEnrollmentKey(registrationCatalog, registrationKey)) {

 AlertUtils.showError("Form Error", "Enrollment with ID " + registrationKey + " already exists.");

 return;

 }

 Student student = EnrollmentFormSupport.findStudentByKey(learnerCatalog, learnerKey);

 if (student == null) {

 AlertUtils.showError("Form Error", "Student with ID " + learnerKey + " does not exist.");

 return;

 }

 Course course = EnrollmentFormSupport.findCourseByKey(moduleCatalog, moduleKey);

 if (course == null) {

 AlertUtils.showError("Form Error", "Course with ID " + moduleKey + " does not exist.");

 return;

 }

 Enrollment enrollment = new Enrollment(registrationKey, learnerKey, moduleKey, termLabel, termYear, markValue);

 registrationCatalog.add(enrollment);

 registrationCatalog.sort();

 enrollmentHandler.saveToFile(registrationCatalog, enrollmentsFile);

 AlertUtils.showInfo("Success", "Enrollment added successfully!");

 FormUtils.clearFields(enrollmentID, studentIDField, courseIDField, semesterInput, yearInput, gradeInput);

 EnrollmentFormSupport.clearStudentPreview(

 studentNamePreview, studentAddressPreview,

 studentCityPreview, studentStatePreview, studentZipPreview

 );

 EnrollmentFormSupport.clearCoursePreview(

 courseNamePreview, courseDescriptionPreview,

 courseDepartmentPreview, courseInstructorPreview

 );

 } catch (NumberFormatException ex) {

 AlertUtils.showError("Form Error", "Invalid ID format.");

 }

 });

 grid.getChildren().addAll(

 enrollmentIDLabel, enrollmentID,

 previewColumn,

 semesterLabel, semesterInput,

 yearLabel, yearInput,

 gradeLabel, gradeInput,

 createEnrollment

 );

 LayoutFactory.showCentered(borderPane, grid);

 return grid;

 }

}
