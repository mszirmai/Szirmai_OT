package com.example.s3_zadanie1_2;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Auto extends Canvas {
    private GraphicsContext gc;
    private int rychlost;
    private boolean nastartovane;
    private Color farba;
    private Timeline t;
    private int smer = 1;

    public Auto(float x, float y, Color f, int r){
        super(50,40);
        this.setLayoutX(x);
        this.setLayoutY(y);
        farba=f;
        rychlost=r;
        nastartovane=false;
        gc = this.getGraphicsContext2D();
        vykresli();
        setOnKeyPressed(evt -> spracuj(evt));
        setFocusTraversable(true);
        requestFocus();
        t = new Timeline(new KeyFrame(Duration.millis(50), e -> tspracuj()));
        t.setCycleCount(Animation.INDEFINITE);
    }

    private void spracuj(KeyEvent evt){
        KeyCode k = evt.getCode();
        if(k==KeyCode.LEFT) dolava();
        if(k==KeyCode.RIGHT) doprava();
    }

    public void automatic(){
        t.play();
    }

    private void tspracuj(){
        if(smer==1) doprava();
        else dolava();

        if(this.getLayoutX()>265) smer=-1;
        if(this.getLayoutX()<5) smer=1;
    }

    public void startuj(){
        nastartovane=true;
        vykresli();
    }

    public void zastav(){
        nastartovane=false;
        t.stop();
        vykresli();
    }

    public void doprava(){
        if(nastartovane) this.setLayoutX(this.getLayoutX()+rychlost);
    }

    public void dolava(){
        if(nastartovane) this.setLayoutX(this.getLayoutX()-rychlost);
    }

    private void vykresli(){
        gc.clearRect(0,0,getWidth(),getHeight());
        gc.setFill(Color.BLACK);
        if(nastartovane) gc.strokeOval(1,30,10,4);
        gc.setFill(farba);
        gc.fillRect(11,25,30,10);
        gc.fillOval(14,20,15,10);
        gc.setFill(Color.BLACK);
        gc.fillOval(30,31,10,10);
        gc.fillOval(12,31,10,10);
    }
}
