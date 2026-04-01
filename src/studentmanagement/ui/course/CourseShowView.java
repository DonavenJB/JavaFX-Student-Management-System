package studentmanagement.ui.course;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.TextField;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.GridPane;

import studentmanagement.collection.MyGenericList;

import studentmanagement.model.Course;

import studentmanagement.ui.common.AlertUtils;

import studentmanagement.ui.common.FormUtils;

import studentmanagement.ui.common.LayoutFactory;

public final class CourseShowView {

 private CourseShowView() {

 }

 public static GridPane build(BorderPane borderPane, MyGenericList<Course> moduleCatalog) {

 GridPane grid = LayoutFactory.createFormGrid();

 Label courseIDLabel = new Label("Course ID: ");

 GridPane.setConstraints(courseIDLabel, 0, 0);

 TextField courseIDInput = new TextField();

 GridPane.setConstraints(courseIDInput, 1, 0);

 Label courseNameLabel = new Label("Course Name: ");

 GridPane.setConstraints(courseNameLabel, 0, 1);

 TextField courseNameInput = new TextField();

 GridPane.setConstraints(courseNameInput, 1, 1);

 Label courseDescriptionLabel = new Label("Course Description: ");

 GridPane.setConstraints(courseDescriptionLabel, 0, 2);

 TextField courseDescriptionInput = new TextField();

 GridPane.setConstraints(courseDescriptionInput, 1, 2);

 Label departmentLabel = new Label("Department: ");

 GridPane.setConstraints(departmentLabel, 0, 3);

 TextField departmentInput = new TextField();

 GridPane.setConstraints(departmentInput, 1, 3);

 Label instructorLabel = new Label("Instructor: ");

 GridPane.setConstraints(instructorLabel, 0, 4);

 TextField instructorInput = new TextField();

 GridPane.setConstraints(instructorInput, 1, 4);

 Button searchButton = new Button("Search");

 GridPane.setConstraints(searchButton, 2, 0);

 FormUtils.setEditable(false, courseNameInput, courseDescriptionInput, departmentInput, instructorInput);

 searchButton.setOnAction(e -> {

 try {

 int moduleKey = Integer.parseInt(courseIDInput.getText().trim());

 Course course = CourseFormSupport.findCourseByKey(moduleCatalog, moduleKey);

 if (course != null) {

 courseNameInput.setText(course.getCourseName());

 courseDescriptionInput.setText(course.getCourseDescription());

 departmentInput.setText(course.getDepartmentName());

 instructorInput.setText(course.getInstructorName());

 } else {

 AlertUtils.showError("Form Error!", "Course with ID " + moduleKey + " not found.");

 }

 } catch (NumberFormatException ex) {

 AlertUtils.showError("Form Error!", "Invalid course ID format.");

 }

 });

 grid.getChildren().addAll(

 courseIDLabel, courseIDInput,

 courseNameLabel, courseNameInput,

 courseDescriptionLabel, courseDescriptionInput,

 departmentLabel, departmentInput,

 instructorLabel, instructorInput,

 searchButton

 );

 LayoutFactory.showCentered(borderPane, grid);

 return grid;

 }

}
