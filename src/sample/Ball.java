package sample;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

import java.util.Random;

public class Ball {

    TranslateTransition translate=new TranslateTransition();
    Random rand = new Random();
    Circle ball;
    private boolean flag=true;
    private double velocity=-100;                           //only in +y direction (in pixels/s)
    private final double max_velocity=-400;                 //maximum velocity
    double y_coordinate=3;
    private final double centre_x=200;                      //middle of pane
    private double centre_y=500;
    private final double radius=10;
    private final double gravity=50.0;
    int color = rand.nextInt(4);                 //ranges from 0 to 3
    Color[] colors={Color.RED,Color.YELLOW,Color.BLUE,Color.VIOLET};

    public Ball(){
        ball=new Circle(centre_x,centre_y,radius,colors[color]);
        ball.setOpacity(0.8);
        changeColor();
    }
    public void changeColor(){
        if(this.getColor()!=3){
            this.color+=1;
        }
        else{
            this.color=0;
        }
        ball.setFill(colors[color]);
    }
    public void addGravity(){

        if(!flag) {
            TranslateTransition transition = new TranslateTransition();
            transition.setByY(+80);                        //upward pixels
            transition.setDuration(Duration.millis(300));   //time in ms
            transition.setNode(ball);
            //transition.play();
        }
        //jump();
    }
    public Circle getBall(){
        return this.ball;
    }
    public void jump(){
        flag=false;
        TranslateTransition transition = new TranslateTransition();
        transition.setByY(-2000);                        //upward pixels
        transition.setDuration(Duration.millis(100));   //time in ms
        transition.setNode(ball);
        transition.play();

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
