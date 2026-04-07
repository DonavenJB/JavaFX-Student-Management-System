package studentmanagement.ui.shell;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import studentmanagement.app.AppContext;
import studentmanagement.ui.shell.MainMenuFactory.MenuBundle;

public final class AppWindowLauncher {

    private static final int WINDOW_WIDTH = 1000;
    private static final int WINDOW_HEIGHT = 850;
    private static final String WINDOW_TITLE = "Student Management Program";
    private static final String DEFAULT_CENTER_TEXT = "Student Management Application!";

    private AppWindowLauncher() {
    }

    public static void launch(Stage primaryStage, AppContext appContext) {
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(new Label(DEFAULT_CENTER_TEXT));

        MainMenuFactory.MenuBundle menuBundle = MainMenuFactory.build();
        borderPane.setTop(menuBundle.getMenuBar());

        MainMenuController.bind(primaryStage, borderPane, appContext, menuBundle);

        Scene rootShell = new Scene(borderPane, WINDOW_WIDTH, WINDOW_HEIGHT);

        primaryStage.setTitle(WINDOW_TITLE);
        primaryStage.setScene(rootShell);
        primaryStage.show();
    }
}
