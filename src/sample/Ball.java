package sample;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class Ball {
    Pane pane=new Pane();
//    AnimationTimer t1=new AnimationTimer() {
//        @Override
//        public void handle(long l) {
//            jump();
//        }
//    };
    TranslateTransition translate=new TranslateTransition();
    Circle ball;
    private double velocity=-100;                           //only in +y direction (in pixels/s)
    private final double max_velocity=-400;         //maximum velocity
    double y_coordinate=3;
    private final double centre_x=250;    //middle of pane
    private double centre_y=750;
    private final double radius=10;
    private final double gravity=5.0;
    int color=0;                //ranges from 0 to 3
    Color[] colors={Color.RED,Color.YELLOW,Color.BLUE,Color.VIOLET};

    public Ball(){
        ball=new Circle(centre_x,centre_y,radius,colors[color]);
        ball.setOpacity(0.8);
        jump();
        changeColor();
    }
    void changeColor(){
        if(this.getColor()!=3){
            this.color+=1;
        }
        else{
            this.color=0;
        }
        ball.setFill(colors[color]);
    }
    public Circle getBall(){
        return this.ball;
    }
    public void display(){
        TranslateTransition transition = new TranslateTransition();
        transition.setByY(-40);     //upward pixels
        transition.setDuration(Duration.millis(100));   //time in ms
        transition.setNode(ball);
        transition.play();
    }
    public void jump(){
        setVelocity(-100);
    }
    public int getColor(){
        return this.color;
    }
    public void setVelocity(double x){
        if(this.velocity+x>this.max_velocity){
            this.velocity=this.max_velocity;
        }
        else    this.velocity+=x;
    }
    public double getVelocity(){
        return this.velocity;
    }

}