package studentmanagement.ui.course;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import studentmanagement.collection.MyGenericList;
import studentmanagement.handler.CourseHandler;
import studentmanagement.model.Course;
import studentmanagement.model.Department;
import studentmanagement.model.Instructor;
import studentmanagement.ui.common.AlertUtils;
import studentmanagement.ui.common.LayoutFactory;

public final class CourseCreateView {

 private CourseCreateView() {

 }

 public static GridPane build(BorderPane borderPane, MyGenericList<Course> moduleCatalog,
 MyGenericList<Department> divisionCatalog,
 MyGenericList<Instructor> lecturerCatalog,
 CourseHandler courseHandler, String coursesFile) {
 GridPane grid = LayoutFactory.createFormGrid();

 Label instructorLabel = new Label("Instructor: ");
 GridPane.setConstraints(instructorLabel, 0, 4);

 Label courseDescriptionLabel = new Label("Course Description: ");
 GridPane.setConstraints(courseDescriptionLabel, 0, 2);

 TextField courseDescriptionInput = new TextField();
 GridPane.setConstraints(courseDescriptionInput, 1, 2);

 Label courseIDLabel = new Label("Course ID: ");
 GridPane.setConstraints(courseIDLabel, 0, 0);

 TextField courseIDInput = new TextField();
 GridPane.setConstraints(courseIDInput, 1, 0);

 Label departmentLabel = new Label("Department: ");
 GridPane.setConstraints(departmentLabel, 0, 3);

 Label courseNameLabel = new Label("Course Name: ");
 GridPane.setConstraints(courseNameLabel, 0, 1);

 TextField courseNameInput = new TextField();
 GridPane.setConstraints(courseNameInput, 1, 1);

 ComboBox<String> instructorDropdown = new ComboBox<>();
 GridPane.setConstraints(instructorDropdown, 1, 4);

 ComboBox<String> departmentDropdown = new ComboBox<>();
 GridPane.setConstraints(departmentDropdown, 1, 3);

 Button addButton = new Button("Add Course");
 GridPane.setConstraints(addButton, 1, 5);

 CourseFormSupport.loadDivisions(divisionCatalog, departmentDropdown);
 departmentDropdown.setOnAction(e ->
 CourseFormSupport.loadLecturersByDivision(
 departmentDropdown.getValue(), divisionCatalog, lecturerCatalog, instructorDropdown
 )
 );

 addButton.setOnAction(e -> {
 try {
 int moduleKey = Integer.parseInt(courseIDInput.getText().trim());
 String moduleTitle = courseNameInput.getText().trim();
 String moduleSummary = courseDescriptionInput.getText().trim();
 String departmentName = departmentDropdown.getValue();
 String instructorName = instructorDropdown.getValue();

 if (moduleTitle.isEmpty() || moduleSummary.isEmpty() || departmentName == null || instructorName == null) {
 AlertUtils.showError("Form Error!", "Please enter all fields.");
 return;
 }

 if (CourseFormSupport.containsCourseKey(moduleCatalog, moduleKey)) {
 AlertUtils.showError("Form Error!", "Course with ID " + moduleKey + " already exists.");
 return;
 }

 Course course = new Course(moduleKey, moduleTitle, moduleSummary, departmentName, instructorName);
 moduleCatalog.add(course);
 moduleCatalog.sort();
 courseHandler.saveToFile(moduleCatalog, coursesFile);
 AlertUtils.showInfo("Success", "Course added successfully!");
 CourseFormSupport.clearCourseForm(
 departmentDropdown, instructorDropdown,
 courseIDInput, courseNameInput, courseDescriptionInput
 );
 } catch (NumberFormatException ex) {
 AlertUtils.showError("Form Error!", "Invalid course ID format.");
 }
 });

 grid.getChildren().addAll(
 instructorLabel, instructorDropdown,
 courseDescriptionLabel, courseDescriptionInput,
 courseIDLabel, courseIDInput,
 departmentLabel, departmentDropdown,
 courseNameLabel, courseNameInput,
 addButton
 );

 LayoutFactory.showCentered(borderPane, grid);
 return grid;
 }
}
