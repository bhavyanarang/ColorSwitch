package sample;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
public class MainMenuController {

    @FXML private Group circle1;
    @FXML private Group circle2;

    Rotate rotate1=new Rotate();
    Rotate rotate2=new Rotate();

    public void rotate(){
        rotate1.setAngle(1);
        rotate1.setPivotX(319);
        rotate1.setPivotY(80);

        rotate2.setAngle(2);
        rotate2.setPivotX(239);
        rotate2.setPivotY(80);
    }


    @Override
    public void handle(){

    }

}
