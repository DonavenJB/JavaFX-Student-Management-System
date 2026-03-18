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
