package com.example.ot_opakovanie1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.util.Duration;



public class Hmyz extends Canvas {
    protected GraphicsContext gc;
    protected Timeline t;
    @FXML protected Pane root;

    public Hmyz(Pane root) {
        super(15, 15);
        this.root = root;
        setLayoutX(Math.random()*root.getWidth());
        setLayoutY(Math.random()*root.getHeight());
        gc = getGraphicsContext2D();
        t = new Timeline(new KeyFrame(Duration.millis(150),e->pohyb()));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
        vykresli();
    }

    public void posun(){
        setLayoutY(getLayoutY()-50);
    }

    public void zastav(){
        t.stop();
    }

    public void pohyb(){}

    public void vykresli(){}
}