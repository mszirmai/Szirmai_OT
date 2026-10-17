package com.example.s4_zadanie_12;

import javafx.scene.paint.Color;

public class Carnivore extends Animal{

    public Carnivore(int x, int y, int s){
        super(50,40, s);
        setLayoutX(x);
        setLayoutY(y);
    }

    protected void vykresli(){
        gc.setFill(Color.RED);
        gc.fillOval(25,20,getWidth()/2,getHeight()/2);
    }

    protected void pohyb(){
        if(smer==1 && !reverse) {
            this.setLayoutX(this.getLayoutX() + speed);
            if(this.getLayoutX()>=350) smer=2;
        }
        else if(smer==1 && reverse){
            this.setLayoutX(this.getLayoutX() - speed);
            if(this.getLayoutX()<=0) smer=4;
        }
        if(smer==2 && !reverse) {
            this.setLayoutY(this.getLayoutY() + speed);
            if(this.getLayoutY()>=360) smer=3;
        }
        else if(smer==2 && reverse){
            this.setLayoutY(this.getLayoutY() - speed);
            if(this.getLayoutY()<=0) smer=1;
        }
        if(smer==3 && !reverse) {
            this.setLayoutX(this.getLayoutX() - speed);
            if(this.getLayoutX()<=0) smer=4;
        }
        else if(smer==3 && reverse){
            this.setLayoutX(this.getLayoutX() + speed);
            if(this.getLayoutX()>=350) smer=2;
        }
        if(smer==4 && !reverse) {
            this.setLayoutY(this.getLayoutY() - speed);
            if(this.getLayoutY()<=0) smer=1;
        }
        else if(smer==4 && reverse){
            this.setLayoutY(this.getLayoutY() + speed);
            if(this.getLayoutY()>=360) smer=3;
        }
    }
}
