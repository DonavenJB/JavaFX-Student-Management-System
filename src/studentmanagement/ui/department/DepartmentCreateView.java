package studentmanagement.ui.department;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.TextField;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.GridPane;

import studentmanagement.collection.MyGenericList;

import studentmanagement.handler.DepartmentHandler;

import studentmanagement.model.Department;

import studentmanagement.ui.common.AlertUtils;

import studentmanagement.ui.common.LayoutFactory;

public final class DepartmentCreateView {

 private DepartmentCreateView() {

 }

 public static GridPane build(BorderPane borderPane, MyGenericList<Department> divisionCatalog,

 DepartmentHandler departmentHandler, String departmentsFile) {

 GridPane grid = LayoutFactory.createFormGrid();

 Label deptNameLabel = new Label("Department Name: ");

 GridPane.setConstraints(deptNameLabel, 0, 1);

 TextField deptNameInput = new TextField();

 GridPane.setConstraints(deptNameInput, 1, 1);

 Label deptIDLabel = new Label("Department ID: ");

 GridPane.setConstraints(deptIDLabel, 0, 0);

 TextField deptIDInput = new TextField();

 GridPane.setConstraints(deptIDInput, 1, 0);

 Button addButton = new Button("Add Department");

 GridPane.setConstraints(addButton, 1, 2);

 addButton.setOnAction(e -> {

 try {

 int divisionKey = Integer.parseInt(deptIDInput.getText().trim());

 String divisionTitle = deptNameInput.getText().trim();

 if (divisionTitle.isEmpty()) {

 AlertUtils.showError("Form Error!", "Please enter the department name.");

 return;

 }

 if (DepartmentFormSupport.containsDepartmentKey(divisionCatalog, divisionKey)) {

 AlertUtils.showError("Form Error!", "Department with ID " + divisionKey + " already exists.");

 return;

 }

 Department department = new Department(divisionKey, divisionTitle);

 divisionCatalog.add(department);

 divisionCatalog.sort();

 departmentHandler.saveToFile(divisionCatalog, departmentsFile);

 AlertUtils.showInfo("Success", "Department added successfully!");

 DepartmentFormSupport.clearDepartmentFields(deptIDInput, deptNameInput);

 } catch (NumberFormatException ex) {

 AlertUtils.showError("Form Error!", "Invalid department ID format.");

 }

 });

 grid.getChildren().addAll(

 deptNameLabel, deptNameInput,

 deptIDLabel, deptIDInput,

 addButton

 );

 LayoutFactory.showCentered(borderPane, grid);

 return grid;

 }

}
