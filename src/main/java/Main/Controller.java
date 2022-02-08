package Main;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainPanel;

    @FXML
    private ImageView cow;

    int x = 30;
    int y = 20;

    @FXML
    void initialize() throws URISyntaxException {
        assert mainPanel != null : "fx:id=\"mainPanel\" was not injected: check your FXML file 'main.fxml'.";
        assert cow != null : "fx:id=\"cow\" was not injected: check your FXML file 'main.fxml'.";
        Media media = new Media(getClass().getResource("/music/song.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.1);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();


        mainPanel.setOnMouseMoved(value -> {
            cow.setX(value.getX()-x);
            cow.setY(value.getY()-y);
        });
        mainPanel.setOnMouseDragged(event -> {
            cow.setX(event.getX()-x);
            cow.setY(event.getY()-y);
        });
        mainPanel.setOnScroll(value -> {
            if (value.getDeltaY() > 0) {
                cow.setFitHeight(cow.getFitHeight() * 0.9);
                cow.setFitWidth(cow.getFitWidth() * 0.9);
                x -=5;
                y -=5;
            } else {
                cow.setFitHeight(cow.getFitHeight() / 0.9);
                cow.setFitWidth(cow.getFitWidth() / 0.9);
                x += 5;
                y += 5;
            }
        });
    }
}
