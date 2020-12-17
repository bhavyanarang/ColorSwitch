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

public class LoadGameMenuController implements Initializable {

    @FXML private Group circle1;
    @FXML private Group circle2;
    @FXML private AnchorPane pane;
    @FXML private Button back;
    @FXML private Button game1;
    @FXML private Button game2;
    @FXML private Button game3;

    Rotate rotate1;
    Rotate rotate2;

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
    void game1(){
        pane.getChildren().removeAll();
        serializehelp object1 = null;

        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream("1.txt");
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            object1 = (serializehelp) in.readObject();
            System.out.println("ok");
//            }
            System.out.println("chill1");

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
            System.out.println("ballY = " + object1.ballY);
        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
        Game game = new Game(pane, object1);
    }
    @FXML
    void game2(){
        pane.getChildren().removeAll();
        serializehelp object1 = null;

        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream("2.txt");
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            object1 = (serializehelp) in.readObject();
            System.out.println("ok");
//            }
            System.out.println("chill1");

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
            System.out.println("ballY = " + object1.ballY);
        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
        Game game = new Game(pane, object1);

    }
    @FXML
    void game3(){
        pane.getChildren().removeAll();
        serializehelp object1 = null;

        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream("3.txt");
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            object1 = (serializehelp) in.readObject();
            System.out.println("ok");
//            }
            System.out.println("chill1");

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
            System.out.println("ballY = " + object1.ballY);
        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
        Game game = new Game(pane, object1);

    }


    @FXML
    void goToHome(MouseEvent event) throws IOException {
        AnchorPane pane1= FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        pane.getChildren().setAll(pane1);
    }

    AnimationTimer t1=new AnimationTimer() {
        @Override
        public void handle(long l) {
            rotate();
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //presentScore.setText(game.scorecard.getLabel().getText());
        rotate1=new Rotate();
        rotate2=new Rotate();
        //rotate();
        t1.start();
    }
}