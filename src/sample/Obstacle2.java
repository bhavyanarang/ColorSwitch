package sample;

import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;

public class Obstacle2 {
    Pane pane=new Pane();
    Line line1=new Line();
    Line line2=new Line();
    Line line3=new Line();
    Line line4=new Line();
    Slider slider=new Slider();
    Obstacle2(){
        line1.setStartX(200);
        line1.setStartY(200);
        line1.setEndX(300);
        line1.setEndY(200);
        line1.setStrokeType(StrokeType.CENTERED);
        line1.setStroke(Color.RED);
        line1.setStrokeWidth(10);

        line2.setStartX(300);
        line2.setStartY(200);
        line2.setEndX(400);
        line2.setEndY(200);
        line2.setStrokeType(StrokeType.CENTERED);
        line2.setStroke(Color.BLUE);
        line2.setStrokeWidth(10);

        line3.setStartX(400);
        line3.setStartY(200);
        line3.setEndX(500);
        line3.setEndY(200);
        line3.setStrokeType(StrokeType.CENTERED);
        line3.setStroke(Color.VIOLET);
        line3.setStrokeWidth(10);

        line4.setStartX(500);
        line4.setStartY(200);
        line4.setEndX(600);
        line4.setEndY(200);
        line4.setStrokeType(StrokeType.CENTERED);
        line4.setStroke(Color.YELLOW);
        line4.setStrokeWidth(10);

        Group group=new Group();
        group.getChildren().addAll(line1,line2,line3,line4);
        //group.setTranslateX(10);

        pane.getChildren().add(group);
    }
}
