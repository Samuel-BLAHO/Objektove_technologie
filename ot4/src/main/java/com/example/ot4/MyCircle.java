package com.example.ot4;

import javafx.scene.paint.Color;

public class MyCircle extends GeometricShape {
    private double uhol = 0;
    private final double stredX;
    private final double stredY;

    public MyCircle(int x, int y) {
        super(x, y, 2, Color.RED);
        stredX = x;
        stredY = y;
    }
    @Override
    protected void vykresli() {
        gc.clearRect(0,0, getWidth(), getHeight());
        gc.setFill(farba);
        gc.fillOval(5, 5,30,30);
    }

    @Override
    protected void posun() {
        uhol += 0.05;
        setLayoutX(stredX + 50 * Math.cos(uhol));
        setLayoutY(stredY + 50 * Math.sin(uhol));
    }
}
