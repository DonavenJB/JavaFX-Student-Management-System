package studentmanagement.ui.student;

import java.io.IOException;

import javafx.scene.control.TextField;

import studentmanagement.collection.MyGenericList;

import studentmanagement.model.Student;

import studentmanagement.service.ZipCodeService;

import studentmanagement.ui.common.AlertUtils;

import studentmanagement.ui.common.FormUtils;

public final class StudentFormSupport {

 private static final String READ_ONLY_FIELD_STYLE = "-fx-control-inner-background: #eeeeee; -fx-opacity: 1;";

 private static final String ZIP_RESET_SUSPENDED_KEY = "zipResetSuspended";

 private static final String ORIGINAL_ZIP_KEY = "originalZip";

 private StudentFormSupport() {

 }

 public static void configureLocationFields(TextField cityInput, TextField stateInput) {

 FormUtils.setEditable(false, cityInput, stateInput);

 cityInput.setStyle(READ_ONLY_FIELD_STYLE);

 stateInput.setStyle(READ_ONLY_FIELD_STYLE);

 }

 public static void configureReadOnlyStudentFields(TextField firstNameInput, TextField lastNameInput,

 TextField addressInput, TextField cityInput,

 TextField stateInput, TextField zipInput) {

 FormUtils.setEditable(false, firstNameInput, lastNameInput, addressInput, cityInput, stateInput, zipInput);

 }

 public static void attachZipResetOnChange(TextField zipInput, TextField cityInput, TextField stateInput) {

 zipInput.textProperty().addListener((observable, oldValue, newValue) -> {

 Object suspended = zipInput.getProperties().get(ZIP_RESET_SUSPENDED_KEY);

 if (Boolean.TRUE.equals(suspended)) {

 return;

 }

 if (!newValue.equals(oldValue)) {

 cityInput.clear();

 stateInput.clear();

 }

 });

 }

 public static boolean validateZipAndPopulate(TextField zipInput, TextField cityInput, TextField stateInput) {

 String zip = zipInput.getText().trim();

 if (zip.isEmpty()) {

 AlertUtils.showError("Invalid ZIP Code", "Please enter a ZIP code.");

 cityInput.clear();

 stateInput.clear();

 return false;

 }

 if (!zip.matches("\\d{5}")) {

 AlertUtils.showError("Invalid ZIP Code", "Please enter a valid 5-digit ZIP code.");

 cityInput.clear();

 stateInput.clear();

 return false;

 }

 try {

 ZipCodeService.ZipInfo zipInfo = ZipCodeService.fetchPostalInfo(zip);

 cityInput.setText(zipInfo.fetchCityLabel());

 stateInput.setText(zipInfo.fetchRegionLabel());

 return true;

 } catch (IOException e) {

 AlertUtils.showError("ZIP Code Error", e.getMessage());

 cityInput.clear();

 stateInput.clear();

 return false;

 }

 }

 public static void populateEditableStudentFields(Student student, TextField firstNameInput, TextField lastNameInput,

 TextField addressInput, TextField cityInput,

 TextField stateInput, TextField zipInput) {

 zipInput.getProperties().put(ZIP_RESET_SUSPENDED_KEY, Boolean.TRUE);

 firstNameInput.setText(student.getFirstName());

 lastNameInput.setText(student.getLastName());

 addressInput.setText(student.getStreetLine());

 zipInput.setText(student.getZipCode());

 cityInput.setText(student.getCity());

 stateInput.setText(student.getState());

 zipInput.getProperties().put(ORIGINAL_ZIP_KEY, student.getZipCode());

 zipInput.getProperties().put(ZIP_RESET_SUSPENDED_KEY, Boolean.FALSE);

 }

 public static boolean zipWasChanged(TextField zipInput) {

 Object originalZip = zipInput.getProperties().get(ORIGINAL_ZIP_KEY);

 String currentZip = zipInput.getText().trim();

 if (originalZip == null) {

 return true;

 }

 return !currentZip.equals(originalZip.toString());

 }

 public static void markZipAsValidated(TextField zipInput) {

 zipInput.getProperties().put(ORIGINAL_ZIP_KEY, zipInput.getText().trim());

 }

 public static Student findStudentByKey(MyGenericList<Student> learnerCatalog, int learnerKey) {

 for (int i = 0; i < learnerCatalog.size(); i++) {

 Student student = learnerCatalog.get(i);

 if (student.getStudentId() == learnerKey) {

 return student;

 }

 }

 return null;

 }

 public static int findStudentIndexByKey(MyGenericList<Student> learnerCatalog, int learnerKey) {

 for (int i = 0; i < learnerCatalog.size(); i++) {

 if (learnerCatalog.get(i).getStudentId() == learnerKey) {

 return i;

 }

 }

 return -1;

 }

 public static boolean containsStudentKey(MyGenericList<Student> learnerCatalog, int learnerKey) {

 return findStudentIndexByKey(learnerCatalog, learnerKey) != -1;

 }

 public static void populateStudentFields(Student student, TextField firstNameInput, TextField lastNameInput,

 TextField addressInput, TextField cityInput,

 TextField stateInput, TextField zipInput) {

 firstNameInput.setText(student.getFirstName());

 lastNameInput.setText(student.getLastName());

 addressInput.setText(student.getStreetLine());

 cityInput.setText(student.getCity());

 stateInput.setText(student.getState());

 zipInput.setText(student.getZipCode());

 }

 public static void clearStudentFields(TextField... fields) {

 FormUtils.clearFields(fields);

 }

}
