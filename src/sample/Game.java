package sample;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
    private int numberOfObjects=3;
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
        stars=new Star[numberOfObjects];
        colorSwitchers=new ColorSwitcher[numberOfObjects];
        onscreenObstacles=new Obstacle[numberOfObjects];

        addNewRandomObjects(ball.getBall().getBoundsInParent().getCenterY());

        star=stars[0];

        pauseMenuController=new PauseMenuController();
        pause=new Pause();
        player=new Player();
        colorSwitcher=colorSwitchers[0];

    }
    public void addNewRandomObjects(double ballY){
        //System.out.println(ballY);

        for(int i=1;i<=numberOfObjects;i++){
            stars[i-1]=new Star();
            stars[i-1].setYCoordinate(ballY-100-200*i);

            colorSwitchers[i-1]=new ColorSwitcher();
            colorSwitchers[i-1].setCentre_y(ballY-200-200*i);


            int randomNumber=new Random().nextInt(8-1)+1;
            Obstacle variableObstacle;
            switch (randomNumber){
                case 1: variableObstacle=new Obstacle1(200,(int)ballY-150-400*i);
                        break;
                case 2: variableObstacle=new Obstacle2(200,(int)ballY-150-300*i);
                        break;
                case 3: variableObstacle=new Obstacle3(200,(int)ballY-150-300*i);
                        break;
                case 4: variableObstacle=new Obstacle4(200,(int)ballY-150-300*i);
                        break;
                case 5: variableObstacle=new Obstacle5(200,(int)ballY-150-300*i);
                        break;
                case 6: variableObstacle=new Obstacle6(200,(int)ballY-150-300*i);
                        break;
                case 7: variableObstacle=new Obstacle7(200,(int)ballY-150-300*i);
                        break;
                case 8: variableObstacle=new Obstacle8(200,(int)ballY-150-300*i);
                        break;

                default:
                    throw new IllegalStateException("Unexpected value: " + randomNumber);
            }
            variableObstacle.returnObstacle().setLayoutY(ballY-150-300*i);
            variableObstacle.returnObstacle2().setLayoutY(ballY-150-300*i);

            if(variableObstacle instanceof Obstacle1){
                variableObstacle.returnObstacle().setLayoutX(100);
                variableObstacle.returnObstacle2().setLayoutX(100);
            }
            onscreenObstacles[i-1]=variableObstacle;

        }
    }
    public void initialise_load(serializehelp helper){
        ball=new Ball();
        scorecard=new Scorecard();

        stars=new Star[numberOfObjects];
        colorSwitchers=new ColorSwitcher[numberOfObjects];
        onscreenObstacles=new Obstacle[numberOfObjects];

        pauseMenuController=new PauseMenuController();
        pause=new Pause();
        player=new Player();


        for(int i=1;i<=numberOfObjects;i++) {
            stars[i - 1] = new Star();
            stars[i - 1].setYCoordinate(helper.ballY - 100 - 200 * i);

            colorSwitchers[i - 1] = new ColorSwitcher();
            colorSwitchers[i - 1].setCentre_y(helper.ballY - 200 - 200 * i);
        }

        star=stars[0];
        colorSwitcher=colorSwitchers[0];

        ball.getBall().setCenterY(helper.ballY);
        ball.getBall().setCenterX(200);
        ball.setColor(helper.ballcolor);
        System.out.println("ball_ycor: "+ball.getBall().getBoundsInParent().getCenterY());

        int number=helper.ObstacleNumber;
        Obstacle variableObstacle;
        switch (number){
            case 1: variableObstacle=new Obstacle1(200,200);
                break;
            case 2: variableObstacle=new Obstacle2(200,200);
                break;
            case 3: variableObstacle=new Obstacle3(200,200);
                break;
            case 4: variableObstacle=new Obstacle4(200,200);
                break;
            case 5: variableObstacle=new Obstacle5(200,200);
                break;
            case 6: variableObstacle=new Obstacle6(200,200);
                break;
            case 7: variableObstacle=new Obstacle7(200,200);
                break;
            case 8: variableObstacle=new Obstacle8(200,200);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + number);
        }

        variableObstacle.returnObstacle().setLayoutY(helper.ballY);
        variableObstacle.returnObstacle2().setLayoutY(helper.ballY);

        if(variableObstacle instanceof Obstacle1){
            variableObstacle.returnObstacle().setLayoutX(100);
            variableObstacle.returnObstacle2().setLayoutX(100);
        }
        this.pane.getChildren().setAll(ball.getBall(), pause.getPauseButton(),scorecard.getLabel());
        this.pane.getChildren().add(variableObstacle.returnObstacle());
        this.pane.getChildren().add(variableObstacle.returnObstacle2());
        for(int i=0;i<numberOfObjects;i++) {
            //System.out.println("here");
            this.pane.getChildren().add(stars[i].getImg());
            this.pane.getChildren().add(colorSwitchers[i].getColorSwitcher());
        }
        currentObstacle=variableObstacle;
    }
    public void startNewGame() {

        //if(Obstaclenumber==2 || Obstaclenumber==3 || Obstaclenumber==5 || Obstaclenumber==6 || Obstaclenumber==7 || Obstaclenumber==8){
            this.pane.getChildren().setAll(ball.getBall(), pause.getPauseButton(),scorecard.getLabel());
        //}

        for(int i=0;i<numberOfObjects;i++){
            this.pane.getChildren().add(stars[i].getImg());
            this.pane.getChildren().add(colorSwitchers[i].getColorSwitcher());
            this.pane.getChildren().add(onscreenObstacles[i].returnObstacle());
            this.pane.getChildren().add(onscreenObstacles[i].returnObstacle2());
        }
        currentObstacle=onscreenObstacles[0];
    }
    private void checkObstacleHit(Obstacle presentObstacle) throws IOException {
        //for(int i=0;i<3;i++){
          //  presentObstacle=onscreenObstacles[i];

        for(Shape shape:presentObstacle.components) {
            Shape intersection = Shape.intersect(shape, ball.getBall());

            if (intersection.getBoundsInParent().getHeight() > 0) {
                if (shape.getStroke() != ball.getBall().getFill()) {

                    System.out.println(shape.getStroke());
                    System.out.println(ball.getBall().getFill());
                    System.out.println("hit");

                    AnchorPane pane1 = FXMLLoader.load(getClass().getResource("ObstacleHitMenu.fxml"));
                    pane.getChildren().setAll(pane1);
//                    for(int i=0;i<3;i++){
//                        this.pane.getChildren().remove(onscreenObstacles[i].returnObstacle());
//                        this.pane.getChildren().remove(onscreenObstacles[i].returnObstacle2());
//                    }
                    t1.stop();
                    obstacleHit = true;
                }
            }
        //}
        }
    }
    private void didHitColorSwitcher(){
        for(int i=0;i<=3;i++){
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
        if(colorSwitchersGone==numberOfObjects){
            colorSwitcherHit=true;
        }
        else{
            colorSwitcher=colorSwitchers[colorSwitchersGone];
            //currentObstacle=onscreenObstacles[colorSwitchersGone];
        }
    }
    private void didHitStar(){
        Circle ball1=ball.getBall();
        Circle star1= (Circle) star.toCheckHit();
//        Shape shape = Shape.intersect(ball.getBall(), star.toCheckHit());
        Shape shape = Shape.intersect(ball1, star1);
        if (shape.getBoundsInParent().getHeight() >= 0) {
            Pane variable = (Pane) star.getImg().getParent();
            if (variable != null) {
                variable.getChildren().remove(star.getImg());
                scorecard.setLabel();
                starsGone++;
            }
        }
        if(starsGone==numberOfObjects){
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
            if(pause.getPauseButton().isPressed()){

                String filename = "tester.txt";

                // Serialization
                try
                {
                    System.out.println("Heyy");
                    //Saving of object in a file
                    FileOutputStream file = new FileOutputStream(filename);
                    System.out.println("Obstacle_cor"+currentObstacle.group.getBoundsInParent().getCenterY());
                    ObjectOutputStream out = new ObjectOutputStream(file);
                    System.out.println("layoutY: "+ ball.getBall().getBoundsInParent().getCenterY());
                    // Method for serialization of object
                    out.writeObject(new serializehelp(ball.getBall().getBoundsInParent().getCenterX(),ball.getBall().getBoundsInParent().getCenterY(),ball.getColor(),200,200,200,400,currentObstacle.obstacleNumber,currentObstacle.returnObstacle().getBoundsInParent().getCenterX(),currentObstacle.returnObstacle2().getBoundsInParent().getCenterY(),1));
                    System.out.println("Heyy12");

                    out.close();
                    file.close();
                    System.out.println("Heyy13");

                    System.out.println("Object has been serialized");
                    pane.getChildren().removeAll();
                    this.stop();
                    AnchorPane pane1= FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
                    pane.getChildren().setAll(pane1);

                }
                catch(IOException ex)
                {
                    System.out.println("IOException is caught");
                    ex.printStackTrace();
                }
            }
            if(!starHit)
                didHitStar();

            if(!colorSwitcherHit)
                didHitColorSwitcher();

            if(!obstacleHit){
                try {
                    checkObstacleHit(currentObstacle);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(jumpPressed){
                if(ball.getBall().getBoundsInParent().getCenterY()<500){
                    moveDown=true;
                }
                if(jumpCount>20){
                    jumpPressed=false;
                    jumpCount=0;
                }
                else{
                    ball.jump();
                    jumpCount++;
                }
            }
            if(moveDown){
                if(downCount>20){
                    moveDown=false;
                    downCount=0;
                    timesPaneDown++;
                }
                else{
                    downCount+=2;
                    double getDown=(timesPaneDown-1)*20+downCount;
                    //colorSwitcher.getColorSwitcher().setTranslateY(getDown);
                    for(int i=0;i<numberOfObjects;i++){
                        stars[i].getImg().setTranslateY(getDown);
                        stars[i].toCheckHit().setTranslateY(getDown);
                        colorSwitchers[i].getColorSwitcher().setTranslateY(getDown);
                        //onscreenObstacles[i].returnObstacle().setTranslateY(getDown);
                        //onscreenObstacles[i].returnObstacle2().setTranslateY(getDown);

                    }
                    currentObstacle.returnObstacle().setTranslateY(getDown);
                    currentObstacle.returnObstacle2().setTranslateY(getDown);
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
    public Game(Pane p,serializehelp helper){
        this.pane=p;
        initialise_load(helper);

        t1.start();
        pane.setOnMouseClicked(event->{
            jumpPressed=true;
        });
    }

}
