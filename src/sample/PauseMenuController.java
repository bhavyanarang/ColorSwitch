package sample;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PauseMenuController implements Initializable {
    @FXML private AnchorPane pane;
    @FXML private Button play;
    @FXML private Button home;
    Button button=new Button();

    void addScaleTransition() {
        ScaleTransition st1 = new ScaleTransition(Duration.millis(500), play);
        ScaleTransition st2 = new ScaleTransition(Duration.millis(500), home);
        st1.setByY(0.05);
        st1.setByX(0.05);
        st1.setCycleCount(Timeline.INDEFINITE);
        st1.setAutoReverse(true);
        st1.play();
        st2.setByY(0.05);
        st2.setByX(0.05);
        st2.setCycleCount(Timeline.INDEFINITE);
        st2.setAutoReverse(true);
        st2.play();
    }

    @FXML
    void home(MouseEvent event) throws IOException {
        //go to home
        AnchorPane pane1= FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        pane.getChildren().setAll(pane1);
    }
    @FXML
    void saveGame(MouseEvent event) throws IOException {
        //save this game
        AnchorPane pane1= FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        pane.getChildren().setAll(pane1);
    }
    @FXML
    void resumeGame(MouseEvent event) throws IOException {
        //resume the game
        AnchorPane pane1= FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        pane.getChildren().setAll(pane1);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addScaleTransition();
    }
}
