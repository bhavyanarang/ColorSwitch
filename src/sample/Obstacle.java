package sample;

public abstract class Obstacle {
    int centerX;
    int centerY;
    Obstacle(int centerX,int centerYY){
        this.centerX=centerX;
        this.centerY=centerY;
    }
    public abstract void move();
}
