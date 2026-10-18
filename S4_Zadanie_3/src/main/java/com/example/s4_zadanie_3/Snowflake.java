package com.example.s4_zadanie_3;

import javafx.scene.paint.Color;

public class Snowflake extends WeatherObject{


    public Snowflake(int x, int y){
        super(x,y);
    }

    protected void pohyb(){
        this.setLayoutY(this.getLayoutY()+2);
        this.setLayoutX(this.getLayoutX()-0.5);
        if(this.getLayoutY()>240) {
            del();
            t.stop();
        }
    }

    protected void vykresli(){
        gc.setStroke(Color.CYAN);
        gc.strokeLine(5,0,5,10);
        gc.strokeLine(0,5,10,5);

    }
}
