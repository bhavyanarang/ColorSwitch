package sample;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    Pane pane;
    private Scorecard scorecard;
    private Star star;
    private Ball ball;
    private PauseMenuController pauseMenuController;
    private ColorSwitcher colorSwitcher;
    private Pause pause;
    private Player player;
    private ArrayList<Obstacle> Obstacles;
    public void initialize(){

    }
    public void startNewGame() {
        int Obstaclenumber=new Random().nextInt(8-1)+1;
        Obstacle presentOb=Obstacles.get(Obstaclenumber-1);
        //if(Obstaclenumber==2 || Obstaclenumber==3 || Obstaclenumber==5 || Obstaclenumber==6 || Obstaclenumber==7 || Obstaclenumber==8){
            this.pane.getChildren().setAll(ball.getBall(), pause.getPauseButton(), scorecard.getLabel(), star.getImg(),presentOb.returnObstacle(),presentOb.returnObstacle2());
        //}

    }
    private boolean didHit(Obstacle presentOb){
        for (Shape shape:presentOb.components){
            Shape intersect = Shape.intersect(shape, ball.getBall());
            if (intersect.getBoundsInLocal().getWidth() != -1) {
                System.out.println("OOps");
                return true;
            }
        }
        return false;
    }
    private boolean didPause(){
        return false;
    }
    private boolean didHitStar(){
        return false;
    }
    public Game(Pane p){
        this.pane=p;
        scorecard=new Scorecard();
        star=new Star();
        ball=new Ball();
        pauseMenuController=new PauseMenuController();
        colorSwitcher=new ColorSwitcher();
        pause=new Pause();
        player=new Player();
        Obstacles=new ArrayList<Obstacle>(0);
        Obstacles.add(new Obstacle1(200,200));
        Obstacles.add(new Obstacle2(200,200));
        Obstacles.add(new Obstacle3(200,200));
        Obstacles.add(new Obstacle4(200,200));
        Obstacles.add(new Obstacle5(200,200));
        Obstacles.add(new Obstacle6(200,200));
        Obstacles.add(new Obstacle7(200,200));
        Obstacles.add(new Obstacle8(200,200));
    }


    

}
