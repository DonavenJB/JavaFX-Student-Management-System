package studentmanagement.app;

public final class AppContext {

    private final String studentsFile;
    private final String coursesFile;
    private final String departmentsFile;
    private final String instructorsFile;
    private final String enrollmentsFile;

    public AppContext(String studentsFile,
                      String coursesFile,
                      String departmentsFile,
                      String instructorsFile,
                      String enrollmentsFile) {
        this.studentsFile = studentsFile;
        this.coursesFile = coursesFile;
        this.departmentsFile = departmentsFile;
        this.instructorsFile = instructorsFile;
        this.enrollmentsFile = enrollmentsFile;
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
}
