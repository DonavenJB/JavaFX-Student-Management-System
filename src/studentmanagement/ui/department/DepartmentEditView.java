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

public final class DepartmentEditView {

 private DepartmentEditView() {

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

 Button updateButton = new Button("Update Department");

 GridPane.setConstraints(updateButton, 1, 3);

 Button findButton = new Button("Find Department");

 GridPane.setConstraints(findButton, 1, 2);

 findButton.setOnAction(e -> {

 try {

 int divisionKey = Integer.parseInt(deptIDInput.getText().trim());

 Department department = DepartmentFormSupport.findDepartmentByKey(divisionCatalog, divisionKey);

 if (department != null) {

 deptNameInput.setText(department.getDepartmentName());

 deptIDInput.setDisable(true);

 } else {

 AlertUtils.showError("Form Error!", "Department with ID " + divisionKey + " not found.");

 }

 } catch (NumberFormatException ex) {

 AlertUtils.showError("Form Error!", "Invalid department ID format.");

 }

 });

 updateButton.setOnAction(e -> {

 try {

 int divisionKey = Integer.parseInt(deptIDInput.getText().trim());

 String divisionTitle = deptNameInput.getText().trim();

 if (divisionTitle.isEmpty()) {

 AlertUtils.showError("Form Error!", "Please enter the department name.");

 return;

 }

 Department updatedDepartment = new Department(divisionKey, divisionTitle);

 int departmentIndex = DepartmentFormSupport.findDepartmentIndexByKey(divisionCatalog, divisionKey);

 if (departmentIndex != -1) {

 divisionCatalog.delete(departmentIndex);

 divisionCatalog.add(updatedDepartment);

 divisionCatalog.sort();

 departmentHandler.saveToFile(divisionCatalog, departmentsFile);

 AlertUtils.showInfo("Success", "Department updated successfully!");

 DepartmentFormSupport.clearDepartmentFields(deptIDInput, deptNameInput);

 deptIDInput.setDisable(false);

 } else {

 AlertUtils.showError("Update Error", "Failed to update department. Department not found.");

 }

 } catch (NumberFormatException ex) {

 AlertUtils.showError("Form Error!", "Invalid department ID format.");

 }

 });

 grid.getChildren().addAll(

 deptNameLabel, deptNameInput,

 deptIDLabel, deptIDInput,

 updateButton, findButton

 );

 LayoutFactory.showCentered(borderPane, grid);

 return grid;

 }

}
