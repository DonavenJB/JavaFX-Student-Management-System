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
