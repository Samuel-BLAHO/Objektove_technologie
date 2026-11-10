
package com.example.ot4;

import javafx.scene.paint.Color;

public class MyRectangle extends GeometricShape {
    private int smer = 1;
    public MyRectangle(int x, int y) {
        super(x, y, 3, Color.RED);
    }
    @Override
    protected void vykresli() {
        gc.clearRect(0, 0, getWidth(), getHeight());
        gc.setFill(farba);
        gc.fillRect(0, 5, 40, 20);
    }
    @Override
    protected void posun() {
        setLayoutX(getLayoutX() + rychlost * smer);
        if (getLayoutX() > 550 || getLayoutX() < 0) {
            smer *= -1;
        }
    }
}
