package com.example.ot6;

import javafx.application.Platform;
import javafx.scene.control.ProgressBar;

import javafx.scene.control.TextArea;

public class Mocnina implements Runnable{
    private int n;
    private TextArea mocnina_area;
    private ProgressBar mocnina_progres;

    public Mocnina(int n, TextArea mocnina_area, ProgressBar mocnina_progres){
        this.n = n;
        this.mocnina_area = mocnina_area;
        this.mocnina_progres= mocnina_progres;

    }

    @Override
    public void run() {
        int i=1;
        int vysledok = 1;
        while (i<=n){
            try {
                vysledok=vysledok*n;
                int pom_i= i;
                int pom_vysledok=vysledok;
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        mocnina_area.appendText(Integer.toString(pom_vysledok)+"\n");
                        mocnina_progres.setProgress((pom_i)/(double)n);
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
