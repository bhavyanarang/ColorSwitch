package sample;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Game {
    AnchorPane pane;
    private Scorecard scorecard;
    private Star star;
    private Ball ball;
    private PauseMenuController pauseMenuController;
    private ColorSwitcher colorSwitcher;
    private Pause pause;
    private Player player;
    public void initialize(){

    }
    public void startNewGame(){
        this.pane.getChildren().setAll(ball.getBall(), pause.getPauseButton(),scorecard.getLabel(),star.getImg());
    }
    private boolean didHit(){
        return false;
    }
    private boolean didPause(){
        return false;
    }
    private boolean didHitStar(){
        return false;
    }
    public Game(AnchorPane p){
        this.pane=p;
        scorecard=new Scorecard();
        star=new Star();
        ball=new Ball();
        pauseMenuController=new PauseMenuController();
        colorSwitcher=new ColorSwitcher();
        pause=new Pause();
        player=new Player();
    }


    

}
