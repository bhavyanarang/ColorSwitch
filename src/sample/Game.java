package sample;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.io.*;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
    private int numberOfObjects=50;
    private Star[] stars;
    private ColorSwitcher[] colorSwitchers;
    private Obstacle[] onscreenObstacles;
    private boolean[] passed;
    private boolean[] starsPassed;
    private boolean[] colorSwitchersPassed;

    private int jumpCount=0;

    private int downCount=0;
    private int timesPaneDown=1;
    private int starsGone=0;
    private int colorSwitchersGone=0;
    private int onscreen=0;
    private int start=0;
    private int end=0;


    public void initialize(){

        ball=new Ball();
        scorecard=new Scorecard();
        stars=new Star[numberOfObjects];
        colorSwitchers=new ColorSwitcher[numberOfObjects];
        onscreenObstacles=new Obstacle[numberOfObjects];
        passed=new boolean[numberOfObjects];
        colorSwitchersPassed=new boolean[numberOfObjects];
        starsPassed=new boolean[numberOfObjects];

        addNewRandomObjects(ball.getBall().getBoundsInParent().getCenterY());

        star=stars[0];

        pauseMenuController=new PauseMenuController();
        pause=new Pause();
        player=new Player();
        colorSwitcher=colorSwitchers[0];

    }
    public void addNewRandomObjects(double ballY){

        for(int i=1;i<=numberOfObjects;i++){
            stars[i-1]=new Star();
            passed[i-1]=false;
            starsPassed[i-1]=false;
            colorSwitchersPassed[i-1]=false;
            colorSwitchers[i-1]=new ColorSwitcher();

            int randomNumber=new Random().nextInt(8-1)+1;

            if(i<numberOfObjects/4)             //hard obstacles come later in game (adding difficulty)
                while(randomNumber==2 || randomNumber==5 || randomNumber==7 || randomNumber== 8){
                    randomNumber=new Random().nextInt(8-1)+1;
                }

            Obstacle variableObstacle;
            switch (randomNumber){
                case 1: variableObstacle=new Obstacle1(200,(int)ballY-150-300*i);
                    //stars[i-1].setYCoordinate(variableObstacle.returnObstacle().getLayoutY()+20);
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

            variableObstacle.returnObstacle().setLayoutY(-200+ballY-275*i/2);
            variableObstacle.returnObstacle2().setLayoutY(-200+ballY-275*i/2);
            if(i<8){
                System.out.println("obs y " + i+" " +variableObstacle.returnObstacle().getBoundsInParent().getCenterY());
            }

            if(randomNumber==2){
                stars[i-1].setYCoordinate(-60+variableObstacle.returnObstacle().getBoundsInParent().getCenterY());
            }
            else{
                stars[i-1].setYCoordinate(-20+variableObstacle.returnObstacle().getBoundsInParent().getCenterY());
            }

            if(i==1){
                colorSwitchers[i-1].setCentre_y(300);
            }
            if(i>=2){
                double abc=variableObstacle.returnObstacle().getBoundsInParent().getCenterY()+onscreenObstacles[i-2].returnObstacle().getBoundsInParent().getCenterY();
                abc/=2;
                colorSwitchers[i-1].setCentre_y(abc);
            }

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

        jumpCount=helper.jumpCount;
        downCount=helper.downCount;
        timesPaneDown=helper.timesPaneDown;
        starsGone=helper.starsGone;
        colorSwitchersGone=helper.colorSwitchersGone;
        onscreen=helper.onscreen;
        start=helper.start;
        end=helper.end;

        ball.getBall().setCenterY(helper.ballY);
        ball.getBall().setCenterX(200);
        ball.setColor(helper.ballcolor);

        pause.getPauseButton().toFront();
        scorecard.getLabel().toFront();
        passed= helper.passed;
        colorSwitchersPassed=helper.colorSwitchersPassed;
        starsPassed=helper.starsPassed;
        int counter=0;
        boolean abc=false;
        this.pane.getChildren().setAll(ball.getBall(), pause.getPauseButton(),scorecard.getLabel());
        for(int i=1;i<=numberOfObjects;i++) {
            stars[i - 1] = new Star();
            stars[i - 1].setYCoordinate(helper.starss[i-1]);

            colorSwitchers[i - 1] = new ColorSwitcher();
            colorSwitchers[i - 1].setCentre_y(helper.colorswitcherss[i-1]-80);

            int number=helper.ObstacleNumber[i-1];
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

//            variableObstacle.returnObstacle().setLayoutY(-200+ballY-275*i/2);
//            variableObstacle.returnObstacle2().setLayoutY(-200+ballY-275*i/2);

            variableObstacle.returnObstacle().setLayoutY(helper.obstacless[i-1]);
            variableObstacle.returnObstacle2().setLayoutY(helper.obstacless[i-1]);
            //System.out.println("obstacle_cor: "+variableObstacle.returnObstacle().getBoundsInParent().getCenterY());

            if(variableObstacle instanceof Obstacle1){
                variableObstacle.returnObstacle().setLayoutX(100);
                variableObstacle.returnObstacle2().setLayoutX(100);
            }


            if(passed[i-1]==true && i!=numberOfObjects && passed[i]==false){
                abc=true;
                counter=i;
            }

            onscreenObstacles[i-1]=variableObstacle;
        }
        for(int i=counter;i<counter+4;i++){

            this.pane.getChildren().add(onscreenObstacles[i].returnObstacle());
            this.pane.getChildren().add(onscreenObstacles[i].returnObstacle2());
            if(!starsPassed[i])
                this.pane.getChildren().add(stars[i].getImg());
            if(!colorSwitchersPassed[i])
                this.pane.getChildren().add(colorSwitchers[i].getColorSwitcher());
        }
        onscreen=4;
        if(counter==0){
            start=counter;
            end=counter+4;
        }
        else{
            start=counter-1;
            end=counter+3;
        }
        currentObstacle=onscreenObstacles[start];
        star=stars[starsGone];
        colorSwitcher=colorSwitchers[colorSwitchersGone];
        System.out.println("ball"+ball.getBall().getBoundsInParent().getCenterY());


    }
    public void startNewGame() {

        //if(Obstaclenumber==2 || Obstaclenumber==3 || Obstaclenumber==5 || Obstaclenumber==6 || Obstaclenumber==7 || Obstaclenumber==8){
        pause.getPauseButton().toFront();
        scorecard.getLabel().toFront();
        this.pane.getChildren().setAll(ball.getBall(), pause.getPauseButton(),scorecard.getLabel());
        //}

        display();
        currentObstacle=onscreenObstacles[0];
    }
    public void display(){

        while(onscreen<4 ){
            //loadgame=false;
            //System.out.println("display");
            int i=onscreen+start;
            //System.out.println("no of stars"+i);
            try {
                this.pane.getChildren().add(onscreenObstacles[i].returnObstacle());
                this.pane.getChildren().add(onscreenObstacles[i].returnObstacle2());
                System.out.println("obs no"+onscreenObstacles[i].obstacleNumber);
                this.pane.getChildren().add(stars[i].getImg());

                this.pane.getChildren().add(colorSwitchers[i].getColorSwitcher());
                //System.out.println("good");
                onscreen++;
                end++;
            }
            catch (IllegalArgumentException e){
                System.out.println("children present");
                onscreen++;
            }
        }
    }
    public void remove(double getDown){

        for(int i=start;i<end;i++){
            if(this.pane.getChildren().contains(onscreenObstacles[i].returnObstacle()) || this.pane.getChildren().contains(onscreenObstacles[i].returnObstacle())){
                if(onscreenObstacles[i].returnObstacle().getBoundsInParent().getMinY()>600 || onscreenObstacles[i].returnObstacle2().getBoundsInParent().getMinY()>600){
                    try{
                           // System.out.println("remove");
                            this.pane.getChildren().remove(onscreenObstacles[i].returnObstacle());
                            this.pane.getChildren().remove(onscreenObstacles[i].returnObstacle2());
                            passed[i] = true;
                            onscreen--;
                            start++;
                    }
                    catch (IllegalArgumentException e){
                        System.out.println("removed");
                    }
                }
                else{
                    onscreenObstacles[i].returnObstacle().setTranslateY(getDown);
                    onscreenObstacles[i].returnObstacle2().setTranslateY(getDown);
                }
            }
        }


    }
    private void checkObstacleHit(Obstacle presentObstacle) throws IOException {


        ArrayList<Integer> abc=new ArrayList<>();
        if(starsGone==0){
            abc.add(0);
        }
        else{
            abc.add(starsGone-1);
            abc.add(starsGone);
            abc.add(starsGone+1);
        }
        for(int i:abc) {
            presentObstacle=onscreenObstacles[i];
            for (Shape shape : presentObstacle.components) {
                Shape intersection = Shape.intersect(shape, ball.getBall());

                if (intersection.getBoundsInParent().getHeight() > 0) {
                    if (shape.getStroke() != ball.getBall().getFill()) {

                        System.out.println(shape.getStroke());
                        System.out.println(ball.getBall().getFill());
                        System.out.println("hit");


                        FXMLLoader loader=new FXMLLoader(getClass().getResource("ObstacleHitMenu.fxml"));
                        Parent root=loader.load();
                        ObstacleHitMenuController controller=(ObstacleHitMenuController) loader.getController();
                        //Object o=loader.getController();
                        controller.initData(scorecard.getLabel().getText());
                        controller.setGame(this);
                        int ch=0;
                        String highscore="";
                        String allstars="";

                        try {

                            FileReader fileReader
                                    = new FileReader(
                                    "info.txt");
                            BufferedReader buffReader
                                    = new BufferedReader(
                                    fileReader);

                            while (buffReader.ready()) {
                                    highscore=buffReader.readLine();
                                    System.out.println(highscore);
                            }
                            // close the file
                            fileReader.close();
                            //ch-=48;
                        }
                        catch (IOException e)
                        {
                            System.out.println("Cannot read");
                        }

                        try{
                        FileReader fileReader
                                = new FileReader(
                                "allstars.txt");

                        BufferedReader buffReader
                                = new BufferedReader(
                                fileReader);

                        while (buffReader.ready()) {
                                allstars=buffReader.readLine();
                                System.out.println(allstars);
                        }
                        // close the file
                        fileReader.close();
                        //ch-=48;
                    }
                        catch (IOException ex)
                    {
                        System.out.println("Cannot read");
                    }

                        int Highscore=Integer.parseInt(highscore);
                        int Totalstars=Integer.parseInt(allstars);
                        int presentscore=Integer.parseInt(scorecard.getLabel().getText());
                        Totalstars+=presentscore;
                        if(presentscore>Highscore){
                            Highscore=presentscore;
                        }
                        controller.initHighScore(highscore);
                        controller.initstars(allstars);
                        //AnchorPane pane1 = FXMLLoader.load(getClass().getResource("ObstacleHitMenu.fxml"));
                        pane.getChildren().setAll(root);

                        t1.stop();
                        obstacleHit = true;
                        // Serialization
                        try {
                            int[] Obstaclenumber=new int[numberOfObjects];
                            Double[] ObstacleY=new Double[numberOfObjects];
                            Double[] starss=new Double[numberOfObjects];
                            Double[] colorSwitcherss=new Double[numberOfObjects];

                            for(int j=0;j<numberOfObjects;j++){
                                Obstaclenumber[j]=onscreenObstacles[j].obstacleNumber;
                                ObstacleY[j]=onscreenObstacles[j].group.getBoundsInParent().getCenterY();
                                starss[j]=stars[j].getImg().getBoundsInParent().getCenterY();
                                colorSwitcherss[j]=colorSwitchers[j].getColorSwitcher().getBoundsInParent().getCenterY();
                            }

                            FileOutputStream file = new FileOutputStream("Pause.txt");
                            System.out.println("Obstacle_cor" + currentObstacle.group.getBoundsInParent().getCenterY());
                            ObjectOutputStream out = new ObjectOutputStream(file);
                            System.out.println("Ball_cor: " + ball.getBall().getBoundsInParent().getCenterY());
                            // Method for serialization of object
                            //out.writeObject(new serializehelp("Delete",ball.getBall().getBoundsInParent().getCenterX(), ball.getBall().getBoundsInParent().getCenterY()-50, ball.getColor(), starss,colorSwitcherss,Obstaclenumber,ObstacleY, Integer.parseInt(scorecard.getLabel().getText()),jumpCount,downCount,timesPaneDown,starsGone,colorSwitchersGone,onscreen,start,end));
                            out.writeObject(new serializehelp("Pause",ball.getBall().getBoundsInParent().getCenterX(), ball.getBall().getBoundsInParent().getCenterY()-50, ball.getColor(), starss,colorSwitcherss,Obstaclenumber,ObstacleY, Integer.parseInt(scorecard.getLabel().getText()),jumpCount,downCount,timesPaneDown,starsGone,colorSwitchersGone,onscreen,start,end,passed,starsPassed,colorSwitchersPassed));
                            //chnged coordiantes of ball since it hit an obstacle

                            out.close();
                            file.close();
                            //System.out.println("Heyy13");

                            System.out.println("Object has been serialized");

//                            AnchorPane pane1 = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
//                            pane.getChildren().setAll(pane1);

                        } catch (IOException ex) {
                            System.out.println("IOException is caught");
                            ex.printStackTrace();
                        }
                    }
                }
            }
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
                    colorSwitchersPassed[colorSwitchersGone]=true;
                    colorSwitchersGone++;
                }
            }
        }
        if(colorSwitchersGone==numberOfObjects){
            colorSwitcherHit=true;
        }
        else{
            colorSwitcher=colorSwitchers[colorSwitchersGone];
        }
    }
    private void didHitStar(){
        Circle ball1=ball.getBall();
        Circle star1= (Circle) star.toCheckHit();

        Shape shape = Shape.intersect(ball1, star1);
        if (shape.getBoundsInParent().getHeight() >= 0) {
            Pane variable = (Pane) star.getImg().getParent();
            if (variable != null) {
                variable.getChildren().remove(star.getImg());
                scorecard.setLabel();
                starsPassed[starsGone]=true;
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
    public static void appendStrToFile(String fileName,
                                       String str)
    {
        try {

            // Open given file in append mode.
            BufferedWriter out = new BufferedWriter(
                    new FileWriter(fileName, true));
            out.write(str);
            out.close();
        }
        catch (IOException e) {
            System.out.println("exception occoured" + e);
        }
    }
    AnimationTimer t1=new AnimationTimer() {
        @Override
        public void handle(long l) {
            display();
//            System.out.println("start:" +start);
//            System.out.println("end: "+end);
            if (!pause.getPauseButton().isPressed())
                ball.addGravity();
            if (pause.getPauseButton().isPressed()) {

                //String filename = "tester.txt";
                this.stop();
                // Serialization
                try {
                    int[] Obstaclenumber=new int[numberOfObjects];
                    Double[] ObstacleY=new Double[numberOfObjects];
                    Double[] starss=new Double[numberOfObjects];
                    Double[] colorSwitcherss=new Double[numberOfObjects];

                    for(int i=0;i<numberOfObjects;i++){
                        Obstaclenumber[i]=onscreenObstacles[i].obstacleNumber;
                        ObstacleY[i]=onscreenObstacles[i].returnObstacle().getBoundsInParent().getCenterY();
                        starss[i]=stars[i].getImg().getBoundsInParent().getCenterY();
                        colorSwitcherss[i]=colorSwitchers[i].getColorSwitcher().getBoundsInParent().getCenterY();
                        //System.out.println("here"+colorSwitcherss[i]);
                    }

                    FileOutputStream file = new FileOutputStream("Pause.txt");
                    System.out.println("Obstacle_cor" + currentObstacle.group.getBoundsInParent().getCenterY());
                    ObjectOutputStream out = new ObjectOutputStream(file);
                    System.out.println("Ball_cor: " + ball.getBall().getBoundsInParent().getCenterY());
                    // Method for serialization of object
                    out.writeObject(new serializehelp("Pause",ball.getBall().getBoundsInParent().getCenterX(), ball.getBall().getBoundsInParent().getCenterY(), ball.getColor(), starss,colorSwitcherss,Obstaclenumber,ObstacleY, Integer.parseInt(scorecard.getLabel().getText()),jumpCount,downCount,timesPaneDown,starsGone,colorSwitchersGone,onscreen,start,end,passed,starsPassed,colorSwitchersPassed));
                    //System.out.println("Heyy12");

                    out.close();
                    file.close();
                    //System.out.println("Heyy13");
                    pane.getChildren().removeAll();
                    System.out.println("Object has been serialized");
//                    FXMLLoader loader=new FXMLLoader(getClass().getResource("PauseMenu.fxml"));
//                    Parent root=loader.load();
//                    PauseMenuController controller=(PauseMenuController) loader.getController();
//                    //Object o=loader.getController();
//                    //controller.initData(scorecard.getLabel().getText());
//                    controller.setGame(game);
//                    //AnchorPane pane1 = FXMLLoader.
//                    pane.getChildren().removeAll();
                    AnchorPane pane1 = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
                    pane.getChildren().setAll(pane1);

                } catch (IOException ex) {
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
                        remove(getDown);
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
            System.out.println("in jump"+ball.getBall().getBoundsInParent().getCenterY());
            jumpPressed=true;
        });
    }

}