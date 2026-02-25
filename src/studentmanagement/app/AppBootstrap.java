package studentmanagement.app;

public final class AppBootstrap {

    private static final String STUDENTS_FILE = "students.txt";
    private static final String COURSES_FILE = "courses.txt";
    private static final String DEPARTMENTS_FILE = "departments.txt";
    private static final String INSTRUCTORS_FILE = "instructors.txt";
    private static final String ENROLLMENTS_FILE = "enrollments.txt";

    private AppBootstrap() {
    }

    public static void initialize() {
        System.out.println("Bootstrapping Student Management Program...");
        System.out.println("Configured data files:");
        System.out.println(" - " + STUDENTS_FILE);
        System.out.println(" - " + COURSES_FILE);
        System.out.println(" - " + DEPARTMENTS_FILE);
        System.out.println(" - " + INSTRUCTORS_FILE);
        System.out.println(" - " + ENROLLMENTS_FILE);
    }
}
