package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Star {
    Image img;
    ImageView view;
    Star(){
        img = new Image("Assets/star.gif");
        view = new ImageView(img);
    }

    public ImageView getImg() {
        return view;
    }
}
