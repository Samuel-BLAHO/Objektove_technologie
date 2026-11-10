package com.example.ot_opakovanie3;

import java.time.LocalDate;

public class Spracovanie {
    private String nazovText;
    private String cisloText;
    private LocalDate platnostDatum;
    private boolean platnostBox;


    public Spracovanie(String nazovText, String cisloText,
                       LocalDate platnostDatum, boolean platnostBox) {
        this.nazovText = nazovText;
        this.cisloText = cisloText;
        this.platnostDatum = platnostDatum;
        this.platnostBox = platnostBox;
    }


    public String getNazovText() {
        return nazovText;
    }

    public void setNazovText(String nazovText) {
        this.nazovText = nazovText;
    }

    public String getCisloText() {
        return cisloText;
    }

    public void setCisloText(String cisloText) {
        this.cisloText = cisloText;
    }
    public LocalDate getPlatnostDatum() {
        return platnostDatum;
    }

    public void setPlatnostDatum(LocalDate platnostDatum) {
        this.platnostDatum = platnostDatum;
    }

    public boolean isPlatnostBox() {
        return platnostBox;
    }

    public void setPlatnostBox(boolean platnostBox) {
        this.platnostBox = platnostBox;
    }
    public String toString(){
            return cisloText+"-"+nazovText;


    }

    public String vypis(boolean zobrazDatum) {
        if (zobrazDatum) {
            return cisloText + " - " + nazovText
                    + "\nKoniec záruky: " + platnostDatum;
        }
        return cisloText + " - " + nazovText;
    }
}
