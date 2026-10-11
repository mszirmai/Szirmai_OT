package com.example.s3_zadanie_2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML private Pane root;
    private Ball ball;

    @FXML protected void initialize(){
        ball = new Ball(100,100, Color.RED,5);
        root.getChildren().add(ball);
        ball.start();
    }
}
