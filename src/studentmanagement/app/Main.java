package studentmanagement.app;

import javafx.application.Application;
import javafx.stage.Stage;
import studentmanagement.ui.shell.AppWindowLauncher;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AppContext appContext = AppBootstrap.initialize();
        AppWindowLauncher.launch(primaryStage, appContext);
    }
}
