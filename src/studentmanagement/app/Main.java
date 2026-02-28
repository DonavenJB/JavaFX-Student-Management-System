package studentmanagement.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AppContext appContext = AppBootstrap.initialize();

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(new Label("Student Management Application!"));

        Scene scene = new Scene(borderPane, 1000, 850);

        primaryStage.setTitle("Student Management Program");
        primaryStage.setScene(scene);
        primaryStage.show();

        System.out.println("Configured data files:");
        System.out.println(" - " + appContext.getStudentsFile());
        System.out.println(" - " + appContext.getCoursesFile());
        System.out.println(" - " + appContext.getDepartmentsFile());
        System.out.println(" - " + appContext.getInstructorsFile());
        System.out.println(" - " + appContext.getEnrollmentsFile());
    }
}
