package studentmanagement.handler;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileWriter;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.Scanner;

import studentmanagement.collection.MyGenericList;

import studentmanagement.model.Course;

public class CourseHandler implements EntityHandler<Course> {

 @Override

 public int fetchKey(Course course) {

 return course.getCourseId();

 }

 @Override

 public Course decodeRecord(String data) {

 try {

 String[] parts = data.split(",");

 if (parts.length < 5) {

 return null;

 }

 int courseId = Integer.parseInt(parts[0].trim());

 String courseName = parts[1].trim();

 String courseDescription = parts[2].trim();

 String departmentName = parts[3].trim();

 String instructorName = parts[4].trim();

 return new Course(courseId, courseName, courseDescription, departmentName, instructorName);

 } catch (Exception e) {

 return null;

 }

 }

 @Override

 public String composeRecord(Course course) {

 return course.getCourseId() + "," +

 course.getCourseName() + "," +

 course.getCourseDescription() + "," +

 course.getDepartmentName() + "," +

 course.getInstructorName();

 }

 public MyGenericList<Course> loadFromFile(String fileName) {

 MyGenericList<Course> courses = new MyGenericList<>();

 File file = new File(fileName);

 if (!file.exists()) {

 return courses;

 }

 try (Scanner scanner = new Scanner(file)) {

 while (scanner.hasNextLine()) {

 String line = scanner.nextLine().trim();

 if (line.isEmpty()) {

 continue;

 }

 Course course = decodeRecord(line);

 if (course != null) {

 courses.add(course);

 }

 }

 } catch (FileNotFoundException e) {

 System.out.println("Course file not found: " + fileName);

 }

 return courses;

 }

 public void saveToFile(MyGenericList<Course> courses, String fileName) {

 try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

 for (Course course : courses.fetchAllItems()) {

 writer.println(composeRecord(course));

 }

 } catch (IOException e) {

 System.out.println("Error saving course file: " + fileName);

 }

 }

}

package studentmanagement.handler;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileWriter;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.Scanner;

import studentmanagement.collection.MyGenericList;

import studentmanagement.model.Department;

public class DepartmentHandler implements EntityHandler<Department> {

 @Override

 public int fetchKey(Department department) {

 return department.getDepartmentId();

 }

 @Override

 public Department decodeRecord(String data) {

 try {

 String[] parts = data.split(",");

 if (parts.length < 2) {

 return null;

 }

 int departmentId = Integer.parseInt(parts[0].trim());

 String departmentName = parts[1].trim();

 return new Department(departmentId, departmentName);

 } catch (Exception e) {

 return null;

 }

 }

 @Override

 public String composeRecord(Department department) {

 return department.getDepartmentId() + "," +

 department.getDepartmentName();

 }

 public MyGenericList<Department> loadFromFile(String fileName) {

 MyGenericList<Department> departments = new MyGenericList<>();

 File file = new File(fileName);

 if (!file.exists()) {

 return departments;

 }

 try (Scanner scanner = new Scanner(file)) {

 while (scanner.hasNextLine()) {

 String line = scanner.nextLine().trim();

 if (line.isEmpty()) {

 continue;

 }

 Department department = decodeRecord(line);

 if (department != null) {

 departments.add(department);

 }

 }

 } catch (FileNotFoundException e) {

 System.out.println("Department file not found: " + fileName);

 }

 return departments;

 }

 public void saveToFile(MyGenericList<Department> departments, String fileName) {

 try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

 for (Department department : departments.fetchAllItems()) {

 writer.println(composeRecord(department));

 }

 } catch (IOException e) {

 System.out.println("Error saving department file: " + fileName);

 }

 }

}

package studentmanagement.handler;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileWriter;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.Scanner;

import studentmanagement.collection.MyGenericList;

import studentmanagement.model.Enrollment;

public class EnrollmentHandler implements EntityHandler<Enrollment> {

 @Override

 public int fetchKey(Enrollment enrollment) {

 return enrollment.getRegistrationId();

 }

 @Override

 public Enrollment decodeRecord(String data) {

 try {

 String[] parts = data.split(",");

 if (parts.length < 6) {

 return null;

 }

 int registrationId = Integer.parseInt(parts[0].trim());

 int studentId = Integer.parseInt(parts[1].trim());

 int courseId = Integer.parseInt(parts[2].trim());

 String semester = parts[3].trim();

 String year = parts[4].trim();

 char grade = parts[5].trim().charAt(0);

 return new Enrollment(registrationId, studentId, courseId, semester, year, grade);

 } catch (Exception e) {

 return null;

 }

 }

 @Override

 public String composeRecord(Enrollment enrollment) {

 return enrollment.getRegistrationId() + "," +

 enrollment.getStudentId() + "," +

 enrollment.getCourseId() + "," +

 enrollment.getSemester() + "," +

 enrollment.getYear() + "," +

 enrollment.getGrade();

 }

 public MyGenericList<Enrollment> loadFromFile(String fileName) {

 MyGenericList<Enrollment> enrollments = new MyGenericList<>();

 File file = new File(fileName);

 if (!file.exists()) {

 return enrollments;

 }

 try (Scanner scanner = new Scanner(file)) {

 while (scanner.hasNextLine()) {

 String line = scanner.nextLine().trim();

 if (line.isEmpty()) {

 continue;

 }

 Enrollment enrollment = decodeRecord(line);

 if (enrollment != null) {

 enrollments.add(enrollment);

 }

 }

 } catch (FileNotFoundException e) {

 System.out.println("Enrollment file not found: " + fileName);

 }

 return enrollments;

 }

 public void saveToFile(MyGenericList<Enrollment> enrollments, String fileName) {

 try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

 for (Enrollment enrollment : enrollments.fetchAllItems()) {

 writer.println(composeRecord(enrollment));

 }

 } catch (IOException e) {

 System.out.println("Error saving enrollment file: " + fileName);

 }

 }

}

package studentmanagement.handler;

public interface EntityHandler<T> {

 int fetchKey(T entity);

 T decodeRecord(String data);

 String composeRecord(T entity);

}
