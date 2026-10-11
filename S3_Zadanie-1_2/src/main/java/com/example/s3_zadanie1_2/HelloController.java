package com.example.s3_zadanie1_2;

import javafx.fxml.FXML;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML private Pane root;
    private Auto car;

    @FXML private void initialize(){
        car = new Auto(10,100, Color.RED,5);
        root.getChildren().add(car);
    }

    @FXML protected void onStart(){
        car.startuj();
    }

    @FXML protected void onStop(){
        car.zastav();
    }

    @FXML protected void onLeft(){
        car.dolava();
    }

    @FXML protected void onRight(){
        car.doprava();
    }

    @FXML protected void onAutomatic(){
        car.automatic();
    }

}
