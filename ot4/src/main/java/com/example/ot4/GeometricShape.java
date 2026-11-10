
package com.example.ot4;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public abstract class GeometricShape extends Canvas {

    protected GraphicsContext gc;
    protected Color farba;
    protected int rychlost;

    private Timeline t;

    public GeometricShape(int x, int y, int r, Color f) {
        super(40, 40);
        rychlost= r;
        farba = f;
        setLayoutX(x);
        setLayoutY(y);
        gc = getGraphicsContext2D();
        vykresli();
        t = new Timeline(
                new KeyFrame(Duration.millis(100), e -> posun())
        );
        t.setCycleCount(Animation.INDEFINITE);
        t.play();
    }

    protected abstract void vykresli();

    protected abstract void posun();

    public void zmenFarbu(Color novaFarba) {
        farba = novaFarba;
        vykresli();
    }

    public void posunDole() {
        setLayoutY(getLayoutY() + 30);
    }
}
