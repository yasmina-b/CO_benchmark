import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationMain extends Application {

    private Stage primaryStage;

    public void start(Stage primaryStage) throws IOException {

        this.primaryStage=primaryStage;
        this.primaryStage.setTitle("Digits of PI ~ CPU Benchmark");
        Parent root = FXMLLoader.load(ApplicationMain.class.getResource("resource/MainView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }

}
