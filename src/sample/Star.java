package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Star {
    Image img;
    ImageView view;
    Star(){
        img = new Image("Assets/star.gif");
        view = new ImageView(img);
        starPosition();
    }
    public void starPosition(){
        view.setX(275);
        view.setY(325);
        view.setFitWidth(40);
        view.setPreserveRatio(true);
    }
    public ImageView getImg() {
        return view;
    }
}
