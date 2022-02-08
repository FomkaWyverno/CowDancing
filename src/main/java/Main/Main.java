package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/main.fxml"));
        primaryStage.setTitle("Cow Dancing GAME");
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(true);
        primaryStage.setScene(new Scene(root,1920,1080));
        primaryStage.getIcons().add(new Image("/cow.png"));
        primaryStage.getScene().setCursor(Cursor.NONE);
        primaryStage.show();
    }
}
