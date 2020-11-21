package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.shape.SVGPath;

import java.io.IOException;

public class PauseMenuController {
    @FXML private AnchorPane pane;
    @FXML private SVGPath home;
    @FXML private SVGPath save;
    @FXML private Group resume;

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

}
