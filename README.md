# Student Management Program

A JavaFX-based desktop application for managing students, departments, instructors, courses, enrollments, and academic reports.

## Current Project State

The repository currently includes the application bootstrap flow, shared runtime context, custom in-memory collection, core domain models, flat-file persistence handlers, the initial JavaFX shell, shared UI utility classes, the full first-pass department feature set, the full first-pass instructor feature set, and the initial course feature workflow.

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
- `studentmanagement.ui.common`
  - `AlertUtils.java`
  - `LayoutFactory.java`
  - `FormUtils.java`
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
- The shared UI utility package provides alert, layout, and form helpers.
- The department package now includes create, display, and edit workflows plus shared form support.
- The instructor package now includes create, display, and edit workflows plus shared form support.
- The course package now includes form support and the initial create workflow.
- The shell package currently provides the application window and menu structure.

## Dependencies

- Java
- JavaFX

Additional libraries and runtime notes are documented in `DEPENDENCIES.md`.
