package com.example.s4_zadanie_3;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Raindrop extends WeatherObject{
    private double[] xPoints = {4,0,4,8,4};
    private double[] yPoints = {0,10,14,10,0};

    public Raindrop(int x, int y){
        super(x,y);
    }

    protected void pohyb(){
        if(!stop) {
            this.setLayoutY(this.getLayoutY() + 5);
            if (this.getLayoutY() > 240) {
                del();
                t.stop();
            }
        }
    }

    protected void vykresli(){
        gc.setFill(Color.LIGHTBLUE);
        gc.fillPolygon(xPoints,yPoints,5);
    }
}
