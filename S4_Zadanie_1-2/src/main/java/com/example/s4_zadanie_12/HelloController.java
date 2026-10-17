package com.example.s4_zadanie_12;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class HelloController {
    @FXML private Pane root;
    private Herbivore herb;
    private Carnivore carn;

    @FXML private void initialize(){
        bAddAnimals();
    }

    @FXML private void bAddAnimals(){
        herb = new Herbivore((int)(Math.random()*350), (int)(Math.random()*360), 5, 10+(int)(Math.random()*140));
        carn = new Carnivore((int)(Math.random()*350), (int)(Math.random()*360), 10);
        root.getChildren().addAll(herb,carn);
    }

    @FXML private void bAddCarnivore(){
        carn = new Carnivore((int)(Math.random()*350), (int)(Math.random()*360), 10);
        root.getChildren().add(carn);
    }
    @FXML private void bAddHerbivore(){
        herb = new Herbivore((int)(Math.random()*350), (int)(Math.random()*360), 5, 10+(int)(Math.random()*140));
        root.getChildren().addAll(herb);
    }

    @FXML private void bReverseDir(){
        for(int i=0; i<root.getChildren().size(); i++){
            Node d = root.getChildren().get(i);
            if(d instanceof Carnivore) ((Carnivore)d).reverseDir();
        }
    }

    @FXML private void bStop(){
        for(int i=0; i<root.getChildren().size(); i++){
            Node d = root.getChildren().get(i);
            if(d instanceof Animal) ((Animal)d).stop();
        }
    }
}
