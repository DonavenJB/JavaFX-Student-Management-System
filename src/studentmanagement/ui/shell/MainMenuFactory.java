package studentmanagement.ui.shell;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public final class MainMenuFactory {

    private MainMenuFactory() {
    }

    public static MenuBundle build() {
        MenuBar menuBar = new MenuBar();

        Menu studentMenu = new Menu("Student");
        Menu departmentMenu = new Menu("Department");
        Menu instructorMenu = new Menu("Instructor");
        Menu courseMenu = new Menu("Course");
        Menu enrollmentMenu = new Menu("Enrollment");
        Menu reportMenu = new Menu("Reports");
        Menu exitMenu = new Menu("Exit");

        MenuItem addStudent = new MenuItem("Add Student");
        MenuItem editStudent = new MenuItem("Edit Student");
        MenuItem displayStudent = new MenuItem("Display Student");

        MenuItem addDepartment = new MenuItem("Add Department");
        MenuItem editDepartment = new MenuItem("Edit Department");
        MenuItem displayDepartment = new MenuItem("Display Department");

        MenuItem addInstructor = new MenuItem("Add Instructor");
        MenuItem editInstructor = new MenuItem("Edit Instructor");
        MenuItem displayInstructor = new MenuItem("Display Instructor");

        MenuItem addCourse = new MenuItem("Add Course");
        MenuItem editCourse = new MenuItem("Edit Course");
        MenuItem displayCourse = new MenuItem("Display Course");

        MenuItem addEnrollment = new MenuItem("Add Enrollment");
        MenuItem editEnrollment = new MenuItem("Edit Enrollment");
        MenuItem displayEnrollment = new MenuItem("Display Enrollment");

        MenuItem courseReport = new MenuItem("Course Report");
        MenuItem studentReport = new MenuItem("Student Report");
        MenuItem exceptionReport = new MenuItem("Exceptions");

        MenuItem exitProgram = new MenuItem("Exit");

        studentMenu.getItems().addAll(addStudent, editStudent, displayStudent);
        departmentMenu.getItems().addAll(addDepartment, editDepartment, displayDepartment);
        instructorMenu.getItems().addAll(addInstructor, editInstructor, displayInstructor);
        courseMenu.getItems().addAll(addCourse, editCourse, displayCourse);
        enrollmentMenu.getItems().addAll(addEnrollment, editEnrollment, displayEnrollment);
        reportMenu.getItems().addAll(courseReport, studentReport, exceptionReport);
        exitMenu.getItems().add(exitProgram);

        menuBar.getMenus().addAll(
            studentMenu,
            departmentMenu,
            instructorMenu,
            courseMenu,
            enrollmentMenu,
            reportMenu,
            exitMenu
        );

        return new MenuBundle(
            menuBar,
            addStudent,
            editStudent,
            displayStudent,
            addDepartment,
            editDepartment,
            displayDepartment,
            addInstructor,
            editInstructor,
            displayInstructor,
            addCourse,
            editCourse,
            displayCourse,
            addEnrollment,
            editEnrollment,
            displayEnrollment,
            courseReport,
            studentReport,
            exceptionReport,
            exitProgram
        );
    }

    public static final class MenuBundle {

        private final MenuBar menuBar;

        private final MenuItem addStudent;
        private final MenuItem editStudent;
        private final MenuItem displayStudent;

        private final MenuItem addDepartment;
        private final MenuItem editDepartment;
        private final MenuItem displayDepartment;

        private final MenuItem addInstructor;
        private final MenuItem editInstructor;
        private final MenuItem displayInstructor;

        private final MenuItem addCourse;
        private final MenuItem editCourse;
        private final MenuItem displayCourse;

        private final MenuItem addEnrollment;
        private final MenuItem editEnrollment;
        private final MenuItem displayEnrollment;

        private final MenuItem courseReport;
        private final MenuItem studentReport;
        private final MenuItem exceptionReport;

        private final MenuItem exitProgram;

        public MenuBundle(MenuBar menuBar,
                          MenuItem addStudent,
                          MenuItem editStudent,
                          MenuItem displayStudent,
                          MenuItem addDepartment,
                          MenuItem editDepartment,
                          MenuItem displayDepartment,
                          MenuItem addInstructor,
                          MenuItem editInstructor,
                          MenuItem displayInstructor,
                          MenuItem addCourse,
                          MenuItem editCourse,
                          MenuItem displayCourse,
                          MenuItem addEnrollment,
                          MenuItem editEnrollment,
                          MenuItem displayEnrollment,
                          MenuItem courseReport,
                          MenuItem studentReport,
                          MenuItem exceptionReport,
                          MenuItem exitProgram) {
            this.menuBar = menuBar;
            this.addStudent = addStudent;
            this.editStudent = editStudent;
            this.displayStudent = displayStudent;
            this.addDepartment = addDepartment;
            this.editDepartment = editDepartment;
            this.displayDepartment = displayDepartment;
            this.addInstructor = addInstructor;
            this.editInstructor = editInstructor;
            this.displayInstructor = displayInstructor;
            this.addCourse = addCourse;
            this.editCourse = editCourse;
            this.displayCourse = displayCourse;
            this.addEnrollment = addEnrollment;
            this.editEnrollment = editEnrollment;
            this.displayEnrollment = displayEnrollment;
            this.courseReport = courseReport;
            this.studentReport = studentReport;
            this.exceptionReport = exceptionReport;
            this.exitProgram = exitProgram;
        }

        public MenuBar getMenuBar() {
            return menuBar;
        }

        public MenuItem getAddStudent() {
            return addStudent;
        }

        public MenuItem getEditStudent() {
            return editStudent;
        }

        public MenuItem getDisplayStudent() {
            return displayStudent;
        }

        public MenuItem getAddDepartment() {
            return addDepartment;
        }

        public MenuItem getEditDepartment() {
            return editDepartment;
        }

        public MenuItem getDisplayDepartment() {
            return displayDepartment;
        }

        public MenuItem getAddInstructor() {
            return addInstructor;
        }

        public MenuItem getEditInstructor() {
            return editInstructor;
        }

        public MenuItem getDisplayInstructor() {
            return displayInstructor;
        }

        public MenuItem getAddCourse() {
            return addCourse;
        }

        public MenuItem getEditCourse() {
            return editCourse;
        }

        public MenuItem getDisplayCourse() {
            return displayCourse;
        }

        public MenuItem getAddEnrollment() {
            return addEnrollment;
        }

        public MenuItem getEditEnrollment() {
            return editEnrollment;
        }

        public MenuItem getDisplayEnrollment() {
            return displayEnrollment;
        }

        public MenuItem getCourseReport() {
            return courseReport;
        }

        public MenuItem getStudentReport() {
            return studentReport;
        }

        public MenuItem getExceptionReport() {
            return exceptionReport;
        }

        public MenuItem getExitProgram() {
            return exitProgram;
        }
    }
}
