package com.example.s4_zadanie1;

import javafx.scene.paint.Color;

public class MyRectangle extends GeometricShape {

    public MyRectangle(float x, float y, Color f){
        super(x,y,f);

    }

    protected void vykresli(){
        gc.setFill(farba);
        gc.fillRect(0,0,30,15);
    }

    protected void pohyb(){
        if(smer==1) setLayoutX(this.getLayoutX()+5);
        else if(smer==0) setLayoutX(this.getLayoutX()-5);
        if(this.getLayoutX()>360){
            smer=0;
        } else if(this.getLayoutX()<10) smer=1;
    }
}
