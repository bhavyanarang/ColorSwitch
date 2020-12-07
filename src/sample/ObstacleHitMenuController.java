package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

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

//        ScaleTransition st1 = new ScaleTransition(Duration.millis(500), (Node)replay);
//        st1.setByY(0.05);
//        st1.setByX(0.05);
//        st1.setCycleCount(Timeline.INDEFINITE);
//        st1.setAutoReverse(true);
//        st1.play();
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
    AnimationTimer t1=new AnimationTimer() {
        @Override
        public void handle(long l) {
            rotate();
        }
    };
    public ObstacleHitMenuController(){
        t1.start();
    }


}
