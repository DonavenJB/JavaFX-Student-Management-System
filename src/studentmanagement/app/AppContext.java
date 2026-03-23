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

public final class AppContext {

    private final String studentsFile;
    private final String coursesFile;
    private final String departmentsFile;
    private final String instructorsFile;
    private final String enrollmentsFile;

    private final MyGenericList<Student> learnerCatalog;
    private final MyGenericList<Course> moduleCatalog;
    private final MyGenericList<Department> divisionCatalog;
    private final MyGenericList<Enrollment> registrationCatalog;
    private final MyGenericList<Instructor> lecturerCatalog;

    private final StudentHandler studentHandler;
    private final CourseHandler courseHandler;
    private final DepartmentHandler departmentHandler;
    private final InstructorHandler instructorHandler;
    private final EnrollmentHandler enrollmentHandler;

    public AppContext(String studentsFile,
                      String coursesFile,
                      String departmentsFile,
                      String instructorsFile,
                      String enrollmentsFile,
                      MyGenericList<Student> learnerCatalog,
                      MyGenericList<Course> moduleCatalog,
                      MyGenericList<Department> divisionCatalog,
                      MyGenericList<Enrollment> registrationCatalog,
                      MyGenericList<Instructor> lecturerCatalog,
                      StudentHandler studentHandler,
                      CourseHandler courseHandler,
                      DepartmentHandler departmentHandler,
                      InstructorHandler instructorHandler,
                      EnrollmentHandler enrollmentHandler) {
        this.studentsFile = studentsFile;
        this.coursesFile = coursesFile;
        this.departmentsFile = departmentsFile;
        this.instructorsFile = instructorsFile;
        this.enrollmentsFile = enrollmentsFile;
        this.learnerCatalog = learnerCatalog;
        this.moduleCatalog = moduleCatalog;
        this.divisionCatalog = divisionCatalog;
        this.registrationCatalog = registrationCatalog;
        this.lecturerCatalog = lecturerCatalog;
        this.studentHandler = studentHandler;
        this.courseHandler = courseHandler;
        this.departmentHandler = departmentHandler;
        this.instructorHandler = instructorHandler;
        this.enrollmentHandler = enrollmentHandler;
    }

    public String getStudentsFile() {
        return studentsFile;
    }

    public String getCoursesFile() {
        return coursesFile;
    }

    public String getDepartmentsFile() {
        return departmentsFile;
    }

    public String getInstructorsFile() {
        return instructorsFile;
    }

    public String getEnrollmentsFile() {
        return enrollmentsFile;
    }

    public MyGenericList<Student> getLearnerCatalog() {
        return learnerCatalog;
    }

    public MyGenericList<Course> getModuleCatalog() {
        return moduleCatalog;
    }

    public MyGenericList<Department> getDivisionCatalog() {
        return divisionCatalog;
    }

    public MyGenericList<Enrollment> getRegistrationCatalog() {
        return registrationCatalog;
    }

    public MyGenericList<Instructor> getLecturerCatalog() {
        return lecturerCatalog;
    }

    public StudentHandler getStudentHandler() {
        return studentHandler;
    }

    public CourseHandler getCourseHandler() {
        return courseHandler;
    }

    public DepartmentHandler getDepartmentHandler() {
        return departmentHandler;
    }

    public InstructorHandler getInstructorHandler() {
        return instructorHandler;
    }

    public EnrollmentHandler getEnrollmentHandler() {
        return enrollmentHandler;
    }
}
