package com.example.s4_zadanie1;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML private Pane root;
    private MyCircle kruh;
    private MyRectangle rec;
    private MySquare sqr;

    @FXML private void initialize(){
        kruh = new MyCircle((float)Math.random()*400,(float)Math.random()*400, Color.GREEN);
        rec = new MyRectangle((float)Math.random()*400,(float)Math.random()*400, Color.RED);
        sqr = new MySquare((float)Math.random()*400,(float)Math.random()*400, Color.ORANGE);
        root.getChildren().addAll(kruh, rec, sqr);
    }

    public void zmenaFarby(){
        for(int i=0; i<root.getChildren().size(); i++){
            Node d = root.getChildren().get(i);
            if(d instanceof MyCircle) ((MyCircle)d).beBlue();
        }
    }

    @FXML private void addMore(){
        kruh = new MyCircle((float)Math.random()*400,(float)Math.random()*400, Color.GREEN);
        rec = new MyRectangle((float)Math.random()*400,(float)Math.random()*400, Color.RED);
        sqr = new MySquare((float)Math.random()*400,(float)Math.random()*400, Color.ORANGE);
        root.getChildren().addAll(kruh, rec, sqr);
    }

    @FXML private void bNadol(){
        for(int i=0; i<root.getChildren().size(); i++){
            Node d = root.getChildren().get(i);
            if(d instanceof GeometricShape){
                if(d instanceof MyCircle)((MyCircle)d).nadol();
                if(d instanceof MyRectangle)((MyRectangle)d).nadol();
                if(d instanceof MySquare)((MySquare)d).nadol();
            }
        }
    }

}
