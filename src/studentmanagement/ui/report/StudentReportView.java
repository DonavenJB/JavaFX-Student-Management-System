package studentmanagement.ui.report;

import java.util.ArrayList;

import java.util.List;

import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;

import javafx.scene.control.Label;

import javafx.scene.control.ScrollPane;

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

import studentmanagement.ui.common.FormUtils;

import studentmanagement.ui.common.AlertUtils;

import studentmanagement.ui.common.LayoutFactory;

public final class StudentReportView {

 private StudentReportView() {

 }

 public static GridPane build(BorderPane borderPane, MyGenericList<Enrollment> registrationCatalog,

 MyGenericList<Student> learnerCatalog, MyGenericList<Course> moduleCatalog) {

 GridPane root = ReportFieldFactory.createRootPane();

 VBox mainColumn = ReportFieldFactory.createMainColumn();

 Label pageTitle = ReportFieldFactory.createPageTitle("Student Report");

 ComboBox<String> studentDropdown = new ComboBox<>();

 studentDropdown.setPromptText("Select Student");

 studentDropdown.setPrefWidth(320);

 loadStudentChoices(learnerCatalog, studentDropdown);

 Button generateButton = new Button("Generate Report");

 Button clearButton = new Button("Clear");

 GridPane filterGrid = ReportFieldFactory.createTwoColumnFilterGrid();

 filterGrid.add(new Label("Student:"), 0, 0);

 filterGrid.add(studentDropdown, 1, 0);

 filterGrid.add(ReportFieldFactory.centeredButtons(generateButton, clearButton), 0, 1, 2, 1);

 TextField summaryStudentId = ReportFieldFactory.summaryField("Student ID");

 TextField summaryStudentName = ReportFieldFactory.summaryField("Student Name");

 TextArea summaryAddress = ReportFieldFactory.summaryArea("Address");

 TextField summaryCity = ReportFieldFactory.summaryField("City");

 TextField summaryState = ReportFieldFactory.summaryField("State");

 TextField summaryZip = ReportFieldFactory.summaryField("ZIP");

 TextField summaryTotalEnrollments = ReportFieldFactory.summaryField("Total Enrollments");

 GridPane summaryGrid = ReportFieldFactory.createFourColumnSummaryGrid();

 summaryGrid.add(new Label("Student ID:"), 0, 0);

 summaryGrid.add(summaryStudentId, 1, 0);

 summaryGrid.add(new Label("Student Name:"), 2, 0);

 summaryGrid.add(summaryStudentName, 3, 0);

 summaryGrid.add(new Label("Address:"), 0, 1);

 summaryGrid.add(summaryAddress, 1, 1, 3, 1);

 summaryGrid.add(new Label("City:"), 0, 2);

 summaryGrid.add(summaryCity, 1, 2);

 summaryGrid.add(new Label("State:"), 2, 2);

 summaryGrid.add(summaryState, 3, 2);

 summaryGrid.add(new Label("ZIP:"), 0, 3);

 summaryGrid.add(summaryZip, 1, 3);

 summaryGrid.add(new Label("Total Enrollments:"), 2, 3);

 summaryGrid.add(summaryTotalEnrollments, 3, 3);

 TitledPane summaryPane = ReportFieldFactory.titledPane("Report Summary", summaryGrid, 860);

 VBox resultsBox = ReportFieldFactory.createResultsBoxWithPlaceholder("Generate a report to view results.");

 ScrollPane resultsScrollPane = ReportFieldFactory.resultsScrollPane(resultsBox);

 TitledPane resultsPane = ReportFieldFactory.titledPane("Report Results", resultsScrollPane, 860);

 TextField detailEnrollmentId = ReportFieldFactory.summaryField("Enrollment ID");

 TextField detailCourseId = ReportFieldFactory.summaryField("Course ID");

 TextField detailCourseName = ReportFieldFactory.summaryField("Course Name");

 TextArea detailCourseDescription = ReportFieldFactory.summaryArea("Description");

 TextField detailDepartment = ReportFieldFactory.summaryField("Department");

 TextField detailInstructor = ReportFieldFactory.summaryField("Instructor");

 TextField detailSemester = ReportFieldFactory.summaryField("Semester");

 TextField detailYear = ReportFieldFactory.summaryField("Year");

 TextField detailGrade = ReportFieldFactory.summaryField("Grade");

 GridPane detailGrid = ReportFieldFactory.createFourColumnSummaryGrid();

 detailGrid.add(new Label("Enrollment ID:"), 0, 0);

 detailGrid.add(detailEnrollmentId, 1, 0);

 detailGrid.add(new Label("Course ID:"), 2, 0);

 detailGrid.add(detailCourseId, 3, 0);

 detailGrid.add(new Label("Course Name:"), 0, 1);

 detailGrid.add(detailCourseName, 1, 1, 3, 1);

 detailGrid.add(new Label("Description:"), 0, 2);

 detailGrid.add(detailCourseDescription, 1, 2, 3, 1);

 detailGrid.add(new Label("Department:"), 0, 3);

 detailGrid.add(detailDepartment, 1, 3);

 detailGrid.add(new Label("Instructor:"), 2, 3);

 detailGrid.add(detailInstructor, 3, 3);

 detailGrid.add(new Label("Semester:"), 0, 4);

 detailGrid.add(detailSemester, 1, 4);

 detailGrid.add(new Label("Year:"), 2, 4);

 detailGrid.add(detailYear, 3, 4);

 detailGrid.add(new Label("Grade:"), 0, 5);

 detailGrid.add(detailGrade, 1, 5);

 TitledPane detailPane = ReportFieldFactory.titledPane("Selected Record", detailGrid, 860);

 generateButton.setOnAction(e -> {

 String selectedStudentChoice = studentDropdown.getValue();

 if (selectedStudentChoice == null) {

 AlertUtils.showError("Form Error!", "Please select a student.");

 return;

 }

 int learnerKey = parseStudentIdFromChoice(selectedStudentChoice);

 Student selectedStudent = locateLearnerByKey(learnerCatalog, learnerKey);

 if (selectedStudent == null) {

 AlertUtils.showError("Student Not Found", "The selected student could not be resolved.");

 return;

 }

 List<ReportResultsBuilder.StudentReportRowData> reportRows = new ArrayList<>();

 for (Enrollment enrollment : registrationCatalog.fetchAllItems()) {

 if (enrollment.getStudentId() == learnerKey) {

 Course course = findCourseByKey(moduleCatalog, enrollment.getCourseId());

 if (course != null) {

 reportRows.add(new ReportResultsBuilder.StudentReportRowData(enrollment, selectedStudent, course));

 }

 }

 }

 summaryStudentId.setText(String.valueOf(selectedStudent.getStudentId()));

 summaryStudentName.setText(selectedStudent.getName());

 summaryAddress.setText(selectedStudent.getStreetLine());

 summaryCity.setText(selectedStudent.getCity());

 summaryState.setText(selectedStudent.getState());

 summaryZip.setText(selectedStudent.getZipCode());

 summaryTotalEnrollments.setText(String.valueOf(reportRows.size()));

 ReportFieldFactory.clearDetailFields(

 detailEnrollmentId, detailCourseId, detailCourseName,

 detailCourseDescription, detailDepartment, detailInstructor,

 detailSemester, detailYear, detailGrade

 );

 ReportResultsBuilder.populateStudentResults(

 resultsBox, reportRows, detailEnrollmentId, detailCourseId, detailCourseName,

 detailCourseDescription, detailDepartment, detailInstructor,

 detailSemester, detailYear, detailGrade

 );

 });

 clearButton.setOnAction(e -> {

 studentDropdown.getSelectionModel().clearSelection();

 FormUtils.clearFields(

 summaryStudentId, summaryStudentName, summaryCity, summaryState,

 summaryZip, summaryTotalEnrollments

 );

 summaryAddress.clear();

 ReportFieldFactory.clearDetailFields(

 detailEnrollmentId, detailCourseId, detailCourseName,

 detailCourseDescription, detailDepartment, detailInstructor,

 detailSemester, detailYear, detailGrade

 );

 ReportFieldFactory.resetResultsPlaceholder(resultsBox, "Generate a report to view results.");

 });

 mainColumn.getChildren().addAll(pageTitle, filterGrid, summaryPane, resultsPane, detailPane);

 root.getChildren().add(mainColumn);

 LayoutFactory.showCentered(borderPane, root);

 return root;

 }

 private static void loadStudentChoices(MyGenericList<Student> learnerCatalog, ComboBox<String> studentDropdown) {

 studentDropdown.getItems().clear();

 for (int i = 0; i < learnerCatalog.size(); i++) {

 Student student = learnerCatalog.get(i);

 studentDropdown.getItems().add(student.getStudentId() + " - " + student.getName());

 }

 }

 private static int parseStudentIdFromChoice(String choice) {

 int dashIndex = choice.indexOf(" - ");

 if (dashIndex == -1) {

 return Integer.parseInt(choice.trim());

 }

 return Integer.parseInt(choice.substring(0, dashIndex).trim());

 }

 private static Course findCourseByKey(MyGenericList<Course> moduleCatalog, int moduleKey) {

 for (int i = 0; i < moduleCatalog.size(); i++) {

 Course course = moduleCatalog.get(i);

 if (course.getCourseId() == moduleKey) {

 return course;

 }

 }

 return null;

 }

 private static Student locateLearnerByKey(MyGenericList<Student> learnerCatalog, int learnerKey) {

 for (int i = 0; i < learnerCatalog.size(); i++) {

 Student student = learnerCatalog.get(i);

 if (student.getStudentId() == learnerKey) {

 return student;

 }

 }

 return null;

 }

}
