
package com.example.ot4;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HelloController {

    @FXML
    private Pane plocha;

    private final List<GeometricShape> tvary = new ArrayList<>();
    private final Random random = new Random();

    @FXML
    protected void pridajObdlznik() {
        pridajTvar(new MyRectangle(nahodnaX(), nahodnaY()));
    }

    @FXML
    protected void pridajKruh() {
        pridajTvar(new MyCircle(nahodnaX(), nahodnaY()));
    }

    @FXML
    protected void pridajStvorec() {
        pridajTvar(new MySquare(nahodnaX(), nahodnaY()));
    }
    private void pridajTvar(GeometricShape tvar) {
        tvary.add(tvar);
        plocha.getChildren().add(tvar);
    }

    private int nahodnaX() {
        return random.nextInt(
                Math.max(1, (int) plocha.getWidth() - 40)
        );
    }

    private int nahodnaY() {
        return random.nextInt(
                Math.max(1, (int) plocha.getHeight() - 40)
        );
    }

    @FXML
    protected void zmenKruhyNaModru() {
        for (GeometricShape tvar : tvary) {
            if (tvar instanceof MyCircle) {
                tvar.zmenFarbu(Color.BLUE);
            }
        }
    }
    @FXML
    protected void posunVsetkyDole() {
        for (GeometricShape tvar : tvary) {
            tvar.posunDole();
        }
    }
}
