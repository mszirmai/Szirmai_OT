package com.example.s4_zadanie_2;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Robot extends Canvas {
    private GraphicsContext gc;
    Timeline t;
    private int dir =2;
    private int speed;
    private boolean auto = false;

    public Robot(int x, int y, int s){
        super(50,50);
        this.setLayoutX(x);
        this.setLayoutY(y);
        speed = s;
        gc = this.getGraphicsContext2D();
        setOnKeyPressed(evt->keySpracuj(evt));
        setOnMousePressed(e->mouseSpracuj());
        setFocusTraversable(true);
        requestFocus();
        t = new Timeline(new KeyFrame(Duration.millis(50), e->spracuj()));
        t.setCycleCount(Animation.INDEFINITE);
        t.play();
    }

    private void spracuj(){
        gc.clearRect(0,0,getWidth(),getHeight());
        vykresli();
        if(auto){
            if(dir==1){
                mRight();
                if(this.getLayoutX()>=280) mLeft();
            }
            else if(dir==2){
                mDown();
                if(this.getLayoutY()>=190) mUp();
            }
            else if(dir==3){
                mLeft();
                if(this.getLayoutX()<=-10) mRight();
            }
            else{
                mUp();
                if(this.getLayoutY()<-10) mDown();
            }
        }
    }

    private void keySpracuj(KeyEvent evt){
        KeyCode k = evt.getCode();
        if(!auto) {
            switch (k) {
                case D:
                    mRight();
                    break;
                case S:
                    mDown();
                    break;
                case A:
                    mLeft();
                    break;
                case W:
                    mUp();
                    break;
            }
        }
    }

    private void mouseSpracuj(){
        if(auto) auto=false;
        else auto=true;
    }

    private void mRight(){
        dir = 1;
        if(this.getLayoutX()<=275) this.setLayoutX(this.getLayoutX()+speed);
        else this.setLayoutX(280);

    }

    private void mDown(){
        dir = 2;
        if(this.getLayoutY()<=185) this.setLayoutY(this.getLayoutY()+speed);
        else this.setLayoutY(190);
        if(this.getLayoutX()<=-5) this.setLayoutX(this.getLayoutX()+speed*2);
        if(this.getLayoutX()>=280) this.setLayoutX(this.getLayoutX()-speed*2);
    }

    private void mLeft(){
        dir = 3;
        if(this.getLayoutX()>=-5)this.setLayoutX(this.getLayoutX()-speed);
        else this.setLayoutX(-10);

    }

    private void mUp(){
        dir = 4;
        if(this.getLayoutY()>=-10) this.setLayoutY(this.getLayoutY()-speed);
        else this.setLayoutY(-15);
        if(this.getLayoutX()<=-5) this.setLayoutX(this.getLayoutX()+speed*2);
        if(this.getLayoutX()>=280) this.setLayoutX(this.getLayoutX()-speed*2);

    }

    private void vykresli(){
        gc.setFill(Color.LIGHTBLUE);
        if(dir==1){
            gc.fillRect(10,15,30,35);
        }
        else if(dir==2){
            gc.fillRect(0,15,50,35);
            gc.setFill(Color.BLACK);
            gc.fillOval(10,25,5,20);
            gc.fillOval(35,25,5,20);
        }
        else if(dir==3){
            gc.fillRect(10,15,30,35);
        }
        else{
            gc.fillRect(0,15,50,35);
        }
    }
}
