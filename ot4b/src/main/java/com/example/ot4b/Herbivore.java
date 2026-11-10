package com.example.ot4b;

import javafx.scene.paint.Color;

public class Herbivore extends Animal {

    public Herbivore(double startPoloha) {
        super(startPoloha);
    }

    @Override
    protected void vykresli() {
        gc.setFill(Color.GREEN);
        gc.fillOval(5, 5, 30, 30);
    }
}