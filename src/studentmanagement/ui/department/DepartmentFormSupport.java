package studentmanagement.ui.department;

import javafx.scene.control.TextField;

import studentmanagement.collection.MyGenericList;

import studentmanagement.model.Department;

import studentmanagement.ui.common.FormUtils;

public final class DepartmentFormSupport {

 private DepartmentFormSupport() {

 }

 public static Department findDepartmentByKey(MyGenericList<Department> divisionCatalog, int divisionKey) {

 for (int i = 0; i < divisionCatalog.size(); i++) {

 Department department = divisionCatalog.get(i);

 if (department.getDepartmentId() == divisionKey) {

 return department;

 }

 }

 return null;

 }

 public static int findDepartmentIndexByKey(MyGenericList<Department> divisionCatalog, int divisionKey) {

 for (int i = 0; i < divisionCatalog.size(); i++) {

 if (divisionCatalog.get(i).getDepartmentId() == divisionKey) {

 return i;

 }

 }

 return -1;

 }

 public static boolean containsDepartmentKey(MyGenericList<Department> divisionCatalog, int divisionKey) {

 return findDepartmentIndexByKey(divisionCatalog, divisionKey) != -1;

 }

 public static void clearDepartmentFields(TextField... fields) {

 FormUtils.clearFields(fields);

 }

}
