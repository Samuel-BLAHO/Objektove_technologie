package com.example.ot_opakovanie2;

import javafx.application.Platform;
import javafx.collections.ObservableList;

import javafx.scene.control.TextArea;

public class Statistika implements Runnable{
    private TextArea vypisArea;
    private ObservableList<Uloha> ulohy;

    public Statistika(ObservableList<Uloha> ulohy, TextArea vypisArea){
        this.ulohy=ulohy;
        this.vypisArea=vypisArea;

    }

    @Override
    public void run() {
        while (true){
            int pocet=0;
            for(Uloha uloha:ulohy){
                if (uloha.getStav()== Uloha.Stav.ROZPRACOVANA){
                    pocet++;
                }
            }
            int pomPocet=pocet;
            Platform.runLater(() ->{
                vypisArea.appendText("Počet rozpracovaných úloh: " + pomPocet + "\n");
            });
            try {
                Thread.sleep(3000);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
