package com.example.ot4b;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public abstract class Animal extends Canvas {

    private final Timeline animacia;
    protected final GraphicsContext gc;
    private double poloha;
    private int smer = 1;
    private static final double X_MIN = 10;
    private static final double Y_MIN = 10;
    private static final double X_MAX = 540;
    private static final double Y_MAX = 320;
    private static final double RYCHLOST = 2;

    public Animal(double startPoloha) {
        super(40, 40);
        gc = getGraphicsContext2D();
        poloha = startPoloha;
        vykresli();
        animacia = new Timeline(
                new KeyFrame(Duration.millis(30), e -> pohyb())
        );
        animacia.setCycleCount(Animation.INDEFINITE);
        animacia.play();
    }

    protected abstract void vykresli();

    private void pohyb() {
        double sirka = X_MAX - X_MIN;
        double vyska = Y_MAX - Y_MIN;
        double obvod = 2 * (sirka + vyska);

        poloha += smer * RYCHLOST;
        if (poloha >= obvod) {
            poloha -= obvod;
        } else if (poloha < 0) {
            poloha += obvod;
        }

        double x;
        double y;

        if (poloha < sirka) {
            x =X_MIN + poloha;
            y = Y_MIN;
        } else if (poloha < sirka + vyska) {
            x =X_MAX;
            y = Y_MIN + poloha - sirka;
        } else if (poloha < 2 * sirka + vyska) {
            x =X_MAX - (poloha - sirka - vyska);
            y = Y_MAX;
        } else {
            x =X_MIN;
            y = Y_MAX - (poloha - 2 * sirka - vyska);
        }
        setLayoutX(x);
        setLayoutY(y);
    }

    public void zmenSmer() {
        smer *= -1;
    }
    public void nastavPohyb(boolean spustit) {
        if (spustit) {
            animacia.play();
        } else {
            animacia.pause();
        }
    }
}