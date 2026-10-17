package com.example.s4_zadanie_12;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;

public abstract class Animal extends Canvas {
    protected GraphicsContext gc;
    protected int speed;
    Timeline t;
    protected int smer = 1;
    protected boolean reverse = false;
    protected boolean moving = true;

    public Animal(int x, int y, int s){
        super(50,40);
        setLayoutX(x);
        setLayoutY(y);
        speed = s;
        gc = this.getGraphicsContext2D();
        t = new Timeline(new KeyFrame(Duration.millis(50), e->spracuj()));
        t.setCycleCount(Animation.INDEFINITE);
        t.play();
    }

    private void spracuj(){
        gc.clearRect(0,0,getWidth(),getHeight());
        if(moving) pohyb();
        vykresli();
    };

    public void reverseDir(){
        if(reverse) reverse=false;
        else if(!reverse) reverse=true;
    }

    public void stop(){
        if(moving) moving=false;
        else moving=true;
    }

    protected abstract void vykresli();

    protected abstract void pohyb();
}
