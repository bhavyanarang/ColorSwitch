package sample;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    Pane pane;
    boolean starHit=false;
    boolean colorSwitcherHit=false;
    boolean obstacleHit=false;
    boolean moveDown=false;
    private boolean jumpPressed=false;

    private Scorecard scorecard;
    private Star star;
    private Ball ball;
    private PauseMenuController pauseMenuController;
    private ColorSwitcher colorSwitcher;
    private Pause pause;
    private Player player;
    private ArrayList<Obstacle> Obstacles;
    private Obstacle currentObstacle;

    private Star[] stars;
    private ColorSwitcher[] colorSwitchers;
    private Obstacle[] onscreenObstacles;

    private int jumpCount=0;
    private int downCount=0;
    private int timesPaneDown=1;
    private int starsGone=0;
    private int colorSwitchersGone=0;
    private int obstaclesGone=0;

    public void initialize(){
        Obstacles=new ArrayList<Obstacle>(0);
        Obstacles.add(new Obstacle1(200,200));
        Obstacles.add(new Obstacle2(200,200));
        Obstacles.add(new Obstacle3(200,200));
        Obstacles.add(new Obstacle4(200,200));
        Obstacles.add(new Obstacle5(200,200));
        Obstacles.add(new Obstacle6(200,200));
        Obstacles.add(new Obstacle7(200,200));
        Obstacles.add(new Obstacle8(200,200));
        ball=new Ball();
        scorecard=new Scorecard();
        stars=new Star[3];
        colorSwitchers=new ColorSwitcher[3];
        onscreenObstacles=new Obstacle[3];

        addNewRandomObjects(ball.getBall().getBoundsInParent().getCenterY());
//        for(int i=0;i<3;i++){
//            stars[i]=new Star();
//            stars[i].setYCoordinate(325-200*i);
//
//            colorSwitchers[i]=new ColorSwitcher();
//            colorSwitchers[i].setCentre_y(300-200*i);
//        }
        star=stars[0];

        pauseMenuController=new PauseMenuController();
        pause=new Pause();
        player=new Player();
        colorSwitcher=colorSwitchers[0];

    }
    public void addNewRandomObjects(double ballY){
        System.out.println(ballY);
        int randomNumber=new Random().nextInt(8-1)+1;
        for(int i=1;i<=3;i++){
            stars[i-1]=new Star();
            stars[i-1].setYCoordinate(ballY-100-200*i);

            colorSwitchers[i-1]=new ColorSwitcher();
            colorSwitchers[i-1].setCentre_y(ballY-200-200*i);

            if(i==1){
                onscreenObstacles[i - 1]=Obstacles.get(randomNumber);
            }
            else if(i==2){
                onscreenObstacles[i-1]=Obstacles.get((i+2)%8);
            }
            else{
                onscreenObstacles[i-1]=Obstacles.get((i-2)%8);
            }
            onscreenObstacles[i - 1].returnObstacle().setLayoutY(ballY - 150 - 300 * i);
            onscreenObstacles[i - 1].returnObstacle2().setLayoutY(ballY - 150 - 300 * i);
            if(onscreenObstacles[i-1] instanceof Obstacle1){
                onscreenObstacles[i-1].returnObstacle().setLayoutY(100);
                onscreenObstacles[i-1].returnObstacle2().setLayoutY(100);
            }
        }
    }
    public void startNewGame() {

        //if(Obstaclenumber==2 || Obstaclenumber==3 || Obstaclenumber==5 || Obstaclenumber==6 || Obstaclenumber==7 || Obstaclenumber==8){
            this.pane.getChildren().setAll(ball.getBall(), pause.getPauseButton(),scorecard.getLabel());
        //}

        for(int i=0;i<3;i++){
            this.pane.getChildren().add(stars[i].getImg());
            this.pane.getChildren().add(colorSwitchers[i].getColorSwitcher());
            this.pane.getChildren().add(onscreenObstacles[i].returnObstacle());
            this.pane.getChildren().add(onscreenObstacles[i].returnObstacle2());
        }
        currentObstacle=onscreenObstacles[0];

    }

    private void checkObstacleHit(Obstacle presentObstacle) throws IOException {
        for(Shape shape:presentObstacle.components){
            Shape intersection=Shape.intersect(shape,ball.getBall());

            if(intersection.getBoundsInParent().getHeight()>0){
                if(shape.getStroke()!=ball.getBall().getFill()){

                    System.out.println(shape.getStroke());
                    System.out.println(ball.getBall().getFill());
                    System.out.println("hit");

                    AnchorPane pane1= FXMLLoader.load(getClass().getResource("ObstacleHitMenu.fxml"));
                    pane.getChildren().setAll(pane1);
                    t1.stop();
                }
                obstacleHit=true;
                for(int i=0;i<3;i++){
                    this.pane.getChildren().remove(onscreenObstacles[i].returnObstacle());
                    this.pane.getChildren().remove(onscreenObstacles[i].returnObstacle2());
                }
            }

        }
    }
    private void didHitColorSwitcher(){
        for(int i=1;i<=4;i++){
            Shape shape=Shape.intersect(ball.getBall(),colorSwitcher.getArc(i));
            if(shape.getBoundsInParent().getHeight()>=0) {
                ball.changeColor();
                Pane variable= (Pane) colorSwitcher.getColorSwitcher().getParent();
                if(variable!=null){
                    variable.getChildren().remove(colorSwitcher.getColorSwitcher());
                    colorSwitchersGone++;
                }
            }
        }
        if(colorSwitchersGone==3){
            colorSwitcherHit=true;
        }
        else{
            colorSwitcher=colorSwitchers[colorSwitchersGone];
            currentObstacle=onscreenObstacles[colorSwitchersGone];
        }
    }
    private void didHitStar(){

        Shape shape = Shape.intersect(ball.getBall(), star.toCheckHit());
        if (shape.getBoundsInParent().getHeight() >= 0) {
            Pane variable = (Pane) star.getImg().getParent();
            if (variable != null) {
                variable.getChildren().remove(star.getImg());
                scorecard.setLabel();
                starsGone++;
            }
        }
        if(starsGone==3){
            starHit=true;
        }
        else{
            star=stars[starsGone];
        }
    }
    AnimationTimer t1=new AnimationTimer() {
        @Override
        public void handle(long l) {
            if(!pause.getPauseButton().isPressed())
                ball.addGravity();

            if(!starHit)
                didHitStar();

            if(!colorSwitcherHit)
                didHitColorSwitcher();

//            if(!obstacleHit){
//                try {
//                    checkObstacleHit(currentObstacle);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }

            if(jumpPressed){
                if(ball.getBall().getBoundsInParent().getCenterY()<450){
                    moveDown=true;
                }
                if(jumpCount>10){
                    jumpPressed=false;
                    jumpCount=0;
                }
                else{
                    ball.jump();
                    jumpCount++;
                }
            }
            if(moveDown){
                if(downCount>10){
                    moveDown=false;
                    downCount=0;
                    timesPaneDown++;
                }
                else{
                    downCount+=2;
                    double getDown=(timesPaneDown-1)*20+downCount;
                    //colorSwitcher.getColorSwitcher().setTranslateY(getDown);
                    for(int i=0;i<3;i++){
                        stars[i].getImg().setTranslateY(getDown);
                        stars[i].toCheckHit().setTranslateY(getDown);
                        colorSwitchers[i].getColorSwitcher().setTranslateY(getDown);
                        onscreenObstacles[i].returnObstacle().setTranslateY(getDown);
                        onscreenObstacles[i].returnObstacle2().setTranslateY(getDown);

                    }
//                    currentObstacle.returnObstacle().setTranslateY(getDown);
//                    currentObstacle.returnObstacle2().setTranslateY(getDown);
                }
            }
        }

    };

    public Game(Pane p){
        this.pane=p;
        initialize();

        t1.start();
        pane.setOnMouseClicked(event->{
            jumpPressed=true;
        });
    }

}
