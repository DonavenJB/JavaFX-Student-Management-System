package studentmanagement.ui.course;

import java.util.List;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import studentmanagement.collection.MyGenericList;
import studentmanagement.model.Course;
import studentmanagement.model.Department;
import studentmanagement.model.Instructor;
import studentmanagement.ui.common.FormUtils;

public final class CourseFormSupport {

 private CourseFormSupport() {

 }

 public static void loadDivisions(MyGenericList<Department> divisionCatalog, ComboBox<String> departmentDropdown) {
 ObservableList<String> departmentNames = FXCollections.observableArrayList();
 for (int i = 0; i < divisionCatalog.size(); i++) {
 Department department = divisionCatalog.get(i);
 departmentNames.add(department.getDepartmentName());
 }
 departmentDropdown.setItems(departmentNames);
 }

 public static void loadLecturersByDivision(String departmentName, MyGenericList<Department> divisionCatalog,
 MyGenericList<Instructor> lecturerCatalog,
 ComboBox<String> instructorDropdown) {
 Department selectedDepartment = null;
 for (int i = 0; i < divisionCatalog.size(); i++) {
 if (divisionCatalog.get(i).getDepartmentName().equals(departmentName)) {
 selectedDepartment = divisionCatalog.get(i);
 break;
 }
 }

 if (selectedDepartment != null) {
 int departmentID = selectedDepartment.getDepartmentId();
 List<Instructor> filteredInstructors = lecturerCatalog.fetchAllItems().stream()
 .filter(instructor -> instructor.getDepartmentId() == departmentID)
 .collect(Collectors.toList());
 ObservableList<String> instructorNames = FXCollections.observableArrayList(
 filteredInstructors.stream()
 .map(instructor -> instructor.getFirstName() + " " + instructor.getLastName())
 .collect(Collectors.toList())
 );
 instructorDropdown.setItems(instructorNames);
 } else {
 instructorDropdown.getItems().clear();
 }
 }

 public static Course findCourseByKey(MyGenericList<Course> moduleCatalog, int moduleKey) {
 for (int i = 0; i < moduleCatalog.size(); i++) {
 Course course = moduleCatalog.get(i);
 if (course.getCourseId() == moduleKey) {
 return course;
 }
 }

 return null;
 }

 public static int findCourseIndexByKey(MyGenericList<Course> moduleCatalog, int moduleKey) {
 for (int i = 0; i < moduleCatalog.size(); i++) {
 if (moduleCatalog.get(i).getCourseId() == moduleKey) {
 return i;
 }
 }

 return -1;
 }

 public static boolean containsCourseKey(MyGenericList<Course> moduleCatalog, int moduleKey) {
 return findCourseIndexByKey(moduleCatalog, moduleKey) != -1;
 }

 public static void clearCourseForm(ComboBox<String> departmentDropdown, ComboBox<String> instructorDropdown,
 TextField... fields) {
 FormUtils.clearFields(fields);
 FormUtils.resetComboBoxes(departmentDropdown, instructorDropdown);
 instructorDropdown.getItems().clear();
 }
}
