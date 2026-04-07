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

import studentmanagement.ui.common.AlertUtils;

import studentmanagement.ui.common.FormUtils;

import studentmanagement.ui.common.LayoutFactory;

public final class CourseReportView {

 private CourseReportView() {

 }

 public static GridPane build(BorderPane borderPane, MyGenericList<Enrollment> registrationCatalog,

 MyGenericList<Student> learnerCatalog, MyGenericList<Course> moduleCatalog) {

 GridPane root = ReportFieldFactory.createRootPane();

 VBox mainColumn = ReportFieldFactory.createMainColumn();

 Label pageTitle = ReportFieldFactory.createPageTitle("Course Report");

 ComboBox<String> courseDropdown = new ComboBox<>();

 courseDropdown.setPromptText("Select Course");

 courseDropdown.setPrefWidth(260);

 loadCourseChoices(moduleCatalog, courseDropdown);

 ComboBox<String> semesterDropdown = new ComboBox<>();

 semesterDropdown.getItems().addAll("Winter", "Spring", "Summer", "Fall");

 semesterDropdown.setPromptText("Select Semester");

 semesterDropdown.setPrefWidth(180);

 TextField yearInput = new TextField();

 yearInput.setPromptText("Enter Year");

 yearInput.setPrefWidth(180);

 Button generateButton = new Button("Generate Report");

 Button clearButton = new Button("Clear");

 GridPane filterGrid = ReportFieldFactory.createTwoColumnFilterGrid();

 filterGrid.add(new Label("Course:"), 0, 0);

 filterGrid.add(courseDropdown, 1, 0);

 filterGrid.add(new Label("Semester:"), 0, 1);

 filterGrid.add(semesterDropdown, 1, 1);

 filterGrid.add(new Label("Year:"), 0, 2);

 filterGrid.add(yearInput, 1, 2);

 filterGrid.add(ReportFieldFactory.centeredButtons(generateButton, clearButton), 0, 3, 2, 1);

 TextField summaryCourse = ReportFieldFactory.summaryField("Course");

 TextField summaryDepartment = ReportFieldFactory.summaryField("Department");

 TextField summaryInstructor = ReportFieldFactory.summaryField("Instructor");

 TextField summarySemester = ReportFieldFactory.summaryField("Semester");

 TextField summaryYear = ReportFieldFactory.summaryField("Year");

 TextField summaryTotalStudents = ReportFieldFactory.summaryField("Total Students");

 TextField summaryGradeBreakdown = ReportFieldFactory.summaryField("Grade Breakdown");

 GridPane summaryGrid = ReportFieldFactory.createFourColumnSummaryGrid();

 summaryGrid.add(new Label("Course:"), 0, 0);

 summaryGrid.add(summaryCourse, 1, 0);

 summaryGrid.add(new Label("Department:"), 0, 1);

 summaryGrid.add(summaryDepartment, 1, 1);

 summaryGrid.add(new Label("Instructor:"), 0, 2);

 summaryGrid.add(summaryInstructor, 1, 2);

 summaryGrid.add(new Label("Semester:"), 2, 0);

 summaryGrid.add(summarySemester, 3, 0);

 summaryGrid.add(new Label("Year:"), 2, 1);

 summaryGrid.add(summaryYear, 3, 1);

 summaryGrid.add(new Label("Total Students:"), 2, 2);

 summaryGrid.add(summaryTotalStudents, 3, 2);

 summaryGrid.add(new Label("Grades:"), 0, 3);

 summaryGrid.add(summaryGradeBreakdown, 1, 3, 3, 1);

 TitledPane summaryPane = ReportFieldFactory.titledPane("Report Summary", summaryGrid, 860);

 VBox resultsBox = ReportFieldFactory.createResultsBoxWithPlaceholder("Generate a report to view results.");

 ScrollPane resultsScrollPane = ReportFieldFactory.resultsScrollPane(resultsBox);

 TitledPane resultsPane = ReportFieldFactory.titledPane("Report Results", resultsScrollPane, 860);

 TextField detailEnrollmentId = ReportFieldFactory.summaryField("Enrollment ID");

 TextField detailStudentId = ReportFieldFactory.summaryField("Student ID");

 TextField detailStudentName = ReportFieldFactory.summaryField("Student Name");

 TextArea detailAddress = ReportFieldFactory.summaryArea("Address");

 TextField detailCity = ReportFieldFactory.summaryField("City");

 TextField detailState = ReportFieldFactory.summaryField("State");

 TextField detailZip = ReportFieldFactory.summaryField("ZIP");

 TextField detailGrade = ReportFieldFactory.summaryField("Grade");

 GridPane detailGrid = ReportFieldFactory.createFourColumnSummaryGrid();

 detailGrid.add(new Label("Enrollment ID:"), 0, 0);

 detailGrid.add(detailEnrollmentId, 1, 0);

 detailGrid.add(new Label("Student ID:"), 2, 0);

 detailGrid.add(detailStudentId, 3, 0);

 detailGrid.add(new Label("Student Name:"), 0, 1);

 detailGrid.add(detailStudentName, 1, 1, 3, 1);

 detailGrid.add(new Label("Address:"), 0, 2);

 detailGrid.add(detailAddress, 1, 2, 3, 1);

 detailGrid.add(new Label("City:"), 0, 3);

 detailGrid.add(detailCity, 1, 3);

 detailGrid.add(new Label("State:"), 2, 3);

 detailGrid.add(detailState, 3, 3);

 detailGrid.add(new Label("ZIP:"), 0, 4);

 detailGrid.add(detailZip, 1, 4);

 detailGrid.add(new Label("Grade:"), 2, 4);

 detailGrid.add(detailGrade, 3, 4);

 TitledPane detailPane = ReportFieldFactory.titledPane("Selected Record", detailGrid, 860);

 generateButton.setOnAction(e -> {

 String selectedCourseName = courseDropdown.getValue();

 String selectedSemester = semesterDropdown.getValue();

 String selectedYear = yearInput.getText().trim();

 if (selectedCourseName == null || selectedSemester == null || selectedYear.isEmpty()) {

 AlertUtils.showError("Form Error!", "Please enter all fields.");

 return;

 }

 Course selectedCourse = findCourseByName(moduleCatalog, selectedCourseName);

 if (selectedCourse == null) {

 AlertUtils.showError("Course Not Found",

 "No course with the name " + selectedCourseName + " was found.");

 return;

 }

 List<ReportResultsBuilder.CourseReportRowData> reportRows = new ArrayList<>();

 for (Enrollment enrollment : registrationCatalog.fetchAllItems()) {

 if (enrollment.getYear().equals(selectedYear)

 && enrollment.getSemester().equalsIgnoreCase(selectedSemester)

 && enrollment.getCourseId() == selectedCourse.getCourseId()) {

 Student student = locateLearnerByKey(learnerCatalog, enrollment.getStudentId());

 if (student != null) {

 reportRows.add(new ReportResultsBuilder.CourseReportRowData(enrollment, student, selectedCourse));

 }

 }

 }

 reportRows.sort((a, b) -> a.getStudent().compareTo(b.getStudent()));

 summaryCourse.setText(selectedCourse.getCourseName());

 summaryDepartment.setText(selectedCourse.getDepartmentName());

 summaryInstructor.setText(selectedCourse.getInstructorName());

 summarySemester.setText(selectedSemester);

 summaryYear.setText(selectedYear);

 summaryTotalStudents.setText(String.valueOf(reportRows.size()));

 summaryGradeBreakdown.setText(ReportResultsBuilder.buildCourseGradeBreakdown(reportRows));

 ReportFieldFactory.clearDetailFields(

 detailEnrollmentId, detailStudentId, detailStudentName,

 detailAddress, detailCity, detailState, detailZip, detailGrade

 );

 ReportResultsBuilder.populateCourseResults(

 resultsBox, reportRows, detailEnrollmentId, detailStudentId, detailStudentName,

 detailAddress, detailCity, detailState, detailZip, detailGrade

 );

 });

 clearButton.setOnAction(e -> {

 courseDropdown.getSelectionModel().clearSelection();

 semesterDropdown.getSelectionModel().clearSelection();

 FormUtils.clearFields(yearInput);

 FormUtils.clearFields(

 summaryCourse, summaryDepartment, summaryInstructor,

 summarySemester, summaryYear, summaryTotalStudents, summaryGradeBreakdown

 );

 ReportFieldFactory.clearDetailFields(

 detailEnrollmentId, detailStudentId, detailStudentName,

 detailAddress, detailCity, detailState, detailZip, detailGrade

 );

 ReportFieldFactory.resetResultsPlaceholder(resultsBox, "Generate a report to view results.");

 });

 mainColumn.getChildren().addAll(pageTitle, filterGrid, summaryPane, resultsPane, detailPane);

 root.getChildren().add(mainColumn);

 LayoutFactory.showCentered(borderPane, root);

 return root;

 }

 private static void loadCourseChoices(MyGenericList<Course> moduleCatalog, ComboBox<String> courseDropdown) {

 courseDropdown.getItems().clear();

 for (int i = 0; i < moduleCatalog.size(); i++) {

 courseDropdown.getItems().add(moduleCatalog.get(i).getCourseName());

 }

 }

 private static Course findCourseByName(MyGenericList<Course> moduleCatalog, String courseName) {

 for (int i = 0; i < moduleCatalog.size(); i++) {

 Course course = moduleCatalog.get(i);

 if (course.getCourseName().equalsIgnoreCase(courseName)) {

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
