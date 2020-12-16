package sample;
import javafx.animation.AnimationTimer;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.shape.SVGPath;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ObstacleHitMenuController implements Initializable {

    @FXML private Group circle1;
    @FXML private Group circle2;
    @FXML private AnchorPane pane;
    @FXML private Button back1;
    @FXML private Button replay1;
    @FXML private Label presentScore;
    @FXML private Label highScore;
    @FXML private Label totalStars;


    Rotate rotate1;
    Rotate rotate2;
    Game game;

    public void rotate() {

        rotate1.setPivotX(0);
        rotate1.setPivotY(0);
        rotate1.setAngle(5);
        circle1.getTransforms().addAll(rotate1);

        rotate2.setPivotX(0);
        rotate2.setPivotY(0);
        rotate2.setAngle(-5);
        circle2.getTransforms().addAll(rotate2);

        ScaleTransition st1 = new ScaleTransition(Duration.millis(500), replay1);
        st1.setByY(0.05);
        st1.setByX(0.05);
        st1.setCycleCount(Timeline.INDEFINITE);
        st1.setAutoReverse(true);
        st1.play();

        ScaleTransition st2 = new ScaleTransition(Duration.millis(500), back1);
        st2.setByY(0.05);
        st2.setByX(0.05);
        st2.setCycleCount(Timeline.INDEFINITE);
        st2.setAutoReverse(true);
        st2.play();

    }
    //    void updatePresentScore(String s1){
//       this.initialize();
//    }
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
    public ObstacleHitMenuController(){
        t1.start();
    }
    AnimationTimer t1=new AnimationTimer() {
        @Override
        public void handle(long l) {
            rotate();
        }
    };

    void initData(String abc){
        //String a=Integer.toString(abc);
        this.presentScore.setText(abc);

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //presentScore.setText(game.scorecard.getLabel().getText());
        rotate1=new Rotate();
        rotate2=new Rotate();
        //rotate();
        //t1.start();
    }
}