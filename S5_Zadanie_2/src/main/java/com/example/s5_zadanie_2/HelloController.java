package com.example.s5_zadanie_2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class HelloController {
    @FXML BorderPane root;
    @FXML private ListView<Item> list;
    @FXML private TextField textfield1;
    @FXML private Label label1;
    private int item_amount = 0;

    private ObservableList<Item> zoznam = FXCollections.observableArrayList();

    @FXML private void initialize(){
        list.setItems(zoznam);
    }

    @FXML protected void add(){
        if(!textfield1.getText().isEmpty()) {
            Item item = new Item(textfield1.getText());
            zoznam.add(item);
            item_amount++;
            label1.setText("Items: "+item_amount);
        }
        textfield1.clear();
        textfield1.requestFocus();

    }

    @FXML protected void remove(){
        if(list.getSelectionModel().getSelectedItem()!=null){
            zoznam.remove(list.getSelectionModel().getSelectedIndex());
            item_amount--;
            label1.setText("Items: "+item_amount);
        }
    }

    @FXML protected void update(){
        Item selecteditem = list.getSelectionModel().getSelectedItem();

        if(selecteditem != null){
            selecteditem.setName(textfield1.getText());
            list.refresh();
        }
        textfield1.clear();
        textfield1.requestFocus();
    }

}
