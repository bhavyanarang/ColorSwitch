package sample;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.scene.Scene;

import java.awt.event.MouseListener;
import java.io.IOException;

public class MainMenuController {

    @FXML private Group circle1;
    @FXML private Group circle2;
    @FXML private AnchorPane pane;
    @FXML private Button newGame;
    @FXML private Button resumeGame;
    @FXML private Button exitt;

    Rotate rotate1=new Rotate();
    Rotate rotate2=new Rotate();

    public void rotate(){

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
    void startNewGame(MouseEvent event) throws IOException {
        Ball b1=new Ball();
        pane.getChildren().setAll(b1.getBall());
    }
    @FXML
    void resumeOldGame(MouseEvent event) throws IOException {
        System.out.println("Resume game");
    }
    @FXML
    void exitGame(MouseEvent event) throws IOException {
        System.exit(0);
    }

    AnimationTimer t1=new AnimationTimer() {
        @Override
        public void handle(long l) {
            rotate();
        }
    };
    public MainMenuController(){
        t1.start();
    }

}
