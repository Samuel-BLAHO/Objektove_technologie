package com.example.ot_opakovanie1;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class Mucha extends Hmyz {
    public Mucha(Pane root){
        super(root);
        setOnMousePressed(e->zanikne());
    }

    public void zanikne(){
        t.stop();
        root.getChildren().remove(this);
    }

    public void pohyb(){
        setLayoutX(getLayoutX()+(int)(Math.random()*5)-2);
        setLayoutY(getLayoutY()+(int)(Math.random()*5)-2);
    }
    public void vykresli(){
        gc.setFill(Color.RED);
        gc.fillOval(0,0,getWidth(),getHeight());
    }
}
