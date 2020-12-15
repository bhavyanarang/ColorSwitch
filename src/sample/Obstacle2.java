package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;

public class Obstacle2 extends Obstacle {
    Pane pane=new Pane();
    TranslateTransition translate1=new TranslateTransition();

    Group group2=new Group();

    Line line11=new Line();
    Line line12=new Line();
    Line line13=new Line();
    Line line14=new Line();
    Line line15=new Line();
    Line line16=new Line();
    Line line17=new Line();
    Line line18=new Line();

    TranslateTransition translate2=new TranslateTransition();
    Line line21=new Line();
    Line line22=new Line();
    Line line23=new Line();
    Line line24=new Line();
    Line line25=new Line();
    Line line26=new Line();
    Line line27=new Line();
    Line line28=new Line();

    @Override
    public Group returnObstacle2(){
        return group2;
    }

    @Override
    public void move(){

        group.getChildren().addAll(line11,line12,line13,line14,line15,line16,line17,line18);
        //group.setTranslateX(10);
        translate1.setByX(400);

        //setting the duration for the Translate transition
        translate1.setDuration(Duration.millis(6000));

        //setting cycle count for the Translate transition
        translate1.setCycleCount(500);

        //the transition will set to be auto reversed by setting this to true
        translate1.setAutoReverse(false);
        translate1.setInterpolator(Interpolator.LINEAR);

        //setting Circle as the node onto which the transition will be applied
        translate1.setNode(group);

        //playing the transition
        translate1.play();


        group2.getChildren().addAll(line21,line22,line23,line24,line25,line26,line27,line28);
        //group.setTranslateX(10);
        translate2.setByX(-400);

        //setting the duration for the Translate transition
        translate2.setDuration(Duration.millis(8000));

        //setting cycle count for the Translate transition
        translate2.setCycleCount(500);

        //the transition will set to be auto reversed by setting this to true
        translate2.setAutoReverse(false);
        translate2.setInterpolator(Interpolator.LINEAR);

        //setting Circle as the node onto which the transition will be applied
        translate2.setNode(group2);

        //playing the transition
        translate2.play();

        pane.getChildren().addAll(group,group2);
        //group.getChildren().addAll(line11,line12,line13,line14,line15,line16,line17,line18,line21,line22,line23,line24,line25,line26,line27,line28);

    }

    Obstacle2(int centerX,int centerY){
        super(centerX,centerY);

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

        line11.setStartX(-400);
        line11.setStartY(200);
        line11.setEndX(-300);
        line11.setEndY(200);
        line11.setStrokeType(StrokeType.CENTERED);
        line11.setStroke(Color.RED);
        line11.setStrokeWidth(10);

        line12.setStartX(-300);
        line12.setStartY(200);
        line12.setEndX(-200);
        line12.setEndY(200);
        line12.setStrokeType(StrokeType.CENTERED);
        line12.setStroke(Color.BLUE);
        line12.setStrokeWidth(10);

        line13.setStartX(-200);
        line13.setStartY(200);
        line13.setEndX(-100);
        line13.setEndY(200);
        line13.setStrokeType(StrokeType.CENTERED);
        line13.setStroke(Color.VIOLET);
        line13.setStrokeWidth(10);

        line14.setStartX(-100);
        line14.setStartY(200);
        line14.setEndX(0);
        line14.setEndY(200);
        line14.setStrokeType(StrokeType.CENTERED);
        line14.setStroke(Color.YELLOW);
        line14.setStrokeWidth(10);

        line15.setStartX(0);
        line15.setStartY(200);
        line15.setEndX(100);
        line15.setEndY(200);
        line15.setStrokeType(StrokeType.CENTERED);
        line15.setStroke(Color.RED);
        line15.setStrokeWidth(10);

        line16.setStartX(100);
        line16.setStartY(200);
        line16.setEndX(200);
        line16.setEndY(200);
        line16.setStrokeType(StrokeType.CENTERED);
        line16.setStroke(Color.BLUE);
        line16.setStrokeWidth(10);

        line17.setStartX(200);
        line17.setStartY(200);
        line17.setEndX(300);
        line17.setEndY(200);
        line17.setStrokeType(StrokeType.CENTERED);
        line17.setStroke(Color.VIOLET);
        line17.setStrokeWidth(10);

        line18.setStartX(300);
        line18.setStartY(200);
        line18.setEndX(400);
        line18.setEndY(200);
        line18.setStrokeType(StrokeType.CENTERED);
        line18.setStroke(Color.YELLOW);
        line18.setStrokeWidth(10);

        line21.setStartX(800);
        line21.setStartY(212);
        line21.setEndX(700);
        line21.setEndY(212);
        line21.setStrokeType(StrokeType.CENTERED);
        line21.setStroke(Color.RED);
        line21.setStrokeWidth(10);

        line22.setStartX(700);
        line22.setStartY(212);
        line22.setEndX(600);
        line22.setEndY(212);
        line22.setStrokeType(StrokeType.CENTERED);
        line22.setStroke(Color.BLUE);
        line22.setStrokeWidth(10);

        line23.setStartX(600);
        line23.setStartY(212);
        line23.setEndX(500);
        line23.setEndY(212);
        line23.setStrokeType(StrokeType.CENTERED);
        line23.setStroke(Color.VIOLET);
        line23.setStrokeWidth(10);

        line24.setStartX(500);
        line24.setStartY(212);
        line24.setEndX(400);
        line24.setEndY(212);
        line24.setStrokeType(StrokeType.CENTERED);
        line24.setStroke(Color.YELLOW);
        line24.setStrokeWidth(10);

        line25.setStartX(400);
        line25.setStartY(212);
        line25.setEndX(300);
        line25.setEndY(212);
        line25.setStrokeType(StrokeType.CENTERED);
        line25.setStroke(Color.RED);
        line25.setStrokeWidth(10);

        line26.setStartX(300);
        line26.setStartY(212);
        line26.setEndX(200);
        line26.setEndY(212);
        line26.setStrokeType(StrokeType.CENTERED);
        line26.setStroke(Color.BLUE);
        line26.setStrokeWidth(10);

        line27.setStartX(200);
        line27.setStartY(212);
        line27.setEndX(100);
        line27.setEndY(212);
        line27.setStrokeType(StrokeType.CENTERED);
        line27.setStroke(Color.VIOLET);
        line27.setStrokeWidth(10);

        line28.setStartX(100);
        line28.setStartY(212);
        line28.setEndX(0);
        line28.setEndY(212);
        line28.setStrokeType(StrokeType.CENTERED);
        line28.setStroke(Color.YELLOW);
        line28.setStrokeWidth(10);

        move();

    }
}
