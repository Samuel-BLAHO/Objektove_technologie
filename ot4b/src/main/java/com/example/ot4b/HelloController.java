package com.example.ot4b;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HelloController {

    @FXML
    private Pane plocha;

    private final List<Animal> zvierata = new ArrayList<>();
    private final Random random = new Random();
    private boolean pohybZastaveny = false;
    private double nahodnaPoloha() {
        return random.nextDouble() * 1680;
    }

    @FXML
    private void pridajBylinozravca() {
        Herbivore zviera = new Herbivore(nahodnaPoloha());
        pridajZviera(zviera);
    }

    @FXML
    private void pridajMasozravca() {
        Carnivore zviera = new Carnivore(nahodnaPoloha());
        pridajZviera(zviera);
    }

    private void pridajZviera(Animal zviera) {
        zvierata.add(zviera);
        plocha.getChildren().add(zviera);

        if (pohybZastaveny) {
            zviera.nastavPohyb(false);
        }
    }

    @FXML
    private void zmenSmerMasozravcov() {
        for (Animal zviera : zvierata) {
            if (zviera instanceof Carnivore) {
                zviera.zmenSmer();
            }
        }
    }

    @FXML
    private void zastavAleboSpusti() {
        pohybZastaveny = !pohybZastaveny;
        for (Animal zviera : zvierata) {
            zviera.nastavPohyb(!pohybZastaveny);
        }
    }
}
