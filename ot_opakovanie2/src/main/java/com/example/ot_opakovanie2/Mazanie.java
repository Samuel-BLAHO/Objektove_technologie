package com.example.ot_opakovanie2;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;

public class Mazanie implements Runnable {
    private TextArea vypisArea;
    private ObservableList<Uloha> ulohy;

    public Mazanie(ObservableList<Uloha> ulohy, TextArea vypisArea){
        this.ulohy=ulohy;
        this.vypisArea=vypisArea;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10000);

                Platform.runLater(() -> {
                    long pocet = ulohy.stream()
                            .filter(uloha -> uloha.getStav() == Uloha.Stav.HOTOVA)
                            .count();

                    ulohy.removeIf(uloha ->
                            uloha.getStav() == Uloha.Stav.HOTOVA);

                    if (pocet > 0) {
                        vypisArea.appendText(
                                "Počet odstránených úloh: " + pocet + "\n"
                        );
                    }
                });

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
