package sample;
import javafx.animation.AnimationTimer;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class MainMenuController implements Initializable{

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
    @FXML private Button help;

    private Game game;
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
    void addScaleTransition() {
        ScaleTransition st1 = new ScaleTransition(Duration.millis(500),newGame);
        ScaleTransition st2 = new ScaleTransition(Duration.millis(1000), resumeGame);
        ScaleTransition st3 = new ScaleTransition(Duration.millis(1000), help);
        ScaleTransition st4 = new ScaleTransition(Duration.millis(1000), exitt);

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
        st3.setByY(0.05);
        st3.setByX(0.05);
        st3.setCycleCount(Timeline.INDEFINITE);
        st3.setAutoReverse(true);
        st3.play();
        st4.setByY(0.05);
        st4.setByX(0.05);
        st4.setCycleCount(Timeline.INDEFINITE);
        st4.setAutoReverse(true);
        st4.play();

    }
    @FXML
    void initializeGame(){
        game=new Game(pane);
    }
    @FXML
    void startNewGame(MouseEvent event) {
        initializeGame();
        game.startNewGame();
    }
    @FXML
    void resumeOldGame(MouseEvent event) throws IOException {

        AnchorPane pane1= FXMLLoader.load(getClass().getResource("LoadGame.fxml"));
        pane.getChildren().setAll(pane1);

//        System.out.println("Resume game");
//        //pane.getChildren().removeAll();
//        serializehelp object1 = null;
//        System.out.println("Game Name:");
//        Scanner ins=new Scanner(System.in);
//        String check=ins.next();
//        //game.savedgames.contains(check);
//        // Deserialization
//        try
//        {
//            // Reading the object from a file
//            FileInputStream file = new FileInputStream(check+".txt");
//            ObjectInputStream in = new ObjectInputStream(file);
//
//            // Method for deserialization of object
//            object1 = (serializehelp) in.readObject();
//            //System.out.println("ok");
////            while (object1!=null && !(object1.saveAs.equals(check))){
////                System.out.println(object1.saveAs);
////                System.out.println("check: "+object1.saveAs.equals(check));
////                object1=(serializehelp) in.readObject();
////            }
//            //System.out.println("chill1");
//
//            in.close();
//            file.close();
//
//            System.out.println("Object has been deserialized ");
//            System.out.println("ballY = " + object1.ballY);
//            //System.out.println("Coordinate of Obstacle: "+ object1.ObstaclenowY);
//            //System.out.println("b = " + object1.b);
//            //Parent root=object1.pane;
//            //primaryStage.setTitle("Color Switch");
//            //primaryStage.setScene(new Scene(root, 400, 600));
//            //primaryStage.show();
//
//
//            //game.initialise_load(object1);
//
////            AnchorPane pane1= FXMLLoader.load(getClass().getResource("LoadGame.fxml"));
////            pane.getChildren().setAll(pane1);
//        }
//
//        catch(IOException ex)
//        {
//            System.out.println("IOException is caught");
//        }
//
//        catch(ClassNotFoundException ex)
//        {
//            System.out.println("ClassNotFoundException is caught");
//        }
//            Game game = new Game(pane, object1);

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addScaleTransition();
    }
}
