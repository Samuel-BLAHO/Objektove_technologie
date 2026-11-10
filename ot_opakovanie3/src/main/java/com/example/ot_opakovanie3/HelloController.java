package com.example.ot_opakovanie3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class HelloController {
    @FXML private ListView<Spracovanie> hardwerList;
    @FXML private TextField nazovText;
    @FXML private TextField cisloText;
    @FXML private TextField cenaText;
    @FXML private DatePicker platnostDatum;
    @FXML private CheckBox platnostBox;
    @FXML private Spracovanie vybranyHardware;
    private ObservableList<Spracovanie> hardweri = FXCollections.observableArrayList();

    @FXML
    public void initialize(){
        hardwerList.setItems(hardweri);
        hardwerList.getSelectionModel().selectedItemProperty().addListener((observable,stara,nova)  -> {
                if (nova!=null){
                    nazovText.setText(nova.getNazovText());
                    cisloText.setText(nova.getCisloText());
                    platnostDatum.setValue(nova.getPlatnostDatum());
                    vybranyHardware=nova;

                }
            }
        );
        platnostBox.setOnAction(event -> hardwerList.refresh());
        platnostBox.setOnAction(e -> {
            hardwerList.getItems().clear();

            for (Spracovanie h : hardweri) {
                hardwerList.getItems().add(h);
            }
        });
        platnostBox.setOnAction(event -> hardwerList.refresh());


    }


    @FXML
    public void pridaj(){
        if (nazovText.getText().isEmpty()|| cisloText.getText().isEmpty()|| platnostDatum.getValue() ==null){
            System.out.println("zadaj vsetky udaje");
        }else{
            Spracovanie spracovanie = new Spracovanie(
                    nazovText.getText(),
                    cisloText.getText(),
                    platnostDatum.getValue(),
                    platnostBox.isSelected()
            );
            hardweri.add(spracovanie);
        }
    }
    @FXML
    public void uprav(){
        if (vybranyHardware == null) {return;}
        vybranyHardware.setNazovText(nazovText.getText());
        vybranyHardware.setCisloText(cisloText.getText());
        vybranyHardware.setPlatnostDatum(platnostDatum.getValue());
        vybranyHardware.setPlatnostBox(platnostBox.isSelected());
        hardwerList.refresh();

    }
    @FXML
    public void odstran() {
        if (vybranyHardware == null) {
            return;
        }

        hardweri.remove(vybranyHardware);
        vybranyHardware = null;

        nazovText.clear();
        cisloText.clear();
        cenaText.clear();
        platnostDatum.setValue(null);
        platnostBox.setSelected(false);
    }

}
