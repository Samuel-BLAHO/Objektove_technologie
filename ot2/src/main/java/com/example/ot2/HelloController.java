package com.example.ot2;

import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;

public class HelloController {

    @FXML private Rectangle autoRect;
    private Auto auto;
    @FXML
    public void initialize() {
        if (autoRect != null) {
            auto = new Auto(autoRect);
        }
    }
    @FXML
    protected void Automatic() {
        if (auto != null) {
            auto.setAutomaticMode();
        }
    }
    @FXML
    protected void Manual() {
        if (auto != null) {
            auto.setManualMode();
        }
    }
}