package studentmanagement.handler;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileWriter;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.Scanner;

import studentmanagement.collection.MyGenericList;

import studentmanagement.model.Instructor;

public class InstructorHandler implements EntityHandler<Instructor> {

 @Override

 public int fetchKey(Instructor instructor) {

 return instructor.getInstructorId();

 }

 @Override

 public Instructor decodeRecord(String data) {

 try {

 String[] parts = data.split(",");

 if (parts.length < 4) {

 return null;

 }

 int instructorId = Integer.parseInt(parts[0].trim());

 String firstName = parts[1].trim();

 String lastName = parts[2].trim();

 int departmentId = Integer.parseInt(parts[3].trim());

 return new Instructor(instructorId, firstName, lastName, departmentId);

 } catch (Exception e) {

 return null;

 }

 }

 @Override

 public String composeRecord(Instructor instructor) {

 return instructor.getInstructorId() + "," +

 instructor.getFirstName() + "," +

 instructor.getLastName() + "," +

 instructor.getDepartmentId();

 }

 public MyGenericList<Instructor> loadFromFile(String fileName) {

 MyGenericList<Instructor> instructors = new MyGenericList<>();

 File file = new File(fileName);

 if (!file.exists()) {

 return instructors;

 }

 try (Scanner scanner = new Scanner(file)) {

 while (scanner.hasNextLine()) {

 String line = scanner.nextLine().trim();

 if (line.isEmpty()) {

 continue;

 }

 Instructor instructor = decodeRecord(line);

 if (instructor != null) {

 instructors.add(instructor);

 }

 }

 } catch (FileNotFoundException e) {

 System.out.println("Instructor file not found: " + fileName);

 }

 return instructors;

 }

 public void saveToFile(MyGenericList<Instructor> instructors, String fileName) {

 try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

 for (Instructor instructor : instructors.fetchAllItems()) {

 writer.println(composeRecord(instructor));

 }

 } catch (IOException e) {

 System.out.println("Error saving instructor file: " + fileName);

 }

 }

}
