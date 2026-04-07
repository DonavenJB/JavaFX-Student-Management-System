# Student Management Program

A JavaFX-based desktop application for managing students, departments, instructors, courses, enrollments, and academic reports.

## Current Project State

The repository now includes the complete first-pass application source: bootstrap and runtime context management, the custom in-memory collection, the core domain models, flat-file persistence handlers, the ZIP lookup service, the shared JavaFX UI utility layer, full CRUD-style workflows for students, departments, instructors, courses, and enrollments, the reporting subsystem, and the integrated shell navigation that connects the menu system to the feature modules.

## Current Package Layout

- `studentmanagement.app`
  - `Main.java`
  - `AppBootstrap.java`
  - `AppContext.java`
- `studentmanagement.collection`
  - `MyGenericList.java`
- `studentmanagement.handler`
  - `EntityHandler.java`
  - `StudentHandler.java`
  - `DepartmentHandler.java`
  - `InstructorHandler.java`
  - `CourseHandler.java`
  - `EnrollmentHandler.java`
- `studentmanagement.model`
  - `Student.java`
  - `Department.java`
  - `Instructor.java`
  - `Course.java`
  - `Enrollment.java`
  - `Report.java`
- `studentmanagement.service`
  - `ZipCodeService.java`
- `studentmanagement.ui.common`
  - `AlertUtils.java`
  - `LayoutFactory.java`
  - `FormUtils.java`
- `studentmanagement.ui.student`
  - `StudentFormSupport.java`
  - `StudentCreateView.java`
  - `StudentEditView.java`
  - `StudentShowView.java`
  - `StudentUI.java`
- `studentmanagement.ui.department`
  - `DepartmentCreateView.java`
  - `DepartmentShowView.java`
  - `DepartmentEditView.java`
  - `DepartmentFormSupport.java`
  - `DepartmentUI.java`
- `studentmanagement.ui.instructor`
  - `InstructorCreateView.java`
  - `InstructorShowView.java`
  - `InstructorEditView.java`
  - `InstructorFormSupport.java`
  - `InstructorUI.java`
- `studentmanagement.ui.course`
  - `CourseFormSupport.java`
  - `CourseCreateView.java`
  - `CourseEditView.java`
  - `CourseShowView.java`
  - `CourseUI.java`
- `studentmanagement.ui.enrollment`
  - `EnrollmentFormSupport.java`
  - `EnrollmentCreateView.java`
  - `EnrollmentEditView.java`
  - `EnrollmentShowView.java`
  - `EnrollmentUI.java`
- `studentmanagement.ui.report`
  - `ReportFieldFactory.java`
  - `ReportResultsBuilder.java`
  - `CourseReportView.java`
  - `StudentReportView.java`
  - `ExceptionReportView.java`
  - `ReportUI.java`
- `studentmanagement.ui.shell`
  - `AppWindowLauncher.java`
  - `MainMenuFactory.java`
  - `MainMenuController.java`

## Current Architecture Notes

- `Main` starts the JavaFX application.
- `AppBootstrap` creates the handlers, loads the flat-file catalogs, and returns a shared `AppContext`.
- `AppContext` stores file names, loaded catalogs, and handler instances for the UI layer.
- `MyGenericList` is the current custom generic list used for in-memory catalog storage.
- The handler layer provides flat-file loading and saving for the current entity set.
- `ZipCodeService` provides ZIP-code lookup support for student workflows.
- The shared UI utility package provides alert, layout, and form helpers.
- The student, department, instructor, course, and enrollment packages each provide create, display, and edit workflows plus support helpers.
- The report package now includes the report field factory, results builder, course report view, student report view, exception report view, and the `ReportUI` facade.
- The shell package now includes the integrated application window, menu factory, and menu controller that route the menu actions to the feature modules.

## Dependencies

- Java
- JavaFX

Additional libraries and runtime notes are documented in `DEPENDENCIES.md`.
