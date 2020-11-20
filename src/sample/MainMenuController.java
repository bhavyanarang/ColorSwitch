package sample;
import javafx.scene.Group;
import javafx.fxml.FXML;
import javafx.scene.transform.Rotate;
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


    public MainMenuController(){
        rotate();
    }

}
