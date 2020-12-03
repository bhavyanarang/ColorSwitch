package sample;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;

public class Pause {
    public Button button;
    private Image img;
    private ImageView view;
    public Pause(){
        button =new Button();
        img= new Image("Assets/pause.png");
        view = new ImageView(img);
        addButton();
    }
    public void addButton(){
        view.setScaleX(view.getScaleX()*1);
        view.setScaleY(view.getScaleY()*1);
        button.setGraphic(view);
        button.setScaleX(view.getScaleX()*0.05);
        button.setScaleY(view.getScaleY()*0.05);
        button.setLayoutX(button.getLayoutX()+50);
        button.setLayoutY(button.getLayoutY()-350);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage newStage=(Stage) button.getScene().getWindow();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                newStage.setScene(new Scene(root,550,600));
                newStage.show();
            }
        });
    }
    public Button getPauseButton(){
        return button;
    }
}
