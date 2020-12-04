package sample;

import javafx.scene.Group;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public abstract class Obstacle {
    int centerX;
    int centerY;
    ArrayList<Shape> components=new ArrayList<Shape>(0);
    Group group=new Group();
    Group group2=new Group();

    Obstacle(int centerX,int centerYY){
        this.centerX=centerX;
        this.centerY=centerY;
    }
    public abstract void move();
    public Group returnObstacle(){
        return group;
    }
    public Group returnObstacle2(){ return group2; }
}
