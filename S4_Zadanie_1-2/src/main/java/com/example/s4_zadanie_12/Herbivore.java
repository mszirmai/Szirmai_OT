package com.example.s4_zadanie_12;

import javafx.scene.paint.Color;

public class Herbivore extends Animal{
    private int startX;
    private int startY;
    private int radius;



    public Herbivore(int x, int y, int s, int r){
        super(50,40, s);
        startX = x;
        startY = y;
        radius = r;
        setLayoutX(x);
        setLayoutY(y);
    }

    protected void vykresli(){
        gc.setFill(Color.GREEN);
        gc.fillRect(0,0,getWidth(),getHeight());
    }

    protected void pohyb(){
        if(smer==1 && !reverse) {
            this.setLayoutX(this.getLayoutX() + speed);
            if(this.getLayoutX()>=startX+radius) smer=2;
        }
        else if(smer==1 && reverse){
            this.setLayoutX(this.getLayoutX() - speed);
            if(this.getLayoutX()<=startX) smer=4;
        }
        if(smer==2 && !reverse) {
            this.setLayoutY(this.getLayoutY() + speed);
            if(this.getLayoutY()>=startY+radius) smer=3;
        }
        else if(smer==2 && reverse){
            this.setLayoutY(this.getLayoutY() - speed);
            if(this.getLayoutY()<=startY) smer=1;
        }
        if(smer==3 && !reverse) {
            this.setLayoutX(this.getLayoutX() - speed);
            if(this.getLayoutX()<=startX) smer=4;
        }
        else if(smer==3 && reverse){
            this.setLayoutX(this.getLayoutX() + speed);
            if(this.getLayoutX()>=startX+radius) smer=2;
        }
        if(smer==4 && !reverse) {
            this.setLayoutY(this.getLayoutY() - speed);
            if(this.getLayoutY()<=startY) smer=1;
        }
        else if(smer==4 && reverse){
            this.setLayoutY(this.getLayoutY() + speed);
            if(this.getLayoutY()>=startY+radius) smer=3;
        }

    }
}
