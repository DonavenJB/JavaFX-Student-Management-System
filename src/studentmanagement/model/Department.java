package studentmanagement.model;

public class Department implements Comparable<Department> {

 private int departmentId;

 private String departmentName;

 public Department() {

 }

 public Department(int departmentId, String departmentName) {

 this.departmentId = departmentId;

 this.departmentName = departmentName;

 }

 public int getDepartmentId() {

 return departmentId;

 }

 public void setDepartmentId(int departmentId) {

 this.departmentId = departmentId;

 }

 public String getDepartmentName() {

 return departmentName;

 }

 public void setDepartmentName(String departmentName) {

 this.departmentName = departmentName;

 }

 @Override

 public int compareTo(Department other) {

 return this.departmentName.compareToIgnoreCase(other.departmentName);

 }

 @Override

 public String toString() {

 return departmentId + " | " + departmentName;

 }

}
