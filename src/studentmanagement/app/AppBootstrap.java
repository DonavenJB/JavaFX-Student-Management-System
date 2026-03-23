package studentmanagement.app;

import studentmanagement.collection.MyGenericList;
import studentmanagement.handler.CourseHandler;
import studentmanagement.handler.DepartmentHandler;
import studentmanagement.handler.EnrollmentHandler;
import studentmanagement.handler.InstructorHandler;
import studentmanagement.handler.StudentHandler;
import studentmanagement.model.Course;
import studentmanagement.model.Department;
import studentmanagement.model.Enrollment;
import studentmanagement.model.Instructor;
import studentmanagement.model.Student;

public final class AppBootstrap {

    private static final String STUDENTS_FILE = "students.txt";
    private static final String COURSES_FILE = "courses.txt";
    private static final String DEPARTMENTS_FILE = "departments.txt";
    private static final String INSTRUCTORS_FILE = "instructors.txt";
    private static final String ENROLLMENTS_FILE = "enrollments.txt";

    private AppBootstrap() {
    }

    public static AppContext initialize() {
        StudentHandler studentHandler = new StudentHandler();
        CourseHandler courseHandler = new CourseHandler();
        DepartmentHandler departmentHandler = new DepartmentHandler();
        InstructorHandler instructorHandler = new InstructorHandler();
        EnrollmentHandler enrollmentHandler = new EnrollmentHandler();

        MyGenericList<Student> learnerCatalog = studentHandler.loadFromFile(STUDENTS_FILE);
        MyGenericList<Course> moduleCatalog = courseHandler.loadFromFile(COURSES_FILE);
        MyGenericList<Department> divisionCatalog = departmentHandler.loadFromFile(DEPARTMENTS_FILE);
        MyGenericList<Instructor> lecturerCatalog = instructorHandler.loadFromFile(INSTRUCTORS_FILE);
        MyGenericList<Enrollment> registrationCatalog = enrollmentHandler.loadFromFile(ENROLLMENTS_FILE);

        return new AppContext(
            STUDENTS_FILE,
            COURSES_FILE,
            DEPARTMENTS_FILE,
            INSTRUCTORS_FILE,
            ENROLLMENTS_FILE,
            learnerCatalog,
            moduleCatalog,
            divisionCatalog,
            registrationCatalog,
            lecturerCatalog,
            studentHandler,
            courseHandler,
            departmentHandler,
            instructorHandler,
            enrollmentHandler
        );
    }
}
