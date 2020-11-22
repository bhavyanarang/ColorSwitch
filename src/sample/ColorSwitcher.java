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

import java.awt.*;

public class ColorSwitcher {
    Pane pane=new Pane();
    RotateTransition rotate=new RotateTransition();

    Arc arc1=new Arc();
    Arc arc2=new Arc();
    Arc arc3=new Arc();
    Arc arc4=new Arc();
    ColorSwitcher(){
        arc1.setCenterX(200.0);
        arc1.setCenterY(200.0f);
        arc1.setRadiusX(30.0f);
        arc1.setRadiusY(30.0f);
        arc1.setStartAngle(0);
        arc1.setLength(90f);
        arc1.setFill(Color.RED);
        arc1.setStroke(Color.RED);
        arc1.setStrokeWidth(0);
        arc1.setType(ArcType.ROUND);

        arc2.setCenterX(200.0);
        arc2.setCenterY(200.0f);
        arc2.setRadiusX(30.0f);
        arc2.setRadiusY(30.0f);
        arc2.setStartAngle(90);
        arc2.setLength(90f);
        arc2.setFill(Color.BLUE);
        arc2.setStroke(Color.BLUE);
        arc2.setStrokeWidth(0);
        arc2.setType(ArcType.ROUND);

        arc3.setCenterX(200.0);
        arc3.setCenterY(200.0f);
        arc3.setRadiusX(30.0f);
        arc3.setRadiusY(30.0f);
        arc3.setStartAngle(180);
        arc3.setLength(90f);
        arc3.setFill(Color.VIOLET);
        arc3.setStroke(Color.VIOLET);
        arc3.setStrokeWidth(0);
        arc3.setType(ArcType.ROUND);

        arc4.setCenterX(200.0);
        arc4.setCenterY(200.0f);
        arc4.setRadiusX(30.0f);
        arc4.setRadiusY(30.0f);
        arc4.setStartAngle(270);
        arc4.setLength(90f);
        arc4.setFill(Color.YELLOW);
        arc4.setStroke(Color.YELLOW);
        arc4.setStrokeWidth(0);
        arc4.setType(ArcType.ROUND);

        Group group=new Group();
        group.getChildren().addAll(arc1,arc2,arc3,arc4);

        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setToAngle(360);
        rotate.setCycleCount(Timeline.INDEFINITE);
        rotate.setDuration(Duration.millis(5000));
        rotate.setAutoReverse(false);
        rotate.setNode(group);
        rotate.play();


        pane.getChildren().add(group);
    }
}
