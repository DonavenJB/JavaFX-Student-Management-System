package studentmanagement.ui.report;

import java.util.List;

import javafx.geometry.Insets;

import javafx.scene.control.Label;

import javafx.scene.control.TextArea;

import javafx.scene.control.TextField;

import javafx.scene.layout.GridPane;

import javafx.scene.layout.VBox;

import studentmanagement.model.Course;

import studentmanagement.model.Enrollment;

import studentmanagement.model.Student;

public final class ReportResultsBuilder {

 private ReportResultsBuilder() {

 }

 public static final class CourseReportRowData {

 private final Enrollment enrollment;

 private final Student student;

 private final Course course;

 public CourseReportRowData(Enrollment enrollment, Student student, Course course) {

 this.enrollment = enrollment;

 this.student = student;

 this.course = course;

 }

 public Enrollment getEnrollment() {

 return enrollment;

 }

 public Student getStudent() {

 return student;

 }

 public Course getCourse() {

 return course;

 }

 }

 public static final class StudentReportRowData {

 private final Enrollment enrollment;

 private final Student student;

 private final Course course;

 public StudentReportRowData(Enrollment enrollment, Student student, Course course) {

 this.enrollment = enrollment;

 this.student = student;

 this.course = course;

 }

 public Enrollment getEnrollment() {

 return enrollment;

 }

 public Student getStudent() {

 return student;

 }

 public Course getCourse() {

 return course;

 }

 }

 public static String buildCourseGradeBreakdown(List<CourseReportRowData> reportRows) {

 int a = 0;

 int b = 0;

 int c = 0;

 int d = 0;

 int f = 0;

 int other = 0;

 for (CourseReportRowData row : reportRows) {

 char grade = Character.toUpperCase(row.getEnrollment().getGrade());

 switch (grade) {

 case 'A':

 a++;

 break;

 case 'B':

 b++;

 break;

 case 'C':

 c++;

 break;

 case 'D':

 d++;

 break;

 case 'F':

 f++;

 break;

 default:

 other++;

 break;

 }

 }

 String breakdown = "A: " + a + " B: " + b + " C: " + c + " D: " + d + " F: " + f;

 if (other > 0) {

 breakdown += " Other: " + other;

 }

 return breakdown;

 }

 public static void populateCourseResults(VBox resultsBox, List<CourseReportRowData> reportRows,

 TextField detailEnrollmentId, TextField detailStudentId,

 TextField detailStudentName, TextArea detailAddress,

 TextField detailCity, TextField detailState,

 TextField detailZip, TextField detailGrade) {

 resultsBox.getChildren().clear();

 resultsBox.getChildren().add(createHeaderRow(

 "Enrollment ID", 100,

 "Student ID", 100,

 "Name", 220,

 "City", 150,

 "State", 80,

 "Grade", 80

 ));

 if (reportRows.isEmpty()) {

 Label noResults = new Label("No records found for the selected course, semester, and year.");

 noResults.setPadding(new Insets(12, 12, 12, 12));

 resultsBox.getChildren().add(noResults);

 return;

 }

 GridPane[] selectedRow = new GridPane[1];

 String[] selectedBaseStyle = new String[1];

 for (int i = 0; i < reportRows.size(); i++) {

 CourseReportRowData rowData = reportRows.get(i);

 String baseStyle = stripedStyle(i);

 GridPane row = createDataRow(

 baseStyle,

 String.valueOf(rowData.getEnrollment().getRegistrationId()), 100,

 String.valueOf(rowData.getStudent().getStudentId()), 100,

 rowData.getStudent().getName(), 220,

 rowData.getStudent().getCity(), 150,

 rowData.getStudent().getState(), 80,

 String.valueOf(rowData.getEnrollment().getGrade()), 80

 );

 row.setOnMouseClicked(event -> {

 restoreSelectedRow(selectedRow, selectedBaseStyle);

 row.setStyle(selectedStyle());

 selectedRow[0] = row;

 selectedBaseStyle[0] = baseStyle;

 detailEnrollmentId.setText(String.valueOf(rowData.getEnrollment().getRegistrationId()));

 detailStudentId.setText(String.valueOf(rowData.getStudent().getStudentId()));

 detailStudentName.setText(rowData.getStudent().getName());

 detailAddress.setText(rowData.getStudent().getStreetLine());

 detailCity.setText(rowData.getStudent().getCity());

 detailState.setText(rowData.getStudent().getState());

 detailZip.setText(rowData.getStudent().getZipCode());

 detailGrade.setText(String.valueOf(rowData.getEnrollment().getGrade()));

 });

 resultsBox.getChildren().add(row);

 }

 }

 public static void populateStudentResults(VBox resultsBox, List<StudentReportRowData> reportRows,

 TextField detailEnrollmentId, TextField detailCourseId,

 TextField detailCourseName, TextArea detailCourseDescription,

 TextField detailDepartment, TextField detailInstructor,

 TextField detailSemester, TextField detailYear,

 TextField detailGrade) {

 resultsBox.getChildren().clear();

 resultsBox.getChildren().add(createHeaderRow(

 "Enrollment ID", 100,

 "Course ID", 100,

 "Course Name", 220,

 "Semester", 120,

 "Year", 100,

 "Grade", 80

 ));

 if (reportRows.isEmpty()) {

 Label noResults = new Label("No enrollments found for the selected student.");

 noResults.setPadding(new Insets(12, 12, 12, 12));

 resultsBox.getChildren().add(noResults);

 return;

 }

 GridPane[] selectedRow = new GridPane[1];

 String[] selectedBaseStyle = new String[1];

 for (int i = 0; i < reportRows.size(); i++) {

 StudentReportRowData rowData = reportRows.get(i);

 String baseStyle = stripedStyle(i);

 GridPane row = createDataRow(

 baseStyle,

 String.valueOf(rowData.getEnrollment().getRegistrationId()), 100,

 String.valueOf(rowData.getCourse().getCourseId()), 100,

 rowData.getCourse().getCourseName(), 220,

 rowData.getEnrollment().getSemester(), 120,

 rowData.getEnrollment().getYear(), 100,

 String.valueOf(rowData.getEnrollment().getGrade()), 80

 );

 row.setOnMouseClicked(event -> {

 restoreSelectedRow(selectedRow, selectedBaseStyle);

 row.setStyle(selectedStyle());

 selectedRow[0] = row;

 selectedBaseStyle[0] = baseStyle;

 detailEnrollmentId.setText(String.valueOf(rowData.getEnrollment().getRegistrationId()));

 detailCourseId.setText(String.valueOf(rowData.getCourse().getCourseId()));

 detailCourseName.setText(rowData.getCourse().getCourseName());

 detailCourseDescription.setText(rowData.getCourse().getCourseDescription());

 detailDepartment.setText(rowData.getCourse().getDepartmentName());

 detailInstructor.setText(rowData.getCourse().getInstructorName());

 detailSemester.setText(rowData.getEnrollment().getSemester());

 detailYear.setText(rowData.getEnrollment().getYear());

 detailGrade.setText(String.valueOf(rowData.getEnrollment().getGrade()));

 });

 resultsBox.getChildren().add(row);

 }

 }

 public static void populateStudentExceptionResults(VBox resultsBox, List<Student> students,

 TextField detailPrimaryField, TextField detailNameField,

 TextArea detailTextArea, TextField detailField4,

 TextField detailField5) {

 resultsBox.getChildren().clear();

 resultsBox.getChildren().add(createHeaderRow(

 "Student ID", 120,

 "Name", 250,

 "City", 180,

 "State", 100

 ));

 if (students.isEmpty()) {

 Label noResults = new Label("No exception records found.");

 noResults.setPadding(new Insets(12, 12, 12, 12));

 resultsBox.getChildren().add(noResults);

 return;

 }

 GridPane[] selectedRow = new GridPane[1];

 String[] selectedBaseStyle = new String[1];

 for (int i = 0; i < students.size(); i++) {

 Student student = students.get(i);

 String baseStyle = stripedStyle(i);

 GridPane row = createDataRow(

 baseStyle,

 String.valueOf(student.getStudentId()), 120,

 student.getName(), 250,

 student.getCity(), 180,

 student.getState(), 100

 );

 row.setOnMouseClicked(event -> {

 restoreSelectedRow(selectedRow, selectedBaseStyle);

 row.setStyle(selectedStyle());

 selectedRow[0] = row;

 selectedBaseStyle[0] = baseStyle;

 detailPrimaryField.setText(String.valueOf(student.getStudentId()));

 detailNameField.setText(student.getName());

 detailTextArea.setText(student.getStreetLine());

 detailField4.setText(student.getCity());

 detailField5.setText(student.getState() + " / " + student.getZipCode());

 });

 resultsBox.getChildren().add(row);

 }

 }

 public static void populateCourseExceptionResults(VBox resultsBox, List<Course> courses,

 TextField detailPrimaryField, TextField detailNameField,

 TextArea detailTextArea, TextField detailField4,

 TextField detailField5) {

 resultsBox.getChildren().clear();

 resultsBox.getChildren().add(createHeaderRow(

 "Course ID", 120,

 "Course Name", 250,

 "Department", 180,

 "Instructor", 180

 ));

 if (courses.isEmpty()) {

 Label noResults = new Label("No exception records found.");

 noResults.setPadding(new Insets(12, 12, 12, 12));

 resultsBox.getChildren().add(noResults);

 return;

 }

 GridPane[] selectedRow = new GridPane[1];

 String[] selectedBaseStyle = new String[1];

 for (int i = 0; i < courses.size(); i++) {

 Course course = courses.get(i);

 String baseStyle = stripedStyle(i);

 GridPane row = createDataRow(

 baseStyle,

 String.valueOf(course.getCourseId()), 120,

 course.getCourseName(), 250,

 course.getDepartmentName(), 180,

 course.getInstructorName(), 180

 );

 row.setOnMouseClicked(event -> {

 restoreSelectedRow(selectedRow, selectedBaseStyle);

 row.setStyle(selectedStyle());

 selectedRow[0] = row;

 selectedBaseStyle[0] = baseStyle;

 detailPrimaryField.setText(String.valueOf(course.getCourseId()));

 detailNameField.setText(course.getCourseName());

 detailTextArea.setText(course.getCourseDescription());

 detailField4.setText(course.getDepartmentName());

 detailField5.setText(course.getInstructorName());

 });

 resultsBox.getChildren().add(row);

 }

 }

 private static GridPane createHeaderRow(Object... values) {

 GridPane row = new GridPane();

 row.setHgap(10);

 row.setPadding(new Insets(8, 12, 8, 12));

 row.setStyle("-fx-background-color: #dddddd;");

 int column = 0;

 for (int i = 0; i < values.length; i += 2) {

 String text = (String) values[i];

 double width = ((Number) values[i + 1]).doubleValue();

 row.add(createHeaderLabel(text, width), column, 0);

 column++;

 }

 return row;

 }

 private static GridPane createDataRow(String style, Object... values) {

 GridPane row = new GridPane();

 row.setHgap(10);

 row.setPadding(new Insets(8, 12, 8, 12));

 row.setStyle(style);

 int column = 0;

 for (int i = 0; i < values.length; i += 2) {

 String text = (String) values[i];

 double width = ((Number) values[i + 1]).doubleValue();

 row.add(createDataLabel(text, width), column, 0);

 column++;

 }

 return row;

 }

 private static Label createHeaderLabel(String text, double width) {

 Label label = new Label(text);

 label.setPrefWidth(width);

 label.setMinWidth(width);

 label.setMaxWidth(width);

 label.setStyle("-fx-font-weight: bold;");

 return label;

 }

 private static Label createDataLabel(String text, double width) {

 Label label = new Label(text);

 label.setPrefWidth(width);

 label.setMinWidth(width);

 label.setMaxWidth(width);

 return label;

 }

 private static String stripedStyle(int index) {

 return (index % 2 == 0)

 ? "-fx-background-color: white; -fx-border-color: #dddddd; -fx-border-width: 0 0 1 0;"

 : "-fx-background-color: #f6f6f6; -fx-border-color: #dddddd; -fx-border-width: 0 0 1 0;";

 }

 private static String selectedStyle() {

 return "-fx-background-color: #dfe9f7; -fx-border-color: #c8d6ea; -fx-border-width: 0 0 1 0;";

 }

 private static void restoreSelectedRow(GridPane[] selectedRow, String[] selectedBaseStyle) {

 if (selectedRow[0] != null) {

 selectedRow[0].setStyle(selectedBaseStyle[0]);

 }

 }

}
