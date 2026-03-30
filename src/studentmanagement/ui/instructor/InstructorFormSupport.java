package studentmanagement.ui.instructor;

import javafx.collections.FXCollections;

import javafx.collections.ObservableList;

import javafx.scene.control.ComboBox;

import javafx.scene.control.TextField;

import studentmanagement.collection.MyGenericList;

import studentmanagement.model.Department;

import studentmanagement.model.Instructor;

import studentmanagement.ui.common.FormUtils;

public final class InstructorFormSupport {

 private InstructorFormSupport() {

 }

 public static void loadDivisions(MyGenericList<Department> divisionCatalog, ComboBox<Integer> departmentDropdown) {

 ObservableList<Integer> departmentIDs = FXCollections.observableArrayList();

 for (int i = 0; i < divisionCatalog.size(); i++) {

 Department department = divisionCatalog.get(i);

 departmentIDs.add(department.getDepartmentId());

 }

 departmentDropdown.setItems(departmentIDs);

 }

 public static Instructor findInstructorByKey(MyGenericList<Instructor> lecturerCatalog, int lecturerKey) {

 for (int i = 0; i < lecturerCatalog.size(); i++) {

 Instructor instructor = lecturerCatalog.get(i);

 if (instructor.getInstructorId() == lecturerKey) {

 return instructor;

 }

 }

 return null;

 }

 public static int findInstructorIndexByKey(MyGenericList<Instructor> lecturerCatalog, int lecturerKey) {

 for (int i = 0; i < lecturerCatalog.size(); i++) {

 if (lecturerCatalog.get(i).getInstructorId() == lecturerKey) {

 return i;

 }

 }

 return -1;

 }

 public static boolean containsInstructorKey(MyGenericList<Instructor> lecturerCatalog, int lecturerKey) {

 return findInstructorIndexByKey(lecturerCatalog, lecturerKey) != -1;

 }

 public static void clearInstructorForm(ComboBox<Integer> departmentDropdown, TextField... fields) {

 FormUtils.clearFields(fields);

 FormUtils.resetComboBoxes(departmentDropdown);

 }

}
