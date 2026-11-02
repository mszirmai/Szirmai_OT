package com.example.s6_zadanie_2;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML Label label1;
    @FXML TextField textfield_sum, textfield_start;
    @FXML TextArea area;
    @FXML ComboBox<String> combobox1 = new ComboBox<>();
    Client c;
    Account a;
    static double balance = 0;
    static int id = 0;

    @FXML private void initialize(){
        combobox1.getItems().addAll("Deposit","Withdraw");
        combobox1.setValue("Deposit");
    }

    @FXML public void createAccount(){
        a = new Account(Double.parseDouble(textfield_start.getText()));
        label1.setText(a.getBalance()+" €");
        area.clear();
    }

    @FXML public void runOne(){
        Runnable run1 = new Runnable(){
            public void run() {
                try {
                    if (combobox1.getValue().equals("Deposit")) {
                        Client c = new Client(a);
                        a.setBalance(a.getBalance() + Double.parseDouble(textfield_sum.getText()));

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                label1.setText(a.getBalance() + " €");
                                area.appendText(c + " deposited " + textfield_sum.getText() + " €.\n");
                            }
                        });
                        Thread.sleep(100);
                    } else {
                        Client c = new Client(a);
                        a.setBalance(a.getBalance() - Double.parseDouble(textfield_sum.getText()));

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                label1.setText(a.getBalance() + " €");
                                area.appendText(c + " withdrew " + textfield_sum.getText() + " €.\n");
                            }
                        });
                    }
                } catch(InterruptedException e){
                    System.out.println(e.getMessage());
                }
            }
        };
        Thread thread = new Thread(run1);
        thread.start();

    }

    @FXML public void runFive(){
        Runnable run1 = new Runnable(){
            public void run() {
                try {
                    if (combobox1.getValue().equals("Deposit")) {
                        Client c = new Client(a);
                        a.setBalance(a.getBalance() + Double.parseDouble(textfield_sum.getText()));

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                label1.setText(a.getBalance() + " €");
                                area.appendText(c + " deposited " + textfield_sum.getText() + " €.\n");
                            }
                        });
                        Thread.sleep(100);
                    } else {
                        Client c = new Client(a);
                        a.setBalance(a.getBalance() - Double.parseDouble(textfield_sum.getText()));

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                label1.setText(a.getBalance() + " €");
                                area.appendText(c + " withdrew " + textfield_sum.getText() + " €.\n");
                            }
                        });
                    }
                } catch(InterruptedException e){
                    System.out.println(e.getMessage());
                }
            }
        };
        Thread thread = new Thread(run1);
        thread.start();
        Thread thread1 = new Thread(run1);
        thread1.start();
        Thread thread2 = new Thread(run1);
        thread2.start();
        Thread thread3 = new Thread(run1);
        thread3.start();
        Thread thread4 = new Thread(run1);
        thread4.start();
    }
}
