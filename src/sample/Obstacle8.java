package sample;

import javafx.animation.Interpolator;
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

public class Obstacle8 extends Obstacle{
    Pane pane=new Pane();
    Group group2=new Group();
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

    @Override
    public void move(){
        group.getChildren().addAll(line11,line12,line13,line14);

        rotate1.setAxis(Rotate.Z_AXIS);
        rotate1.setToAngle(720);
        rotate1.setCycleCount(Timeline.INDEFINITE);
        rotate1.setDuration(Duration.millis(12000));
        rotate1.setAutoReverse(false);
        rotate1.setInterpolator(Interpolator.LINEAR);
        rotate1.setNode(group);
        //rotate1.playFrom(Duration.millis(1000));//delay in time
        rotate1.play();


        group2.getChildren().addAll(line21,line22,line23,line24);

        rotate2.setAxis(Rotate.Z_AXIS);
        rotate2.setToAngle(720);
        rotate2.setCycleCount(Timeline.INDEFINITE);
        rotate2.setDuration(Duration.millis(10000));
        rotate2.setAutoReverse(false);
        rotate2.setInterpolator(Interpolator.LINEAR);
        rotate2.setNode(group2);
        rotate2.play();


        pane.getChildren().addAll(group,group2);
    }

    @Override
    public boolean starOnCentre() {
        return true;
    }

    @Override
    public Group returnObstacle2(){
        return group2;
    }
    Obstacle8(int centerX,int centerY){
        super(centerX,centerY);
        obstacleNumber=8;
        components.add(line11);
        components.add(line12);
        components.add(line13);
        components.add(line14);
        components.add(line15);
        components.add(line16);
        components.add(line17);
        components.add(line18);

        components.add(line21);
        components.add(line22);
        components.add(line23);
        components.add(line24);
        components.add(line25);
        components.add(line26);
        components.add(line27);
        components.add(line28);

        line11.setStartX(centerX-100);
        line11.setStartY(centerY);
        line11.setEndX(centerX);
        line11.setEndY(centerY-100);
        line11.setStrokeType(StrokeType.CENTERED);
        line11.setStroke(Color.RED);
        line11.setStrokeWidth(10);

        line12.setStartX(centerX);
        line12.setStartY(centerY-100);
        line12.setEndX(centerX+100);
        line12.setEndY(centerY);
        line12.setStrokeType(StrokeType.CENTERED);
        line12.setStroke(Color.BLUE);
        line12.setStrokeWidth(10);

        line13.setStartX(centerX+100);
        line13.setStartY(centerY);
        line13.setEndX(centerX);
        line13.setEndY(centerY+100);
        line13.setStrokeType(StrokeType.CENTERED);
        line13.setStroke(Color.VIOLET);
        line13.setStrokeWidth(10);

        line14.setStartX(centerX);
        line14.setStartY(centerY+100);
        line14.setEndX(centerX-100);
        line14.setEndY(centerY);
        line14.setStrokeType(StrokeType.CENTERED);
        line14.setStroke(Color.YELLOW);
        line14.setStrokeWidth(10);

        line21.setStartX(centerX-80);
        line21.setStartY(centerY);
        line21.setEndX(centerX);
        line21.setEndY(centerY-80);
        line21.setStrokeType(StrokeType.CENTERED);
        line21.setStroke(Color.VIOLET);
        line21.setStrokeWidth(10);

        line22.setStartX(centerX);
        line22.setStartY(centerY-80);
        line22.setEndX(centerX+80);
        line22.setEndY(centerY);
        line22.setStrokeType(StrokeType.CENTERED);
        line22.setStroke(Color.BLUE);
        line22.setStrokeWidth(10);

        line23.setStartX(centerX+80);
        line23.setStartY(centerY);
        line23.setEndX(centerX);
        line23.setEndY(centerY+80);
        line23.setStrokeType(StrokeType.CENTERED);
        line23.setStroke(Color.RED);
        line23.setStrokeWidth(10);

        line24.setStartX(centerX);
        line24.setStartY(centerY+80);
        line24.setEndX(centerX-80);
        line24.setEndY(centerY);
        line24.setStrokeType(StrokeType.CENTERED);
        line24.setStroke(Color.YELLOW);
        line24.setStrokeWidth(10);

        move();

    }

}
