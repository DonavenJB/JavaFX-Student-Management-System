package studentmanagement.app;

public final class AppBootstrap {

    private static final String STUDENTS_FILE = "students.txt";
    private static final String COURSES_FILE = "courses.txt";
    private static final String DEPARTMENTS_FILE = "departments.txt";
    private static final String INSTRUCTORS_FILE = "instructors.txt";
    private static final String ENROLLMENTS_FILE = "enrollments.txt";

    private AppBootstrap() {
    }

    public static AppContext initialize() {
        return new AppContext(
            STUDENTS_FILE,
            COURSES_FILE,
            DEPARTMENTS_FILE,
            INSTRUCTORS_FILE,
            ENROLLMENTS_FILE
        );
    }
}
