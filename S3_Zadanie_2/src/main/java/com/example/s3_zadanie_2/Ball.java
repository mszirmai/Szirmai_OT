package com.example.s3_zadanie_2;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Ball extends Canvas {
    private int rychlost;
    GraphicsContext gc;
    private Color farba;
    private int smer=1;
    private Timeline t;
    private boolean bezi = true;

    public Ball(float x, float y, Color f, int r){
        super(32,32);
        this.setLayoutX(x);
        this.setLayoutY(y);
        farba=f;
        rychlost=r;
        t = new Timeline(new KeyFrame(Duration.millis(30), e -> spracuj()));
        t.setCycleCount(Animation.INDEFINITE);
        setOnKeyPressed(evt->processKey(evt));
        setOnMouseClicked(evt->processClicked());
        gc = this.getGraphicsContext2D();
        vykresli();
        setFocusTraversable(true);
        requestFocus();
    }

    private void processClicked(){
        if(bezi) {
            t.stop();
            bezi=false;
        }
        else{
            t.play();
            bezi=true;
        }
    }

    private void processKey(KeyEvent evt){
        KeyCode k = evt.getCode();
        if(k==KeyCode.F) rychlost+=1;
        if(k==KeyCode.S && rychlost>0) rychlost-=1;
    }

    public void start(){
        t.play();
    }

    private void spracuj(){
        if(smer==1) upright();
        if(smer==2) downright();
        if(smer==3) downleft();
        if(smer==4) upleft();

        if(this.getLayoutY()<0) smer=2;
        if(this.getLayoutX()>370) smer=3;
        if(this.getLayoutY()>370) smer=4;
        if(this.getLayoutX()<0) smer=1;

        vykresli();
    }

    private void upright(){ /*smer 1*/
        this.setLayoutX(this.getLayoutX()+rychlost);
        this.setLayoutY(this.getLayoutY()-rychlost);
    }

    private void downright(){ /*smer 2*/
        this.setLayoutX(this.getLayoutX()+rychlost);
        this.setLayoutY(this.getLayoutY()+rychlost);
    }

    private void downleft(){ /*smer 3*/
        this.setLayoutX(this.getLayoutX()-rychlost);
        this.setLayoutY(this.getLayoutY()+rychlost);
    }

    private void upleft(){ /*smer 4*/
        this.setLayoutX(this.getLayoutX()-rychlost);
        this.setLayoutY(this.getLayoutY()-rychlost);
    }

    private void vykresli(){
        gc.clearRect(0,0,400,400);
        gc.setFill(farba);
        gc.fillOval(15,15,15,15);
        gc.setStroke(Color.BLACK);
        gc.strokeOval(15,15,15, 15);
    }
}
