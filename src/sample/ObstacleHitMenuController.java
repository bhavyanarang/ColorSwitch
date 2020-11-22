package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;

import java.awt.*;
import java.io.IOException;

public class ObstacleHitMenuController {

    @FXML private Group circle1;
    @FXML private Group circle2;
    @FXML private AnchorPane pane;
    //@FXML private Button back;
    //@FXML private Button replay;

    Rotate rotate1=new Rotate();
    Rotate rotate2=new Rotate();

    public void rotate() {

        rotate1.setPivotX(0);
        rotate1.setPivotY(0);
        rotate1.setAngle(5);
        circle1.getTransforms().addAll(rotate1);

        rotate2.setPivotX(0);
        rotate2.setPivotY(0);
        rotate2.setAngle(-5);
        circle2.getTransforms().addAll(rotate2);
    }
    @FXML
    void goToHome(MouseEvent event) throws IOException {
        AnchorPane pane1= FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        pane.getChildren().setAll(pane1);
    }
    @FXML
    void replayAgain(MouseEvent event) throws  IOException{
        Ball b1=new Ball();
        pane.getChildren().setAll(b1.getBall());
    }

}
