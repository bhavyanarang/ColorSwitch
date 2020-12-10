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
    private double prevPaneTranslate=0;
    private int timesPaneDown=1;
    boolean colorSwitcherHit=false;
    boolean obstacleHit=false;
    boolean moveDown=false;
    private Scorecard scorecard;
    private Star star;
    private Ball ball;
    private PauseMenuController pauseMenuController;
    private ColorSwitcher colorSwitcher;
    private Pause pause;
    private Player player;
    private ArrayList<Obstacle> Obstacles;
    private Obstacle nakliObstacle;
    private boolean jumpPressed=false;
    private int jumpCount=0;
    private int downCount=0;
    public void initialize(){
        colorSwitcher.getColorSwitcher().setLayoutX(0);
        colorSwitcher.getColorSwitcher().setLayoutY(80);
        colorSwitcher.getColorSwitcher().setScaleX(0.5);
        colorSwitcher.getColorSwitcher().setScaleY(0.5);

    }
    public void startNewGame() {
        int Obstaclenumber=new Random().nextInt(8-1)+1;
        while(Obstaclenumber==6 || Obstaclenumber==7 || Obstaclenumber==1){
            Obstaclenumber=new Random().nextInt(8-1)+1;
        }
        Obstacle presentOb=Obstacles.get(Obstaclenumber-1);
        nakliObstacle=presentOb;
        //if(Obstaclenumber==2 || Obstaclenumber==3 || Obstaclenumber==5 || Obstaclenumber==6 || Obstaclenumber==7 || Obstaclenumber==8){
            this.pane.getChildren().setAll(colorSwitcher.getColorSwitcher(),ball.getBall(), pause.getPauseButton(), scorecard.getLabel(), star.getImg(),presentOb.returnObstacle(),presentOb.returnObstacle2());
        //}

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
            }
        }
    }
    private void didHitColorSwitcher(){
        for(int i=1;i<=4;i++){
            Shape shape=Shape.intersect(ball.getBall(),colorSwitcher.getArc(i));
            if(shape.getBoundsInParent().getHeight()>=0) {
                ball.changeColor();
                colorSwitcherHit=true;
                Pane variable= (Pane) colorSwitcher.getColorSwitcher().getParent();
                if(variable!=null)
                    variable.getChildren().remove(colorSwitcher.getColorSwitcher());
            }
        }
    }
    private void didHitStar(){
        Shape shape=Shape.intersect(ball.getBall(),star.toCheckHit());
        if(shape.getBoundsInParent().getHeight()>=0){
            Pane variable= (Pane) star.getImg().getParent();
            if(variable!=null)
                variable.getChildren().remove(this.star.getImg());
            starHit=true;
        }
    }
    private boolean translatePane(){
        double y=ball.getBall().getTranslateY();
        double z=-1*y+40;
//        System.out.println(z);
//        System.out.println(prevPaneTranslate);
        if(z<prevPaneTranslate+75){
            return false;
        }
        else{
            prevPaneTranslate=z;
            //timesPaneDown++;
            return true;
        }
    }
    AnimationTimer t1=new AnimationTimer() {
        @Override
        public void handle(long l) {
            if(!pause.getPauseButton().isPressed())
                ball.addGravity();

//            if(translatePane()){
//                timesPaneDown++;
//                moveDown=true;
////                pane.setTranslateY(timesPaneDown*10);
//            }

            //moveDown=translatePane();

            if(!starHit)
                didHitStar();

            if(!colorSwitcherHit)
                didHitColorSwitcher();

            if(!obstacleHit){
                try {
                    checkObstacleHit(nakliObstacle);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(jumpPressed){
                System.out.println(ball.getBall().getBoundsInParent().getCenterY());
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
                    System.out.println("down " +downCount);
                    double getDown=(timesPaneDown-1)*20+downCount;
                    colorSwitcher.getColorSwitcher().setTranslateY(getDown);
                    star.getImg().setTranslateY(getDown);
                    star.toCheckHit().setTranslateY(getDown);
                    nakliObstacle.returnObstacle().setTranslateY(getDown);
                    nakliObstacle.returnObstacle2().setTranslateY(getDown);
                }
            }

        }

    };

    public Game(Pane p){
        this.pane=p;
        scorecard=new Scorecard();
        star=new Star();
        ball=new Ball();
        pauseMenuController=new PauseMenuController();
        colorSwitcher=new ColorSwitcher();
        pause=new Pause();
        player=new Player();
        colorSwitcher=new ColorSwitcher();
        initialize();

        Obstacles=new ArrayList<Obstacle>(0);
        Obstacles.add(new Obstacle1(200,200));
        Obstacles.add(new Obstacle2(200,200));
        Obstacles.add(new Obstacle3(200,200));
        Obstacles.add(new Obstacle4(200,200));
        Obstacles.add(new Obstacle5(200,200));
        Obstacles.add(new Obstacle6(200,200));
        Obstacles.add(new Obstacle7(200,200));
        Obstacles.add(new Obstacle8(200,200));

        t1.start();
        pane.setOnMouseClicked(event->{
            jumpPressed=true;
        });
    }

}
