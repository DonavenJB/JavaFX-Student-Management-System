package studentmanagement.ui.instructor;

import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;

import javafx.scene.control.Label;

import javafx.scene.control.TextField;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.GridPane;

import studentmanagement.collection.MyGenericList;

import studentmanagement.handler.InstructorHandler;

import studentmanagement.model.Department;

import studentmanagement.model.Instructor;

import studentmanagement.ui.common.AlertUtils;

import studentmanagement.ui.common.LayoutFactory;

public final class InstructorEditView {

 private InstructorEditView() {

 }

 public static GridPane build(BorderPane borderPane, MyGenericList<Instructor> lecturerCatalog,

 MyGenericList<Department> divisionCatalog,

 InstructorHandler instructorHandler, String instructorsFile) {

 GridPane grid = LayoutFactory.createFormGrid();

 Label departmentLabel = new Label("Department: ");

 GridPane.setConstraints(departmentLabel, 0, 3);

 Label idLabel = new Label("Instructor ID: ");

 GridPane.setConstraints(idLabel, 0, 0);

 TextField idInput = new TextField();

 GridPane.setConstraints(idInput, 1, 0);

 Label lastNameLabel = new Label("Last Name: ");

 GridPane.setConstraints(lastNameLabel, 0, 2);

 TextField lastNameInput = new TextField();

 GridPane.setConstraints(lastNameInput, 1, 2);

 Label firstNameLabel = new Label("First Name: ");

 GridPane.setConstraints(firstNameLabel, 0, 1);

 TextField firstNameInput = new TextField();

 GridPane.setConstraints(firstNameInput, 1, 1);

 ComboBox<Integer> departmentDropdown = new ComboBox<>();

 GridPane.setConstraints(departmentDropdown, 1, 3);

 InstructorFormSupport.loadDivisions(divisionCatalog, departmentDropdown);

 Button updateButton = new Button("Update Instructor");

 GridPane.setConstraints(updateButton, 1, 5);

 Button findButton = new Button("Find Instructor");

 GridPane.setConstraints(findButton, 1, 4);

 findButton.setOnAction(e -> {

 try {

 int lecturerKey = Integer.parseInt(idInput.getText().trim());

 Instructor instructor = InstructorFormSupport.findInstructorByKey(lecturerCatalog, lecturerKey);

 if (instructor != null) {

 firstNameInput.setText(instructor.getFirstName());

 lastNameInput.setText(instructor.getLastName());

 departmentDropdown.setValue(instructor.getDepartmentId());

 idInput.setDisable(true);

 } else {

 AlertUtils.showError("Form Error!", "Instructor with ID " + lecturerKey + " not found.");

 }

 } catch (NumberFormatException ex) {

 AlertUtils.showError("Form Error!", "Invalid instructor ID format.");

 }

 });

 updateButton.setOnAction(e -> {

 try {

 int lecturerKey = Integer.parseInt(idInput.getText().trim());

 String givenLabel = firstNameInput.getText().trim();

 String familyLabel = lastNameInput.getText().trim();

 Integer divisionKey = departmentDropdown.getValue();

 if (givenLabel.isEmpty() || familyLabel.isEmpty() || divisionKey == null) {

 AlertUtils.showError("Form Error!", "Please enter all fields.");

 return;

 }

 Instructor updatedInstructor = new Instructor(lecturerKey, givenLabel, familyLabel, divisionKey);

 int instructorIndex = InstructorFormSupport.findInstructorIndexByKey(lecturerCatalog, lecturerKey);

 if (instructorIndex != -1) {

 lecturerCatalog.delete(instructorIndex);

 lecturerCatalog.add(updatedInstructor);

 lecturerCatalog.sort();

 instructorHandler.saveToFile(lecturerCatalog, instructorsFile);

 AlertUtils.showInfo("Success", "Instructor updated successfully!");

 InstructorFormSupport.clearInstructorForm(departmentDropdown, idInput, firstNameInput, lastNameInput);

 idInput.setDisable(false);

 } else {

 AlertUtils.showError("Update Error", "Failed to update instructor. Instructor not found.");

 }

 } catch (NumberFormatException ex) {

 AlertUtils.showError("Form Error!", "Invalid instructor ID format.");

 }

 });

 grid.getChildren().addAll(

 departmentLabel, departmentDropdown,

 idLabel, idInput,

 lastNameLabel, lastNameInput,

 firstNameLabel, firstNameInput,

 updateButton, findButton

 );

 LayoutFactory.showCentered(borderPane, grid);

 return grid;

 }

}
