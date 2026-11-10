package com.example.ot_opakovanie2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private TextField tField;
    @FXML private ComboBox<Uloha.Stav>  vyberStav;
    @FXML private ComboBox<Uloha.Priorita> vyberPriorita;
    private  Uloha vybranaUloha;
    @FXML
    private ListView<Uloha> zoznamUloh;
    private ObservableList<Uloha> ulohy= FXCollections.observableArrayList();
    @FXML private TextArea vypisArea;

    @FXML
    public void  initialize(){
        zoznamUloh.setItems(ulohy);
        vyberPriorita.setItems(
                FXCollections.observableArrayList(Uloha.Priorita.values())
        );
        vyberStav.setItems(
                FXCollections.observableArrayList(Uloha.Stav.values())
        );
        zoznamUloh.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue!= null){
                        tField.setText(newValue.getNazov());
                        vyberPriorita.setValue(newValue.getPriorita());
                        vyberStav.setValue(newValue.getStav());
                        vybranaUloha= newValue;
                    }
                }
        );
        Statistika statistika = new Statistika(ulohy, vypisArea);
        Thread statthread = new Thread(statistika);
        statthread.setDaemon(true);
        statthread.start();
        Mazanie mazanie = new Mazanie(ulohy, vypisArea);
        Thread mazthread = new Thread(mazanie);
        mazthread.setDaemon(true);
        mazthread.start();
        zoznamUloh.refresh();
    }

    @FXML
    public void pridajUlohu(){
        if (tField.getText().isBlank() || vyberStav.getValue()==null || vyberStav.getValue()==null) return;
        Uloha uloha = new Uloha(tField.getText(),vyberPriorita.getValue(), vyberStav.getValue());
        ulohy.add(uloha);
    }

    @FXML
    public void upravUlohu(){
        if (vybranaUloha==null) return;
        vybranaUloha.setNazov(tField.getText());
        vybranaUloha.setPriorita(vyberPriorita.getValue());
        vybranaUloha.setStav(vyberStav.getValue());
        zoznamUloh.refresh();
    }
    @FXML
    public void odstranUlohu(){
        if (vybranaUloha==null) return;
        ulohy.remove(vybranaUloha);
        vybranaUloha= null;
        tField.clear();
        vyberPriorita.setValue(null);
        vyberStav.setValue(null);
    }

}
