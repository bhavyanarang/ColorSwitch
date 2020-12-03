package sample;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Obstacle7 extends Obstacle {
    Pane pane=new Pane();
    RotateTransition rotate1=new RotateTransition();
    RotateTransition rotate2=new RotateTransition();

    Arc arc11 = new Arc();
    Arc arc12 = new Arc();
    Arc arc13 = new Arc();
    Arc arc14 = new Arc();

    //upper arcs
    Arc arc21 = new Arc();
    Arc arc22 = new Arc();
    Arc arc23 = new Arc();
    Arc arc24 = new Arc();

    @Override
            public void move(){
        Group group1=new Group();
        group1.getChildren().addAll(arc11,arc12,arc13,arc14);

        rotate1.setAxis(Rotate.Z_AXIS);
        rotate1.setToAngle(720);
        rotate1.setCycleCount(Timeline.INDEFINITE);
        rotate1.setDuration(Duration.millis(6000));
        rotate1.setAutoReverse(false);
        rotate1.setNode(group1);
        rotate1.playFrom(Duration.millis(3000));
        rotate1.play();


        Group group2=new Group();
        group2.getChildren().addAll(arc21,arc22,arc23,arc24);

        rotate2.setAxis(Rotate.Z_AXIS);
        rotate2.setToAngle(360);
        rotate2.setCycleCount(Timeline.INDEFINITE);
        rotate2.setDuration(Duration.millis(6000));
        rotate2.setAutoReverse(false);
        rotate2.setNode(group2);
        rotate2.play();

        pane.getChildren().addAll(group1,group2);
    }
    Obstacle7(int centerX,int centerY){
        super(centerX,centerY);
        arc11.setCenterX(centerX);
        arc11.setCenterY(centerY-105);
        arc11.setRadiusX(100.0f);
        arc11.setRadiusY(100.0f);
        arc11.setStartAngle(0);
        arc11.setLength(90f);
        arc11.setFill(javafx.scene.paint.Color.TRANSPARENT);
        arc11.setStroke(Color.RED);
        arc11.setStrokeWidth(10);
        arc11.setType(ArcType.OPEN);

        arc12.setCenterX(centerX);
        arc12.setCenterY(centerY-105);
        arc12.setRadiusX(100.0f);
        arc12.setRadiusY(100.0f);
        arc12.setStartAngle(90);
        arc12.setLength(90f);
        arc12.setFill(javafx.scene.paint.Color.TRANSPARENT);
        arc12.setStroke(Color.BLUE);
        arc12.setStrokeWidth(10);
        arc12.setType(ArcType.OPEN);

        arc13.setCenterX(centerX);
        arc13.setCenterY(centerY-105);
        arc13.setRadiusX(100.0f);
        arc13.setRadiusY(100.0f);
        arc13.setStartAngle(180);
        arc13.setLength(90f);
        arc13.setFill(javafx.scene.paint.Color.TRANSPARENT);
        arc13.setStroke(Color.VIOLET);
        arc13.setStrokeWidth(10);
        arc13.setType(ArcType.OPEN);

        arc14.setCenterX(centerX);
        arc14.setCenterY(centerY-105);
        arc14.setRadiusX(100.0f);
        arc14.setRadiusY(100.0f);
        arc14.setStartAngle(270);
        arc14.setLength(90f);
        arc14.setFill(javafx.scene.paint.Color.TRANSPARENT);
        arc14.setStroke(Color.YELLOW);
        arc14.setStrokeWidth(10);
        arc14.setType(ArcType.OPEN);

        arc21.setCenterX(centerX);
        arc21.setCenterY(centerY+65);
        arc21.setRadiusX(60.0f);
        arc21.setRadiusY(60.0f);
        arc21.setStartAngle(0);
        arc21.setLength(90f);
        arc21.setFill(javafx.scene.paint.Color.TRANSPARENT);
        arc21.setStroke(Color.RED);
        arc21.setStrokeWidth(10);
        arc21.setType(ArcType.OPEN);

        arc22.setCenterX(centerX);
        arc22.setCenterY(centerY+65);
        arc22.setRadiusX(60.0f);
        arc22.setRadiusY(60.0f);
        arc22.setStartAngle(90);
        arc22.setLength(90f);
        arc22.setFill(javafx.scene.paint.Color.TRANSPARENT);
        arc22.setStroke(Color.BLUE);
        arc22.setStrokeWidth(10);
        arc22.setType(ArcType.OPEN);

        arc23.setCenterX(centerX);
        arc23.setCenterY(centerY+65);
        arc23.setRadiusX(60.0f);
        arc23.setRadiusY(60.0f);
        arc23.setStartAngle(180);
        arc23.setLength(90f);
        arc23.setFill(javafx.scene.paint.Color.TRANSPARENT);
        arc23.setStroke(Color.VIOLET);
        arc23.setStrokeWidth(10);
        arc23.setType(ArcType.OPEN);

        arc24.setCenterX(centerX);
        arc24.setCenterY(centerY+65);
        arc24.setRadiusX(60.0f);
        arc24.setRadiusY(60.0f);
        arc24.setStartAngle(270);
        arc24.setLength(90f);
        arc24.setFill(javafx.scene.paint.Color.TRANSPARENT);
        arc24.setStroke(Color.YELLOW);
        arc24.setStrokeWidth(10);
        arc24.setType(ArcType.OPEN);

        move();

    }
}
