package com.example.s6_zadanie_1;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private TextField textfield1;
    @FXML private TextArea textarea_fac, textarea_pow, textarea_fib;
    @FXML private ProgressBar progressbar_fac, progressbar_pow, progressbar_fib;

    @FXML private void initialize(){
        progressbar_fac.setProgress(0.0);
        progressbar_pow.setProgress(0.0);
        progressbar_fib.setProgress(0.0);
    }

    public void runAll(){
        Runnable run_fac = new Runnable(){
          public void run(){
              int sum = 1;
              for(int i=1; i<=Integer.parseInt(textfield1.getText()); i++){
                  try {
                      sum = sum * i;
                      final int fsum = sum;
                      int pom = i;
                      Platform.runLater(new Runnable() {
                          @Override
                          public void run() {
                              textarea_fac.appendText(Integer.toString(fsum)+"\n");
                              progressbar_fac.setProgress((double)pom/(double)Integer.parseInt(textfield1.getText()));
                          }
                      });
                      Thread.sleep(200);
                  } catch (InterruptedException e){
                      System.out.println(e.getMessage());
                  }

              }
          }
        };

        Runnable run_pow = new Runnable(){
            public void run(){
                int result = Integer.parseInt(textfield1.getText());
                int og_result = result;
                for(int i=1; i<=Integer.parseInt(textfield1.getText()); i++){
                    try {
                        result = (int) Math.pow(og_result, i);
                        final int fsum = result;
                        int pom = i;
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                textarea_pow.appendText(Integer.toString(fsum)+"\n");
                                progressbar_pow.setProgress((double)pom/(double)Integer.parseInt(textfield1.getText()));
                            }
                        });
                        Thread.sleep(200);
                    } catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }

                }
            }
        };

        Runnable run_fib = new Runnable(){
            public void run(){
                int a = 0;
                int b = 1;

                for(int i=1; i<=Integer.parseInt(textfield1.getText()); i++){
                    try{
                        int c;
                        if(i>2) {
                            c = a + b;
                            a = b;
                            b = c;
                        } else {
                            c = a + b;
                        }
                        int pom = i;

                        Platform.runLater(new Runnable(){
                            @Override
                            public void run(){
                                if(pom==1){
                                    textarea_fib.appendText("0\n");
                                }
                                else if(pom==2){
                                    textarea_fib.appendText("1\n");
                                }
                                else{
                                textarea_fib.appendText(Integer.toString(c)+"\n");
                                }
                                progressbar_fib.setProgress((double)pom/(double)Integer.parseInt(textfield1.getText()));
                            }
                        });

                        Thread.sleep(200);
                    } catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        };

        Thread thread_fac = new Thread(run_fac);
        thread_fac.start();
        Thread thread_pow = new Thread(run_pow);
        thread_pow.start();
        Thread thread_fib = new Thread(run_fib);
        thread_fib.start();
    }


}
