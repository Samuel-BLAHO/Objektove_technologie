
package com.example.ot4;

import javafx.scene.paint.Color;

public class MySquare extends GeometricShape {
    private int smer = 1;

    public MySquare(int x, int y) {
        super(x, y, 2, Color.GREEN);
    }

    @Override
    protected void vykresli() {
        gc.clearRect(0, 0, getWidth(), getHeight());
        gc.setFill(farba);
        gc.fillRect(5, 5, 30,30);
    }
    @Override
    protected void posun() {
        setLayoutY(getLayoutY() + rychlost * smer);
        if (getLayoutY()>350 || getLayoutY() < 0) {
            smer*= -1;
        }
    }
}
