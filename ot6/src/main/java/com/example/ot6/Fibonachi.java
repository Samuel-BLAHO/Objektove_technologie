package com.example.ot6;

import javafx.application.Platform;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;

public class Fibonachi implements Runnable{
    private int n;
    private TextArea fibonachi_area;
    private ProgressBar fibonachi_progres;

    public Fibonachi(int n, TextArea fibonachi_area, ProgressBar fibonachi_progres){
        this.n = n;
        this.fibonachi_area = fibonachi_area;
        this.fibonachi_progres= fibonachi_progres;
    }

    @Override
    public void run() {
        int i=3;
        long a=0;
        long b= 1;
        long dalsie;
        if (n>0){
            try {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        fibonachi_area.appendText("0\n");
                        fibonachi_progres.setProgress(1/(double)n);
                    }
                });
                Thread.sleep(500);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }


        }
        if (n>1){
            try {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        fibonachi_area.appendText("1\n");
                        fibonachi_progres.setProgress(2/(double)n);
                    }
                });
                Thread.sleep(500);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }

        }
        if (n>2){
            while (i<=n){
                try {
                    dalsie=a+b;
                    a=b;
                    b=dalsie;
                    long pom_dalsie= dalsie;
                    int pom_i = i;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            fibonachi_area.appendText(Long.toString(pom_dalsie)+"\n");
                            fibonachi_progres.setProgress(pom_i/(double)n);
                        }
                    });
                    i++;
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }

            }
        }
    }


}

