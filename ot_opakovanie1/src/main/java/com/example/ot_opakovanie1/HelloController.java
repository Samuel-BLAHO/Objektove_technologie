package com.example.ot_opakovanie1;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

public class HelloController {
    @FXML private Pane root;
    private KeyEvent e;
    @FXML public void initialize(){
        root.setOnKeyPressed(this::spracuj);
        root.setFocusTraversable(true);
    }

    @FXML public void Chrobak(){
        Chrobak ch = new Chrobak(root);
        root.getChildren().add(ch);
    }

    @FXML public void Mucha(){
        Mucha mucha = new Mucha(root);
        root.getChildren().add(mucha);
    }

    @FXML public void spracuj(KeyEvent e){
        KeyCode code = e.getCode();
        switch (code){
            case W: posunObjekt();
                    break;
            case S: zastavMuchy();
                    break;
        }
    }

    @FXML public void posunObjekt(){
        for(int i=0;i<root.getChildren().size();i++) {
            Node n = root.getChildren().get(i);
            if (n instanceof Hmyz)((Hmyz) n).posun();
        }
    }

    @FXML public void zastavMuchy(){
        for(int i=0;i<root.getChildren().size();i++) {
            Node n = root.getChildren().get(i);
            if (n instanceof Hmyz)((Hmyz) n).zastav();
        }
    }
}