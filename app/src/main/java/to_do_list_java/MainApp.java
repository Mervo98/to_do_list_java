package to_do_list_java;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Hello JavaFX!");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}