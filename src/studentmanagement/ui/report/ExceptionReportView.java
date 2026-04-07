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

public final class ExceptionReportView {

 private ExceptionReportView() {

 }

 public static GridPane build(BorderPane borderPane, MyGenericList<Enrollment> registrationCatalog,

 MyGenericList<Student> learnerCatalog, MyGenericList<Course> moduleCatalog) {

 GridPane root = ReportFieldFactory.createRootPane();

 VBox mainColumn = ReportFieldFactory.createMainColumn();

 Label pageTitle = ReportFieldFactory.createPageTitle("Exceptions");

 ComboBox<String> exceptionTypeDropdown = new ComboBox<>();

 exceptionTypeDropdown.getItems().addAll(

 "Students with No Enrollments",

 "Courses with No Enrollments"

 );

 exceptionTypeDropdown.setPromptText("Select Exception Type");

 exceptionTypeDropdown.setPrefWidth(320);

 Button generateButton = new Button("Generate Report");

 Button clearButton = new Button("Clear");

 GridPane filterGrid = ReportFieldFactory.createTwoColumnFilterGrid();

 filterGrid.add(new Label("Exception Type:"), 0, 0);

 filterGrid.add(exceptionTypeDropdown, 1, 0);

 filterGrid.add(ReportFieldFactory.centeredButtons(generateButton, clearButton), 0, 1, 2, 1);

 TextField summaryType = ReportFieldFactory.summaryField("Type");

 TextField summaryTotal = ReportFieldFactory.summaryField("Total Records");

 TextField summaryGuidance = ReportFieldFactory.summaryField("Guidance");

 GridPane summaryGrid = ReportFieldFactory.createFourColumnSummaryGrid();

 summaryGrid.add(new Label("Type:"), 0, 0);

 summaryGrid.add(summaryType, 1, 0);

 summaryGrid.add(new Label("Total Records:"), 2, 0);

 summaryGrid.add(summaryTotal, 3, 0);

 summaryGrid.add(new Label("Guidance:"), 0, 1);

 summaryGrid.add(summaryGuidance, 1, 1, 3, 1);

 TitledPane summaryPane = ReportFieldFactory.titledPane("Report Summary", summaryGrid, 860);

 VBox resultsBox = ReportFieldFactory.createResultsBoxWithPlaceholder("Generate a report to view results.");

 ScrollPane resultsScrollPane = ReportFieldFactory.resultsScrollPane(resultsBox);

 TitledPane resultsPane = ReportFieldFactory.titledPane("Report Results", resultsScrollPane, 860);

 Label detailPrimaryLabel = new Label("Record ID:");

 Label detailNameLabel = new Label("Name:");

 Label detailTextAreaLabel = new Label("Details:");

 Label detailField4Label = new Label("Field 4:");

 Label detailField5Label = new Label("Field 5:");

 TextField detailPrimaryField = ReportFieldFactory.summaryField("Primary");

 TextField detailNameField = ReportFieldFactory.summaryField("Name");

 TextArea detailTextArea = ReportFieldFactory.summaryArea("Details");

 TextField detailField4 = ReportFieldFactory.summaryField("Field 4");

 TextField detailField5 = ReportFieldFactory.summaryField("Field 5");

 GridPane detailGrid = ReportFieldFactory.createFourColumnSummaryGrid();

 detailGrid.add(detailPrimaryLabel, 0, 0);

 detailGrid.add(detailPrimaryField, 1, 0);

 detailGrid.add(detailNameLabel, 2, 0);

 detailGrid.add(detailNameField, 3, 0);

 detailGrid.add(detailTextAreaLabel, 0, 1);

 detailGrid.add(detailTextArea, 1, 1, 3, 1);

 detailGrid.add(detailField4Label, 0, 2);

 detailGrid.add(detailField4, 1, 2);

 detailGrid.add(detailField5Label, 2, 2);

 detailGrid.add(detailField5, 3, 2);

 TitledPane detailPane = ReportFieldFactory.titledPane("Selected Record", detailGrid, 860);

 generateButton.setOnAction(e -> {

 String selectedType = exceptionTypeDropdown.getValue();

 if (selectedType == null) {

 AlertUtils.showError("Form Error!", "Please select an exception type.");

 return;

 }

 summaryType.setText(selectedType);

 ReportFieldFactory.clearDetailFields(

 detailPrimaryField, detailNameField, detailTextArea, detailField4, detailField5

 );

 if (selectedType.equals("Students with No Enrollments")) {

 List<Student> unmatchedStudents = new ArrayList<>();

 for (Student student : learnerCatalog.fetchAllItems()) {

 boolean found = false;

 for (Enrollment enrollment : registrationCatalog.fetchAllItems()) {

 if (enrollment.getStudentId() == student.getStudentId()) {

 found = true;

 break;

 }

 }

 if (!found) {

 unmatchedStudents.add(student);

 }

 }

 summaryTotal.setText(String.valueOf(unmatchedStudents.size()));

 summaryGuidance.setText("These students may need new enrollments or review.");

 detailPrimaryLabel.setText("Student ID:");

 detailNameLabel.setText("Student Name:");

 detailTextAreaLabel.setText("Address:");

 detailField4Label.setText("City:");

 detailField5Label.setText("State / ZIP:");

 ReportResultsBuilder.populateStudentExceptionResults(

 resultsBox, unmatchedStudents, detailPrimaryField, detailNameField, detailTextArea,

 detailField4, detailField5

 );

 } else {

 List<Course> emptyCourses = new ArrayList<>();

 for (Course course : moduleCatalog.fetchAllItems()) {

 boolean found = false;

 for (Enrollment enrollment : registrationCatalog.fetchAllItems()) {

 if (enrollment.getCourseId() == course.getCourseId()) {

 found = true;

 break;

 }

 }

 if (!found) {

 emptyCourses.add(course);

 }

 }

 summaryTotal.setText(String.valueOf(emptyCourses.size()));

 summaryGuidance.setText("These courses may need enrollments or review.");

 detailPrimaryLabel.setText("Course ID:");

 detailNameLabel.setText("Course Name:");

 detailTextAreaLabel.setText("Description:");

 detailField4Label.setText("Department:");

 detailField5Label.setText("Instructor:");

 ReportResultsBuilder.populateCourseExceptionResults(

 resultsBox, emptyCourses, detailPrimaryField, detailNameField, detailTextArea,

 detailField4, detailField5

 );

 }

 });

 clearButton.setOnAction(e -> {

 exceptionTypeDropdown.getSelectionModel().clearSelection();

 FormUtils.clearFields(summaryType, summaryTotal, summaryGuidance);

 detailPrimaryLabel.setText("Record ID:");

 detailNameLabel.setText("Name:");

 detailTextAreaLabel.setText("Details:");

 detailField4Label.setText("Field 4:");

 detailField5Label.setText("Field 5:");

 ReportFieldFactory.clearDetailFields(

 detailPrimaryField, detailNameField, detailTextArea, detailField4, detailField5

 );

 ReportFieldFactory.resetResultsPlaceholder(resultsBox, "Generate a report to view results.");

 });

 mainColumn.getChildren().addAll(pageTitle, filterGrid, summaryPane, resultsPane, detailPane);

 root.getChildren().add(mainColumn);

 LayoutFactory.showCentered(borderPane, root);

 return root;

 }

}
