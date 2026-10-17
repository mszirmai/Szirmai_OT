package com.example.s4_zadanie1;

import javafx.scene.paint.Color;

public class MyCircle extends GeometricShape{
    private float startX, startY, uhol;

    public MyCircle(float x, float y, Color f){
        super(x,y,f);
        startX = x;
        startY = y;


    }

    protected void vykresli(){
        gc.setFill(farba);
        gc.fillOval(15,15,15,15);
    }

    public void pohyb(){
        setLayoutX(startX+20*Math.cos(uhol));
        setLayoutY(startY+20*Math.sin(uhol));
        uhol+= 0.1;
    }

    public void beBlue(){
        this.farba = Color.BLUE;
    }

    @Override
    public void nadol(){
        this.setLayoutY(this.getLayoutY()+30);
        startY = startY+30;
    }
}
