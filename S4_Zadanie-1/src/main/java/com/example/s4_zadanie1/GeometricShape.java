package com.example.s4_zadanie1;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public abstract class GeometricShape extends Canvas {
    protected GraphicsContext gc;
    protected Color farba;
    Timeline t;
    protected int smer = 1;

    public GeometricShape(float x, float y, Color f){
        super(30,30);
        setLayoutX(x);
        setLayoutY(y);
        farba=f;
        setFocusTraversable(true);
        gc=this.getGraphicsContext2D();
        t=new Timeline(new KeyFrame(Duration.millis(50),e->spracuj()));
        t.setCycleCount(Animation.INDEFINITE);
        t.play();
    }

    public void nadol(){
        this.setLayoutY(this.getLayoutY()+30);
    }

    private void spracuj(){
        gc.clearRect(0,0,30,30);
        pohyb();
        vykresli();
    }

    protected abstract void pohyb();

    protected abstract void vykresli();

}
