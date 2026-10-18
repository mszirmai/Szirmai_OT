package com.example.s4_zadanie_2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class HelloController {
    @FXML private Pane root;
    private Robot robert;

    @FXML private void initialize(){
        robert = new Robot(100,100,5);
        root.getChildren().add(robert);
    }
}
