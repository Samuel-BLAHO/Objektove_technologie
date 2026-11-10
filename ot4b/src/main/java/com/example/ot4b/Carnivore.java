package com.example.ot4b;

import javafx.scene.paint.Color;

public class Carnivore extends Animal {

    public Carnivore(double startPoloha) {
        super(startPoloha);
    }

    @Override
    protected void vykresli() {
        gc.setFill(Color.RED);
        gc.fillRect(5, 5, 30, 30);
    }
}