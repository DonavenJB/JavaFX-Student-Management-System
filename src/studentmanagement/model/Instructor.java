package studentmanagement.model;

public class Instructor implements Comparable<Instructor> {

    private int lecturerKey;

    private String givenLabel;

    private String familyLabel;

    private int divisionKey;

    public Instructor() {
    }

    public Instructor(int lecturerKey, String givenLabel, String familyLabel, int divisionKey) {
        this.lecturerKey = lecturerKey;
        this.givenLabel = givenLabel;
        this.familyLabel = familyLabel;
        this.divisionKey = divisionKey;
    }

    public int getInstructorId() {
        return lecturerKey;
    }

    public void setInstructorId(int instructorId) {
        this.lecturerKey = instructorId;
    }

    public String getFirstName() {
        return givenLabel;
    }

    public void setFirstName(String firstName) {
        this.givenLabel = firstName;
    }

    public String getLastName() {
        return familyLabel;
    }

    public void setLastName(String lastName) {
        this.familyLabel = lastName;
    }

    public int getDepartmentId() {
        return divisionKey;
    }

    public void setDepartmentId(int departmentId) {
        this.divisionKey = departmentId;
    }

    @Override
    public int compareTo(Instructor other) {
        int last = this.familyLabel.compareToIgnoreCase(other.familyLabel);
        if (last != 0) {
            return last;
        }
        return this.givenLabel.compareToIgnoreCase(other.givenLabel);
    }

    @Override
    public String toString() {
        return lecturerKey + " | " + givenLabel + " | " + familyLabel + " | " + divisionKey;
    }
}
