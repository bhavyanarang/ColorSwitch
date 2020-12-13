package sample;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.awt.*;

public class Scorecard {

    private Label label;

    public Label getLabel(){
        return label;
    }
    public void setLabel(){
        int a=Integer.parseInt(label.getText());
        a+=1;
        label.setText(Integer.toString(a));
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
        label=new Label("0");
        modifyLabel();
    }
}
