package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Star {
    Image img;
    Circle circle;
    ImageView view;
    private double y=325;
    private double x=180;
    private double rad=40;
    Star(){
        img = new Image("Assets/star.gif");
        view = new ImageView(img);
        circle=new Circle();
        starPosition();
    }
    public void starPosition(){
        circle.setCenterX(x);
        circle.setCenterY(y);
        circle.setRadius(rad);
        view.setX(x);
        view.setY(y);
        view.setFitWidth(rad);
        view.setPreserveRatio(true);
    }
    public double getY(){
        return y;
    }
    public void setYCoordinate(double y1){
        y=y1;
        circle.setCenterY(y);
        view.setY(y);
    }
    public ImageView getImg() {
        return view;
    }
    public Shape toCheckHit(){
        return circle;
    }
}
