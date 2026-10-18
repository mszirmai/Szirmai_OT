package com.example.s4_zadanie_3;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML private Pane root;
    private Cloud clo;
    private Raindrop rd;
    private Snowflake sf;


    @FXML private void addCloud(){
        clo = new Cloud((int)(Math.random()*260), (int)(Math.random()*90)+10, Color.LIGHTGRAY);
        root.getChildren().add(clo);
    }

    @FXML private void addRaindrop(){
        rd = new Raindrop((int)(Math.random()*310),(int)(Math.random()*150));
        root.getChildren().add(rd);
    }

    @FXML private void addSnowflake(){
        sf = new Snowflake((int)(Math.random()*310), (int)(Math.random()*150));
        root.getChildren().add(sf);
    }

    @FXML private void bStop(){
        if(WeatherObject.stop) WeatherObject.stop = false;
        else if(!WeatherObject.stop) WeatherObject.stop = true;
    }

    @FXML private void blueClouds(){
        for(int i=0; i<root.getChildren().size(); i++){
            Node d = root.getChildren().get(i);
            if(d instanceof Cloud) ((Cloud)d).beBlue();
        }
    }

    @FXML private void moveLeft(){
        for(int i=0; i<root.getChildren().size(); i++){
            Node d = root.getChildren().get(i);
            if(d instanceof WeatherObject) ((WeatherObject)d).mLeft();
        }
    }
}
