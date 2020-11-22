package sample;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;

public class Obstacle2 {
    Pane pane=new Pane();
    TranslateTransition translate=new TranslateTransition();
    Line line1=new Line();
    Line line2=new Line();
    Line line3=new Line();
    Line line4=new Line();
    Line line5=new Line();
    Line line6=new Line();
    Line line7=new Line();
    Line line8=new Line();

    Obstacle2(){
        line1.setStartX(-400);
        line1.setStartY(200);
        line1.setEndX(-300);
        line1.setEndY(200);
        line1.setStrokeType(StrokeType.CENTERED);
        line1.setStroke(Color.RED);
        line1.setStrokeWidth(10);

        line2.setStartX(-300);
        line2.setStartY(200);
        line2.setEndX(-200);
        line2.setEndY(200);
        line2.setStrokeType(StrokeType.CENTERED);
        line2.setStroke(Color.BLUE);
        line2.setStrokeWidth(10);

        line3.setStartX(-200);
        line3.setStartY(200);
        line3.setEndX(-100);
        line3.setEndY(200);
        line3.setStrokeType(StrokeType.CENTERED);
        line3.setStroke(Color.VIOLET);
        line3.setStrokeWidth(10);

        line4.setStartX(-100);
        line4.setStartY(200);
        line4.setEndX(0);
        line4.setEndY(200);
        line4.setStrokeType(StrokeType.CENTERED);
        line4.setStroke(Color.YELLOW);
        line4.setStrokeWidth(10);

        line5.setStartX(0);
        line5.setStartY(200);
        line5.setEndX(100);
        line5.setEndY(200);
        line5.setStrokeType(StrokeType.CENTERED);
        line5.setStroke(Color.RED);
        line5.setStrokeWidth(10);

        line6.setStartX(100);
        line6.setStartY(200);
        line6.setEndX(200);
        line6.setEndY(200);
        line6.setStrokeType(StrokeType.CENTERED);
        line6.setStroke(Color.BLUE);
        line6.setStrokeWidth(10);

        line7.setStartX(200);
        line7.setStartY(200);
        line7.setEndX(300);
        line7.setEndY(200);
        line7.setStrokeType(StrokeType.CENTERED);
        line7.setStroke(Color.VIOLET);
        line7.setStrokeWidth(10);

        line8.setStartX(300);
        line8.setStartY(200);
        line8.setEndX(400);
        line8.setEndY(200);
        line8.setStrokeType(StrokeType.CENTERED);
        line8.setStroke(Color.YELLOW);
        line8.setStrokeWidth(10);


        Group group=new Group();
        group.getChildren().addAll(line1,line2,line3,line4,line5,line6,line7,line8);
        //group.setTranslateX(10);
        translate.setByX(400);

        //setting the duration for the Translate transition
        translate.setDuration(Duration.millis(5000));

        //setting cycle count for the Translate transition
        translate.setCycleCount(500);

        //the transition will set to be auto reversed by setting this to true
        translate.setAutoReverse(false);

        //setting Circle as the node onto which the transition will be applied
        translate.setNode(group);

        //playing the transition
        translate.play();

        pane.getChildren().add(group);
    }
}
