package studentmanagement.model;

public class Student implements Comparable<Student> {

 private int learnerKey;

 private String givenLabel;

 private String familyLabel;

 private String streetLine;

 private String localArea;

 private String regionCode;

 private String postalCode;

 public Student() {

 }

 public Student(int learnerKey, String givenLabel, String familyLabel,

 String streetLine, String localArea, String regionCode, String postalCode) {

 this.learnerKey = learnerKey;

 this.givenLabel = givenLabel;

 this.familyLabel = familyLabel;

 this.streetLine = streetLine;

 this.localArea = localArea;

 this.regionCode = regionCode;

 this.postalCode = postalCode;

 }

 public int getStudentId() {

 return learnerKey;

 }

 public String getFirstName() {

 return givenLabel;

 }

 public String getLastName() {

 return familyLabel;

 }

 public String getStreetLine() {

 return streetLine;

 }

 public String getCity() {

 return localArea;

 }

 public String getState() {

 return regionCode;

 }

 public String getZipCode() {

 return postalCode;

 }

 public String getName() {

 return givenLabel + " " + familyLabel;

 }

 public void setStudentId(int learnerKey) {

 this.learnerKey = learnerKey;

 }

 public void setFirstName(String givenLabel) {

 this.givenLabel = givenLabel;

 }

 public void setLastName(String familyLabel) {

 this.familyLabel = familyLabel;

 }

 public void setStreetLine(String streetLine) {

 this.streetLine = streetLine;

 }

 public void setCity(String localArea) {

 this.localArea = localArea;

 }

 public void setState(String regionCode) {

 this.regionCode = regionCode;

 }

 public void setZipCode(String postalCode) {

 this.postalCode = postalCode;

 }

 @Override

 public int compareTo(Student other) {

 int last = this.familyLabel.compareToIgnoreCase(other.familyLabel);

 if (last != 0) {

 return last;

 }

 int first = this.givenLabel.compareToIgnoreCase(other.givenLabel);

 if (first != 0) {

 return first;

 }

 return Integer.compare(this.learnerKey, other.learnerKey);

 }

 @Override

 public String toString() {

 return learnerKey + " | " + givenLabel + " | " + familyLabel + " | " +

 streetLine + " | " + localArea + " | " + regionCode + " | " + postalCode;

 }

}
