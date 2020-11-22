package sample;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.MouseListener;
import java.io.IOException;

public class MainMenuController {

    @FXML private Group circle1;
    @FXML private Group circle2;
    @FXML private Group circle3;
    @FXML private Group circle4;
    @FXML private Group circle5;
    @FXML private Group circle6;
    @FXML private Group circle7;
    @FXML private Group circle8;
    @FXML private Group circle9;

    @FXML private AnchorPane pane;
    @FXML private Button newGame;
    @FXML private Button resumeGame;
    @FXML private Button exitt;

    Button button=new Button();
    Rotate rotate1=new Rotate();
    Rotate rotate2=new Rotate();
    Rotate rotate3=new Rotate();
    Rotate rotate4=new Rotate();
    Rotate rotate5=new Rotate();
    Rotate rotate6=new Rotate();
    Rotate rotate7=new Rotate();
    Rotate rotate8=new Rotate();
    Rotate rotate9=new Rotate();

    public void rotate(){

        rotate1.setPivotX(0);
        rotate1.setPivotY(0);
        rotate1.setAngle(5);
        circle1.getTransforms().addAll(rotate1);

        rotate2.setPivotX(0);
        rotate2.setPivotY(0);
        rotate2.setAngle(-5);
        circle2.getTransforms().addAll(rotate2);

        rotate3.setPivotX(0);
        rotate3.setPivotY(0);
        rotate3.setAngle(5);
        circle3.getTransforms().addAll(rotate3);

        rotate4.setPivotX(0);
        rotate4.setPivotY(0);
        rotate4.setAngle(7);
        circle4.getTransforms().addAll(rotate4);

        rotate5.setPivotX(0);
        rotate5.setPivotY(0);
        rotate5.setAngle(-7);
        circle5.getTransforms().addAll(rotate5);

        rotate6.setPivotX(0);
        rotate6.setPivotY(0);
        rotate6.setAngle(10);
        circle6.getTransforms().addAll(rotate6);

        rotate7.setPivotX(0);
        rotate7.setPivotY(0);
        rotate7.setAngle(5);
        circle7.getTransforms().addAll(rotate7);

        rotate8.setPivotX(0);
        rotate8.setPivotY(0);
        rotate8.setAngle(-5);
        circle8.getTransforms().addAll(rotate8);

        rotate9.setPivotX(0);
        rotate9.setPivotY(0);
        rotate9.setAngle(-5);
        circle9.getTransforms().addAll(rotate9);
    }
    void pause(){
        Image img = new Image("Assets/pause.png");
        ImageView view = new ImageView(img);
        view.setScaleX(view.getScaleX()*1);
        view.setScaleY(view.getScaleY()*1);
        button.setGraphic(view);
        button.setScaleX(view.getScaleX()*0.05);
        button.setScaleY(view.getScaleY()*0.05);
        button.setLayoutX(button.getLayoutX()+50);
        button.setLayoutY(button.getLayoutY()-350);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage newStage=(Stage) button.getScene().getWindow();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                newStage.setScene(new Scene(root,550,600));
                newStage.show();
            }
        });
    }

    @FXML
    void startNewGame(MouseEvent event) {
        pause();
        Scorecard scorecard=new Scorecard();
        Ball b1=new Ball();
        pane.getChildren().setAll(b1.getBall(),button,scorecard.getLabel());
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
