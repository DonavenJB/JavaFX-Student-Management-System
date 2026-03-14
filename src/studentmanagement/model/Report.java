package studentmanagement.model;

public class Report {

 private Student student;

 private char grade;

 public Report(Student student, char grade) {

 this.student = student;

 this.grade = grade;

 }

 public Student getStudent() {

 return student;

 }

 public void setStudent(Student student) {

 this.student = student;

 }

 public char getGrade() {

 return grade;

 }

 public void setGrade(char grade) {

 this.grade = grade;

 }

 @Override

 public String toString() {

 return "Student: " + student.getName() + ", Grade: " + grade;

 }

}
