package com.example.s4_zadanie_3;

import javafx.scene.paint.Color;

public class Cloud extends WeatherObject{
    private Color farba;

    public Cloud(int x, int y, Color f){
        super(x,y);
        farba = f;
    }

    protected void pohyb(){
        this.setLayoutX(this.getLayoutX()+1);
    }

    protected void beBlue(){
        farba = Color.BLUE;
    }

    protected void vykresli(){
        gc.setFill(farba);
        gc.fillOval(0,10,25,25);
        gc.fillOval(8,0,25,25);
        gc.fillOval(16,10,25,25);
        gc.fillOval(24,0,25,25);
        gc.fillOval(32,10,25,25);
    }
}
