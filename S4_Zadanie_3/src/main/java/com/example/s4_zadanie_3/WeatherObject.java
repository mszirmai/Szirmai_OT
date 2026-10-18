package com.example.s4_zadanie_3;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public abstract class WeatherObject extends Canvas {
    GraphicsContext gc;
    Timeline t;
    public static boolean stop = false;

    public WeatherObject(int x, int y){
        super(60,40);
        this.setLayoutX(x); this.setLayoutY(y);
        gc = this.getGraphicsContext2D();
        t = new Timeline(new KeyFrame(Duration.millis(50),e->spracuj()));
        t.setCycleCount(Animation.INDEFINITE);;
        t.play();
    }

    private void spracuj(){
        gc.clearRect(0,0,getWidth(),getHeight());
        pohyb();
        vykresli();
    }

    protected void del(){
        ((Pane)getParent()).getChildren().remove(this);
    }

    public void mLeft(){
        this.setLayoutX(this.getLayoutX()-20);
    }

    protected abstract void vykresli();

    protected abstract void pohyb();
}
