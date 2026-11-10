package com.example.ot_opakovanie2;

public class Uloha {
    private String nazov;
    private Priorita priorita;
    private Stav stav;

    public enum Priorita{
        NIZKA,STREDNA,VYSOKA
    }
    public enum Stav{
        HOTOVA,ROZPRACOVANA
    }

    public Uloha(String nazov,Priorita priorita,Stav stav){
        this.nazov=nazov;
        this.priorita=priorita;
        this.stav=stav;
    }

    public String  getNazov(){
        return nazov;
    }
    public void setNazov(String nazov){
        this.nazov= nazov;
    }
    public Stav  getStav(){
        return stav;
    }
    public void setStav(Stav stav){
        this.stav= stav;
    }
    public Priorita  getPriorita(){
        return priorita;
    }
    public void setPriorita(Priorita priorita){
        this.priorita= priorita;
    }

    public String toString(){
        return nazov+" priorita: "+priorita+", stav: "+stav;
    }
}
