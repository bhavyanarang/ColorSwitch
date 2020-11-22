package sample;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Obstacle8 {
    Pane pane=new Pane();
    RotateTransition rotate1=new RotateTransition();
    Line line11=new Line();
    Line line12=new Line();
    Line line13=new Line();
    Line line14=new Line();
    Line line15=new Line();
    Line line16=new Line();
    Line line17=new Line();
    Line line18=new Line();

    RotateTransition rotate2=new RotateTransition();
    Line line21=new Line();
    Line line22=new Line();
    Line line23=new Line();
    Line line24=new Line();
    Line line25=new Line();
    Line line26=new Line();
    Line line27=new Line();
    Line line28=new Line();
    Obstacle8(){
        line11.setStartX(100);
        line11.setStartY(200);
        line11.setEndX(200);
        line11.setEndY(100);
        line11.setStrokeType(StrokeType.CENTERED);
        line11.setStroke(Color.RED);
        line11.setStrokeWidth(10);

        line12.setStartX(200);
        line12.setStartY(100);
        line12.setEndX(300);
        line12.setEndY(200);
        line12.setStrokeType(StrokeType.CENTERED);
        line12.setStroke(Color.BLUE);
        line12.setStrokeWidth(10);

        line13.setStartX(300);
        line13.setStartY(200);
        line13.setEndX(200);
        line13.setEndY(300);
        line13.setStrokeType(StrokeType.CENTERED);
        line13.setStroke(Color.VIOLET);
        line13.setStrokeWidth(10);

        line14.setStartX(200);
        line14.setStartY(300);
        line14.setEndX(100);
        line14.setEndY(200);
        line14.setStrokeType(StrokeType.CENTERED);
        line14.setStroke(Color.YELLOW);
        line14.setStrokeWidth(10);

        line21.setStartX(120);
        line21.setStartY(200);
        line21.setEndX(200);
        line21.setEndY(120);
        line21.setStrokeType(StrokeType.CENTERED);
        line21.setStroke(Color.VIOLET);
        line21.setStrokeWidth(10);

        line22.setStartX(200);
        line22.setStartY(120);
        line22.setEndX(280);
        line22.setEndY(200);
        line22.setStrokeType(StrokeType.CENTERED);
        line22.setStroke(Color.BLUE);
        line22.setStrokeWidth(10);

        line23.setStartX(280);
        line23.setStartY(200);
        line23.setEndX(200);
        line23.setEndY(280);
        line23.setStrokeType(StrokeType.CENTERED);
        line23.setStroke(Color.RED);
        line23.setStrokeWidth(10);

        line24.setStartX(200);
        line24.setStartY(280);
        line24.setEndX(120);
        line24.setEndY(200);
        line24.setStrokeType(StrokeType.CENTERED);
        line24.setStroke(Color.YELLOW);
        line24.setStrokeWidth(10);


        Group group1=new Group();
        group1.getChildren().addAll(line11,line12,line13,line14);

        rotate1.setAxis(Rotate.Z_AXIS);
        rotate1.setToAngle(720);
        rotate1.setCycleCount(Timeline.INDEFINITE);
        rotate1.setDuration(Duration.millis(12000));
        rotate1.setAutoReverse(false);
        rotate1.setNode(group1);
        //rotate1.playFrom(Duration.millis(1000));//delay in time
        rotate1.play();

        Group group2=new Group();
        group2.getChildren().addAll(line21,line22,line23,line24);

        rotate2.setAxis(Rotate.Z_AXIS);
        rotate2.setToAngle(720);
        rotate2.setCycleCount(Timeline.INDEFINITE);
        rotate2.setDuration(Duration.millis(8000));
        rotate2.setAutoReverse(false);
        rotate2.setNode(group2);
        rotate2.play();


        pane.getChildren().addAll(group1,group2);


    }

}
