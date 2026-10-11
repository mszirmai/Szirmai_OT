package com.example.s3_zadanie1;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class HelloController{
    @FXML private Pane root;
    Semafor s;

    @FXML private void draw(){
        s = new Semafor();
        root.getChildren().add(s);
    }

    @FXML protected void changeState(){
        s.zmenStav();
    }

    @FXML protected void startTimer(){
        s.start();
    }

    @FXML protected void turnOff(){
        s.startVypni();
    }
}
