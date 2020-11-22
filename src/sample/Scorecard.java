package sample;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.awt.*;

public class Scorecard {

    private Label label;

    public Label getLabel(){
        modifyLabel();
        return label;
    }
    public void modifyLabel(){
        label.setTextFill(Color.WHITE);
        label.setStyle("-fx-font-weight: bold");
    }
    public Scorecard(){
        label=new Label("10");
    }
}
