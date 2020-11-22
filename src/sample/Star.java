package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Star {
    Image img;
    Star(){
        img = new Image("Assets/star1.png");
        ImageView view = new ImageView(img);
    }

    public Image getImg() {
        return img;
    }
}
