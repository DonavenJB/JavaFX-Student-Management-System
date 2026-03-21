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
