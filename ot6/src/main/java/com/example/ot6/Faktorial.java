package com.example.ot6;

import javafx.application.Platform;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;


public class Faktorial implements  Runnable{
    private int n;
    private TextArea faktorial_area;
    private ProgressBar faktorial_progres;


    public Faktorial(int n,TextArea faktorial_area, ProgressBar faktorial_progres){
        this.n = n;
        this.faktorial_area = faktorial_area;
        this.faktorial_progres = faktorial_progres;
    }

    public void run(){
        int i = 1;
        int sum = 1;
        while (i<=n){
            try {
                sum=sum*i;
                int pom_sum= sum;
                int pom =i;
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        faktorial_area.appendText(Integer.toString(pom_sum)+"\n");
                        faktorial_progres.setProgress((pom)/(double)n);
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
