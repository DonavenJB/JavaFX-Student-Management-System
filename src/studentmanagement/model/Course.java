package studentmanagement.model;

public class Course implements Comparable<Course> {

    private int courseId;

    private String courseName;

    private String courseDescription;

    private String departmentName;

    private String instructorName;

    public Course() {
    }

    public Course(int courseId, String courseName, String courseDescription) {
        this(courseId, courseName, courseDescription, "", "");
    }

    public Course(int courseId, String courseName, String courseDescription,
                  String departmentName, String instructorName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.departmentName = departmentName;
        this.instructorName = instructorName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    @Override
    public int compareTo(Course other) {
        int byName = this.courseName.compareToIgnoreCase(other.courseName);
        if (byName != 0) {
            return byName;
        }
        return Integer.compare(this.courseId, other.courseId);
    }

    @Override
    public String toString() {
        return courseId + " | " + courseName + " | " + courseDescription + " | "
            + departmentName + " | " + instructorName;
    }
}
