package studentmanagement.ui.student;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.TextField;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.GridPane;

import studentmanagement.collection.MyGenericList;

import studentmanagement.handler.StudentHandler;

import studentmanagement.model.Student;

import studentmanagement.ui.common.AlertUtils;

import studentmanagement.ui.common.LayoutFactory;

public final class StudentEditView {

 private StudentEditView() {

 }

 public static GridPane build(BorderPane borderPane, MyGenericList<Student> learnerCatalog,

 StudentHandler studentHandler, String studentsFile) {

 GridPane grid = LayoutFactory.createFormGrid();

 Label studentZipCodeLabel = new Label("Zip Code: ");

 GridPane.setConstraints(studentZipCodeLabel, 0, 6);

 TextField studentZipCodeInput = new TextField();

 GridPane.setConstraints(studentZipCodeInput, 1, 6);

 Label firstNameLabel = new Label("First Name: ");

 GridPane.setConstraints(firstNameLabel, 0, 1);

 TextField firstNameInput = new TextField();

 GridPane.setConstraints(firstNameInput, 1, 1);

 Label studentIDLabel = new Label("Student ID: ");

 GridPane.setConstraints(studentIDLabel, 0, 0);

 TextField studentIDInput = new TextField();

 GridPane.setConstraints(studentIDInput, 1, 0);

 Label cityLabel = new Label("City: ");

 GridPane.setConstraints(cityLabel, 0, 4);

 TextField cityInput = new TextField();

 GridPane.setConstraints(cityInput, 1, 4);

 Label lastNameLabel = new Label("Last Name: ");

 GridPane.setConstraints(lastNameLabel, 0, 2);

 TextField lastNameInput = new TextField();

 GridPane.setConstraints(lastNameInput, 1, 2);

 Label studentStateLabel = new Label("State: ");

 GridPane.setConstraints(studentStateLabel, 0, 5);

 TextField studentStateInput = new TextField();

 GridPane.setConstraints(studentStateInput, 1, 5);

 Label studentAddressLabel = new Label("Address: ");

 GridPane.setConstraints(studentAddressLabel, 0, 3);

 TextField studentAddressInput = new TextField();

 GridPane.setConstraints(studentAddressInput, 1, 3);

 Button validateZipButton = new Button("Validate ZIP");

 GridPane.setConstraints(validateZipButton, 2, 6);

 Button updateButton = new Button("Update Student");

 GridPane.setConstraints(updateButton, 1, 7);

 Button findButton = new Button("Find Student");

 GridPane.setConstraints(findButton, 2, 0);

 StudentFormSupport.configureLocationFields(cityInput, studentStateInput);

 StudentFormSupport.attachZipResetOnChange(studentZipCodeInput, cityInput, studentStateInput);

 validateZipButton.setOnAction(e -> {

 if (StudentFormSupport.validateZipAndPopulate(studentZipCodeInput, cityInput, studentStateInput)) {

 StudentFormSupport.markZipAsValidated(studentZipCodeInput);

 }

 });

 findButton.setOnAction(e -> {

 try {

 int learnerKey = Integer.parseInt(studentIDInput.getText().trim());

 Student student = StudentFormSupport.findStudentByKey(learnerCatalog, learnerKey);

 if (student != null) {

 StudentFormSupport.populateEditableStudentFields(

 student, firstNameInput, lastNameInput,

 studentAddressInput, cityInput, studentStateInput, studentZipCodeInput

 );

 studentIDInput.setDisable(true);

 } else {

 AlertUtils.showError("Form Error!", "Student with ID " + learnerKey + " not found.");

 }

 } catch (NumberFormatException ex) {

 AlertUtils.showError("Form Error!", "Invalid student ID format.");

 }

 });

 updateButton.setOnAction(e -> {

 try {

 int learnerKey = Integer.parseInt(studentIDInput.getText().trim());

 String givenLabel = firstNameInput.getText().trim();

 String familyLabel = lastNameInput.getText().trim();

 String streetLine = studentAddressInput.getText().trim();

 String postalCode = studentZipCodeInput.getText().trim();

 if (givenLabel.isEmpty() || familyLabel.isEmpty() || streetLine.isEmpty() || postalCode.isEmpty()) {

 AlertUtils.showError("Form Error!", "Please enter all fields.");

 return;

 }

 if (StudentFormSupport.zipWasChanged(studentZipCodeInput)) {

 if (!StudentFormSupport.validateZipAndPopulate(studentZipCodeInput, cityInput, studentStateInput)) {

 return;

 }

 StudentFormSupport.markZipAsValidated(studentZipCodeInput);

 }

 String localArea = cityInput.getText().trim();

 String regionCode = studentStateInput.getText().trim();

 if (localArea.isEmpty() || regionCode.isEmpty()) {

 AlertUtils.showError("Form Error!", "Please validate the ZIP code so City and State are populated.");

 return;

 }

 Student updatedStudent = new Student(

 learnerKey, givenLabel, familyLabel, streetLine, localArea, regionCode, postalCode

 );

 int studentIndex = StudentFormSupport.findStudentIndexByKey(learnerCatalog, learnerKey);

 if (studentIndex != -1) {

 learnerCatalog.delete(studentIndex);

 learnerCatalog.add(updatedStudent);

 learnerCatalog.sort();

 studentHandler.saveToFile(learnerCatalog, studentsFile);

 AlertUtils.showInfo("Success", "Student updated successfully!");

 StudentFormSupport.clearStudentFields(

 studentIDInput, firstNameInput, lastNameInput,

 studentAddressInput, cityInput, studentStateInput, studentZipCodeInput

 );

 studentIDInput.setDisable(false);

 } else {

 AlertUtils.showError("Update Error", "Failed to update student. Student not found.");

 }

 } catch (NumberFormatException ex) {

 AlertUtils.showError("Form Error!", "Invalid student ID format.");

 }

 });

 grid.getChildren().addAll(

 studentZipCodeLabel, studentZipCodeInput,

 firstNameLabel, firstNameInput,

 studentIDLabel, studentIDInput,

 cityLabel, cityInput,

 lastNameLabel, lastNameInput,

 studentStateLabel, studentStateInput,

 studentAddressLabel, studentAddressInput,

 validateZipButton, findButton,

 updateButton

 );

 LayoutFactory.showCentered(borderPane, grid);

 return grid;

 }

}
