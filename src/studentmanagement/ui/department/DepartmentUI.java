package studentmanagement.ui.department;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import studentmanagement.collection.MyGenericList;
import studentmanagement.handler.DepartmentHandler;
import studentmanagement.model.Department;

public final class DepartmentUI {

    private DepartmentUI() {
    }

    public static GridPane createDivision(BorderPane borderPane, MyGenericList<Department> divisionCatalog,
                                          DepartmentHandler departmentHandler, String departmentsFile) {
        return DepartmentCreateView.build(borderPane, divisionCatalog, departmentHandler, departmentsFile);
    }

    public static GridPane showDivision(BorderPane borderPane, MyGenericList<Department> divisionCatalog) {
        return DepartmentShowView.build(borderPane, divisionCatalog);
    }

    public static GridPane reviseDivision(BorderPane borderPane, MyGenericList<Department> divisionCatalog,
                                          DepartmentHandler departmentHandler, String departmentsFile) {
        return DepartmentEditView.build(borderPane, divisionCatalog, departmentHandler, departmentsFile);
    }
}
