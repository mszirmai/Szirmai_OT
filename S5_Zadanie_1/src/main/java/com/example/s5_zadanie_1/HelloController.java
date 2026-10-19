package com.example.s5_zadanie_1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private ListView<String> list;
    @FXML private TextField textfield1;
    private int index = 0;

    private ObservableList<String> zoznam = FXCollections.observableArrayList();

    @FXML private void initialize(){
        list.setItems(zoznam);
        list.setOnMousePressed(e->{
            String osoba = list.getSelectionModel().getSelectedItem();
            if(osoba!=null){
                textfield1.setText(osoba);
            }
        });
    }

    @FXML protected void add(){
        if(!textfield1.getText().isEmpty()) {
            String name = textfield1.getText();
            zoznam.add(name);
        }
    }

    @FXML protected void delete(){
        if(!zoznam.get(list.getSelectionModel().getSelectedIndex()).isEmpty()) zoznam.remove(list.getSelectionModel().getSelectedIndex());
    }

    @FXML protected void edit(){
        zoznam.set(list.getSelectionModel().getSelectedIndex(), textfield1.getText());
    }
}
