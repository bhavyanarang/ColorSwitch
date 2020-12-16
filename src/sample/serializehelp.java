package sample;

import java.io.Serializable;

public class serializehelp implements Serializable {
    String saveAs;

    double ballX;
    double ballY;
    int ballcolor;

    double starX;
    double starY;

    double colorswitcherX;
    double colorswitcherY;

    int ObstacleNumber;
    double ObstaclenowX;
    double ObstaclenowY;

    double presentscore;

    serializehelp(String saveAs,double ballX,double ballY,int ballcolor,double starX,double starY,double colorswitcherX,double colorswitcherY,int ObstacleNumber,
                  double ObstaclenowX,double ObstaclenowY,double presentscore){
        this.saveAs=saveAs;
        this.ballX=ballX;
        this.ballY=ballY;
        this.ballcolor=ballcolor;

        this.starX=starX;
        this.starY=starY;

        this.colorswitcherX=colorswitcherX;
        this.colorswitcherY=colorswitcherY;

        this.ObstacleNumber=ObstacleNumber;
        this.ObstaclenowX=ObstaclenowX;
        this.ObstaclenowY=ObstaclenowY;

        this.presentscore=presentscore;
    }


}
