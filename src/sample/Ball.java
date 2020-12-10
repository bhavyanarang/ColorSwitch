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
    double y_coordinate=100;
    private final double jumpChangeY=-500;
    private final double centre_x=200;                      //middle of pane
    private double centre_y=500;
    private final double radius=10;
    private final double gravity=200;
    int color = rand.nextInt(4);                 //ranges from 0 to 3
    Color[] colors={Color.RED,Color.YELLOW,Color.BLUE,Color.VIOLET};

    public Ball(){
        ball=new Circle(centre_x,centre_y,radius,colors[color]);
        ball.setOpacity(1);
        changeColor();
    }
    public void changeColor(){
        int newColor= rand.nextInt(4);
        while(this.getColor()==newColor){
            newColor= rand.nextInt(4);
        }
        color=newColor;
        ball.setFill(colors[newColor]);
    }
    public void addGravity(){
        if(!flag) {
            TranslateTransition transition = new TranslateTransition();
            transition.setByY(gravity);                        //upward pixels
            transition.setNode(ball);
            transition.play();
            //y_coordinate-=1;
        }
    }
    public Circle getBall(){
        return this.ball;
    }
    public void jump(){
        flag=false;
        TranslateTransition transition = new TranslateTransition();
        transition.setByY(jumpChangeY);                        //upward pixels
        transition.setNode(ball);
        transition.play();
        //y_coordinate+=5;
    }
    public int getColor(){
        return this.color;
    }

}
