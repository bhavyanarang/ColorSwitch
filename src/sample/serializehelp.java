package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class serializehelp implements Serializable {
    //String saveAs;

    double ballX;
    double ballY;
    int ballcolor;


    ArrayList<Integer> ObstacleNumber;
    ArrayList<Double> ObstacleY;
//    double ObstaclenowX;
//    double ObstaclenowY;

    Double[] starss;
    Double[] colorswitcherss;

    int presentscore;

    serializehelp(double ballX,double ballY,int ballcolor,Double[] starss,Double[] colorswitcherss,ArrayList<Integer> ObstacleNumber,ArrayList<Double> ObstacleY,int presentscore){
        //this.saveAs=saveAs;
        this.ballX=ballX;
        this.ballY=ballY;
        this.ballcolor=ballcolor;


        this.starss=starss;
        this.colorswitcherss=colorswitcherss;

        this.ObstacleNumber=ObstacleNumber;
        this.ObstacleY=ObstacleY;

        this.presentscore=presentscore;
    }


}
