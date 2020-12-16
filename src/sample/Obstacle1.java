package sample;

import com.sun.prism.paint.Paint;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Obstacle1 extends Obstacle {
    Pane pane=new Pane();
    RotateTransition rotate=new RotateTransition();
    Line line1=new Line();
    Line line2=new Line();
    Line line3=new Line();
    Line line4=new Line();


    @Override
    public void move(){
        group.getChildren().addAll(line1,line2,line3,line4);
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setToAngle(720);
        rotate.setCycleCount(Timeline.INDEFINITE);
        rotate.setDuration(Duration.millis(10000));
        rotate.setAutoReverse(false);
        rotate.setNode(group);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();
        pane.getChildren().add(group);
    }

    @Override
    public boolean starOnCentre() {
        return true;
    }

    Obstacle1(int centerX,int centerY){
        super(centerX,centerY);
        obstacleNumber=1;
        components.add(line1);
        components.add(line2);
        components.add(line3);
        components.add(line4);

        line1.setStartX(centerX);
        line1.setStartY(centerY);
        line1.setEndX(centerX+100);
        line1.setEndY(centerY);
        line1.setStrokeType(StrokeType.CENTERED);
        line1.setStroke(Color.RED);
        //line1.setFill(Color.RED);
        line1.setStrokeWidth(10);

        line2.setStartX(centerX);
        line2.setStartY(centerY);
        line2.setEndX(centerX);
        line2.setEndY(centerY-100);
        line2.setStrokeType(StrokeType.CENTERED);
        line2.setStroke(Color.BLUE);
        line2.setStrokeWidth(10);

        line3.setStartX(centerX);
        line3.setStartY(centerY);
        line3.setEndX(centerX-100);
        line3.setEndY(centerY);
        line3.setStrokeType(StrokeType.CENTERED);
        line3.setStroke(Color.VIOLET);
        line3.setStrokeWidth(10);

        line4.setStartX(centerX);
        line4.setStartY(centerY);
        line4.setEndX(centerX);
        line4.setEndY(centerY+100);
        line4.setStrokeType(StrokeType.CENTERED);
        line4.setStroke(Color.YELLOW);
        line4.setStrokeWidth(10);

        move();
    }
}
