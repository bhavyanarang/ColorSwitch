package sample;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.awt.*;

public class Scorecard {

    private Label label;

    public Label getLabel(){
        //modifyLabel();
        return label;
    }
    public void modifyLabel(){
        label.setTextFill(Color.WHITE);
        label.setStyle("-fx-font-weight: bold");
        label.setScaleX(label.getScaleX()+2);
        label.setScaleY(label.getScaleY()+2);
        label.setLayoutX(label.getLayoutX()+60);
        label.setLayoutY(label.getLayoutY()+60);
    }
    public Scorecard(){
        label=new Label("10");
        modifyLabel();
    }
}
