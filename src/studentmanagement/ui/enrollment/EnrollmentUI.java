package studentmanagement.ui.enrollment;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.GridPane;

import studentmanagement.collection.MyGenericList;

import studentmanagement.handler.EnrollmentHandler;

import studentmanagement.model.Course;

import studentmanagement.model.Enrollment;

import studentmanagement.model.Student;

public final class EnrollmentUI {

 private EnrollmentUI() {

 }

 public static GridPane createRegistration(BorderPane borderPane, MyGenericList<Enrollment> registrationCatalog,

 MyGenericList<Student> learnerCatalog, MyGenericList<Course> moduleCatalog,

 EnrollmentHandler enrollmentHandler, String enrollmentsFile) {

 return EnrollmentCreateView.build(

 borderPane, registrationCatalog, learnerCatalog, moduleCatalog, enrollmentHandler, enrollmentsFile

 );

 }

 public static GridPane showRegistration(BorderPane borderPane, MyGenericList<Enrollment> registrationCatalog,

 MyGenericList<Student> learnerCatalog, MyGenericList<Course> moduleCatalog) {

 return EnrollmentShowView.build(borderPane, registrationCatalog, learnerCatalog, moduleCatalog);

 }

 public static GridPane reviseRegistration(BorderPane borderPane, MyGenericList<Enrollment> registrationCatalog,

 MyGenericList<Student> learnerCatalog, MyGenericList<Course> moduleCatalog,

 EnrollmentHandler enrollmentHandler, String enrollmentsFile) {

 return EnrollmentEditView.build(

 borderPane, registrationCatalog, learnerCatalog, moduleCatalog, enrollmentHandler, enrollmentsFile

 );

 }

}
