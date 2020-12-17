package sample;

import java.io.Serializable;

public class serializehelp implements Serializable {
    //public boolean[] colorSwitchersPassed;
    String saveAs;

    double ballX;
    double ballY;
    int ballcolor;

    double starX;
    double starY;
//
//    double colorswitcherX;
//    double colorswitcherY;

    int[] ObstacleNumber;
//    double ObstaclenowX;
//    double ObstaclenowY;
    Double[] starss;
    Double[] colorswitcherss;
    Double[] obstacless;

    int presentscore;

    int jumpCount;
    int downCount;
    int timesPaneDown;
    int starsGone;
    int colorSwitchersGone;
    int onscreen;
    int start;
    int end;
    boolean[] passed;
    boolean[] starsPassed;
    boolean[] colorSwitchersPassed;

    serializehelp(String saveAs,double ballX,double ballY,int ballcolor,Double[] starss,Double[] colorswitcherss,int[] ObstacleNumber,
                  Double[] obstacless,int presentscore,int jumpCount,int downCount,int timesPaneDown,int starsGone,int colorSwitchersGone,
                  int onscreen,int start,int end, boolean[] pass,boolean[] starsPassed1,boolean[] colorSwitchersPassed1){
        this.saveAs=saveAs;
        this.ballX=ballX;
        this.ballY=ballY;
        this.ballcolor=ballcolor;
        this.passed=pass;
        this.starsPassed=starsPassed1;
        this.colorSwitchersPassed=colorSwitchersPassed1;

        this.ObstacleNumber=ObstacleNumber;
        this.starss=starss;
        this.colorswitcherss=colorswitcherss;
        this.obstacless=obstacless;

        this.presentscore=presentscore;
        this.jumpCount=jumpCount;
        this.downCount=downCount;
        this.timesPaneDown=timesPaneDown;
        this.starsGone=starsGone;
        this.colorSwitchersGone=colorSwitchersGone;
        this.onscreen=onscreen;
        this.end=end;
        this.start=start;
    }


}