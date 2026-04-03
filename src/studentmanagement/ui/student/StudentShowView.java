package studentmanagement.ui.student;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.TextField;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.GridPane;

import studentmanagement.collection.MyGenericList;

import studentmanagement.model.Student;

import studentmanagement.ui.common.AlertUtils;

import studentmanagement.ui.common.LayoutFactory;

public final class StudentShowView {

 private StudentShowView() {

 }

 public static GridPane build(BorderPane borderPane, MyGenericList<Student> learnerCatalog) {

 GridPane grid = LayoutFactory.createFormGrid();

 Label zipLabel = new Label("Zip Code: ");

 GridPane.setConstraints(zipLabel, 0, 6);

 TextField zipInput = new TextField();

 GridPane.setConstraints(zipInput, 1, 6);

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

 Label stateLabel = new Label("State: ");

 GridPane.setConstraints(stateLabel, 0, 5);

 TextField stateInput = new TextField();

 GridPane.setConstraints(stateInput, 1, 5);

 Label addressLabel = new Label("Address: ");

 GridPane.setConstraints(addressLabel, 0, 3);

 TextField addressInput = new TextField();

 GridPane.setConstraints(addressInput, 1, 3);

 Button searchButton = new Button("Search");

 GridPane.setConstraints(searchButton, 2, 0);

 StudentFormSupport.configureReadOnlyStudentFields(

 firstNameInput, lastNameInput, addressInput, cityInput, stateInput, zipInput

 );

 searchButton.setOnAction(e -> {

 try {

 int learnerKey = Integer.parseInt(studentIDInput.getText().trim());

 Student student = StudentFormSupport.findStudentByKey(learnerCatalog, learnerKey);

 if (student != null) {

 StudentFormSupport.populateStudentFields(

 student, firstNameInput, lastNameInput, addressInput, cityInput, stateInput, zipInput

 );

 } else {

 AlertUtils.showError("Form Error!", "Student with ID " + learnerKey + " not found.");

 }

 } catch (NumberFormatException ex) {

 AlertUtils.showError("Form Error!", "Invalid student ID format.");

 }

 });

 grid.getChildren().addAll(

 zipLabel, zipInput,

 firstNameLabel, firstNameInput,

 studentIDLabel, studentIDInput,

 cityLabel, cityInput,

 lastNameLabel, lastNameInput,

 stateLabel, stateInput,

 addressLabel, addressInput,

 searchButton

 );

 LayoutFactory.showCentered(borderPane, grid);

 return grid;

 }

}
