package studentmanagement.ui.instructor;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.TextField;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.GridPane;

import studentmanagement.collection.MyGenericList;

import studentmanagement.model.Instructor;

import studentmanagement.ui.common.AlertUtils;

import studentmanagement.ui.common.FormUtils;

import studentmanagement.ui.common.LayoutFactory;

public final class InstructorShowView {

 private InstructorShowView() {

 }

 public static GridPane build(BorderPane borderPane, MyGenericList<Instructor> lecturerCatalog) {

 GridPane grid = LayoutFactory.createFormGrid();

 Label departmentLabel = new Label("Department ID: ");

 GridPane.setConstraints(departmentLabel, 0, 3);

 TextField departmentInput = new TextField();

 GridPane.setConstraints(departmentInput, 1, 3);

 Label instructorIDLabel = new Label("Instructor ID: ");

 GridPane.setConstraints(instructorIDLabel, 0, 0);

 TextField instructorIDInput = new TextField();

 GridPane.setConstraints(instructorIDInput, 1, 0);

 Label lastNameLabel = new Label("Last Name: ");

 GridPane.setConstraints(lastNameLabel, 0, 2);

 TextField lastNameInput = new TextField();

 GridPane.setConstraints(lastNameInput, 1, 2);

 Label firstNameLabel = new Label("First Name: ");

 GridPane.setConstraints(firstNameLabel, 0, 1);

 TextField firstNameInput = new TextField();

 GridPane.setConstraints(firstNameInput, 1, 1);

 Button searchButton = new Button("Search");

 GridPane.setConstraints(searchButton, 2, 0);

 FormUtils.setEditable(false, firstNameInput, lastNameInput, departmentInput);

 searchButton.setOnAction(e -> {

 try {

 int lecturerKey = Integer.parseInt(instructorIDInput.getText().trim());

 Instructor instructor = InstructorFormSupport.findInstructorByKey(lecturerCatalog, lecturerKey);

 if (instructor != null) {

 firstNameInput.setText(instructor.getFirstName());

 lastNameInput.setText(instructor.getLastName());

 departmentInput.setText(String.valueOf(instructor.getDepartmentId()));

 } else {

 AlertUtils.showError("Form Error!", "Instructor with ID " + lecturerKey + " not found.");

 }

 } catch (NumberFormatException ex) {

 AlertUtils.showError("Form Error!", "Invalid instructor ID format.");

 }

 });

 grid.getChildren().addAll(

 departmentLabel, departmentInput,

 instructorIDLabel, instructorIDInput,

 lastNameLabel, lastNameInput,

 firstNameLabel, firstNameInput,

 searchButton

 );

 LayoutFactory.showCentered(borderPane, grid);

 return grid;

 }

}
