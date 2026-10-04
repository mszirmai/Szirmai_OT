package com.example.ot_s2zadanie2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML private TextField textfield1;
    @FXML private Label label1, label2, label3, label4;
    private double a;

    @FXML protected void mmbutton(){
        a=Double.parseDouble(textfield1.getText());
        label1.setText(a*0.1+" cm");
        label2.setText(a*0.01+" dm");
        label3.setText(a*0.001+" m");
        label4.setText(a*0.000001+" km");
    }

    @FXML protected void cmbutton(){
        a=Double.parseDouble(textfield1.getText());
        label1.setText(a*10+" mm");
        label2.setText(a*0.1+" dm");
        label3.setText(a*0.01+" m");
        label4.setText(a*0.00001+" km");
    }

    @FXML protected void dmbutton(){
        a=Double.parseDouble(textfield1.getText());
        label1.setText(a*100+" mm");
        label2.setText(a*1+" cm");
        label3.setText(a*0.1+" m");
        label4.setText(a*0.0001+" km");
    }

    @FXML protected void mbutton(){
        a=Double.parseDouble(textfield1.getText());
        label1.setText(a*1000+" mm");
        label2.setText(a*10+" cm");
        label3.setText(a*1+" dm");
        label4.setText(a*0.001+" km");
    }

    @FXML protected void kmbutton(){
        a=Double.parseDouble(textfield1.getText());
        label1.setText(a*1000000+" mm");
        label2.setText(a*100000+" cm");
        label3.setText(a*10000+" dm");
        label4.setText(a*1000+" m");
    }
}
