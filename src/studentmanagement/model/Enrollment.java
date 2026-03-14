package studentmanagement.model;

public class Enrollment implements Comparable<Enrollment> {

 private int registrationId;

 private int studentId;

 private int courseId;

 private String semester;

 private String year;

 private char grade;

 public Enrollment() {

 }

 public Enrollment(int registrationId, int studentId, int courseId, String semester, String year, char grade) {

 this.registrationId = registrationId;

 this.studentId = studentId;

 this.courseId = courseId;

 this.semester = semester;

 this.year = year;

 this.grade = grade;

 }

 public int getRegistrationId() {

 return registrationId;

 }

 public void setRegistrationId(int registrationId) {

 this.registrationId = registrationId;

 }

 public int getStudentId() {

 return studentId;

 }

 public void setStudentId(int studentId) {

 this.studentId = studentId;

 }

 public int getCourseId() {

 return courseId;

 }

 public void setCourseId(int courseId) {

 this.courseId = courseId;

 }

 public String getSemester() {

 return semester;

 }

 public void setSemester(String semester) {

 this.semester = semester;

 }

 public String getYear() {

 return year;

 }

 public void setYear(String year) {

 this.year = year;

 }

 public char getGrade() {

 return grade;

 }

 public void setGrade(char grade) {

 this.grade = grade;

 }

 @Override

 public int compareTo(Enrollment other) {

 return Integer.compare(this.registrationId, other.registrationId);

 }

 @Override

 public String toString() {

 return "Enrollment ID: " + registrationId + "\n" +

 "Student ID: " + studentId + "\n" +

 "Course ID: " + courseId + "\n" +

 "Semester: " + semester + "\n" +

 "Year: " + year + "\n" +

 "Grade: " + grade;

 }

}
