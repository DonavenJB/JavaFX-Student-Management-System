package studentmanagement.handler;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileWriter;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.Scanner;

import studentmanagement.collection.MyGenericList;

import studentmanagement.model.Student;

public class StudentHandler implements EntityHandler<Student> {

 @Override

 public int fetchKey(Student student) {

 return student.getStudentId();

 }

 @Override

 public Student decodeRecord(String data) {

 try {

 String[] parts = data.split(",");

 if (parts.length < 7) {

 return null;

 }

 int learnerKey = Integer.parseInt(parts[0].trim());

 String givenLabel = parts[1].trim();

 String familyLabel = parts[2].trim();

 String streetLine = parts[3].trim();

 String localArea = parts[4].trim();

 String regionCode = parts[5].trim();

 String postalCode = parts[6].trim();

 return new Student(learnerKey, givenLabel, familyLabel, streetLine, localArea, regionCode, postalCode);

 } catch (Exception e) {

 return null;

 }

 }

 @Override

 public String composeRecord(Student student) {

 return student.getStudentId() + "," +

 student.getFirstName() + "," +

 student.getLastName() + "," +

 student.getStreetLine() + "," +

 student.getCity() + "," +

 student.getState() + "," +

 student.getZipCode();

 }

 public MyGenericList<Student> loadFromFile(String fileName) {

 MyGenericList<Student> students = new MyGenericList<>();

 File file = new File(fileName);

 if (!file.exists()) {

 return students;

 }

 try (Scanner scanner = new Scanner(file)) {

 while (scanner.hasNextLine()) {

 String line = scanner.nextLine().trim();

 if (line.isEmpty()) {

 continue;

 }

 Student student = decodeRecord(line);

 if (student != null) {

 students.add(student);

 }

 }

 } catch (FileNotFoundException e) {

 System.out.println("Student file not found: " + fileName);

 }

 return students;

 }

 public void saveToFile(MyGenericList<Student> students, String fileName) {

 try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

 for (Student student : students.fetchAllItems()) {

 writer.println(composeRecord(student));

 }

 } catch (IOException e) {

 System.out.println("Error saving student file: " + fileName);

 }

 }

}
