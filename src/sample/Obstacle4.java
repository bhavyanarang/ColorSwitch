package sample;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Obstacle4 {
    Pane pane=new Pane();
    RotateTransition rotate=new RotateTransition();
    Arc arc1 = new Arc();
    Arc arc2 = new Arc();
    Arc arc3 = new Arc();
    Arc arc4 = new Arc();
    Obstacle4(){

        arc1.setCenterX(200.0);
        arc1.setCenterY(200.0f);
        arc1.setRadiusX(90.0f);
        arc1.setRadiusY(90.0f);
        arc1.setStartAngle(0);
        arc1.setLength(90f);
        arc1.setFill(javafx.scene.paint.Color.TRANSPARENT);
        arc1.setStroke(Color.RED);
        arc1.setStrokeWidth(10);
        arc1.setType(ArcType.OPEN);

        arc2.setCenterX(200.0);
        arc2.setCenterY(200.0f);
        arc2.setRadiusX(90.0f);
        arc2.setRadiusY(90.0f);
        arc2.setStartAngle(90);
        arc2.setLength(90f);
        arc2.setFill(javafx.scene.paint.Color.TRANSPARENT);
        arc2.setStroke(Color.BLUE);
        arc2.setStrokeWidth(10);
        arc2.setType(ArcType.OPEN);

        arc3.setCenterX(200.0);
        arc3.setCenterY(200.0f);
        arc3.setRadiusX(90.0f);
        arc3.setRadiusY(90.0f);
        arc3.setStartAngle(180);
        arc3.setLength(90f);
        arc3.setFill(javafx.scene.paint.Color.TRANSPARENT);
        arc3.setStroke(Color.VIOLET);
        arc3.setStrokeWidth(10);
        arc3.setType(ArcType.OPEN);

        arc4.setCenterX(200.0);
        arc4.setCenterY(200.0f);
        arc4.setRadiusX(90.0f);
        arc4.setRadiusY(90.0f);
        arc4.setStartAngle(270);
        arc4.setLength(90f);
        arc4.setFill(javafx.scene.paint.Color.TRANSPARENT);
        arc4.setStroke(Color.YELLOW);
        arc4.setStrokeWidth(10);
        arc4.setType(ArcType.OPEN);

        Group group=new Group();
        group.getChildren().addAll(arc1,arc2,arc3,arc4);

        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setToAngle(720);
        rotate.setCycleCount(Timeline.INDEFINITE);
        rotate.setDuration(Duration.millis(6000));
        rotate.setAutoReverse(false);
        rotate.setNode(group);
        rotate.play();

        pane.getChildren().addAll(group);

    }
}
