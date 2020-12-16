package sample;

import javafx.scene.Group;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public abstract class Obstacle {
    int obstacleNumber;
    int centerX;
    int centerY;
    ArrayList<Shape> components=new ArrayList<Shape>(0);
    Group group=new Group();
    Group group2=new Group();

    Obstacle(int centerX,int centerYY){
        this.centerX=centerX;
        this.centerY=centerYY;
    }
    public abstract void move();
    public abstract boolean starOnCentre();
    public Group returnObstacle(){
        return group;
    }
    public Group returnObstacle2(){ return group2; }
}
