package com.example.ot6;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.application.Platform;

public class HelloController {

    @FXML protected TextField tfield;
    @FXML private BorderPane root;
    @FXML protected TextArea faktorial_area, mocnina_area,fibonachi_area;
    @FXML protected ProgressBar faktorial_progres, mocnina_progres,fibonachi_progres;
    private boolean prebiehaVypocet = false;

    @FXML public void spusti(){
        int n;
        try {
            n = Integer.parseInt(tfield.getText());
            if (n<=0){
                System.out.println("Zadaj kladne cislo");
                return;
            }
        }catch (NumberFormatException e){
            System.out.println("Zadaj platne cele cislo!");
            return;
        }
        if (!prebiehaVypocet){
            prebiehaVypocet=!prebiehaVypocet;

            faktorial_area.clear();
            Faktorial faktorial = new Faktorial(n, faktorial_area, faktorial_progres);
            Thread threadFaktorial = new Thread(faktorial);
            threadFaktorial.start();

            mocnina_area.clear();
            Mocnina mocnina = new Mocnina(n, mocnina_area, mocnina_progres);
            Thread threadMocnina = new Thread(mocnina);
            threadMocnina.start();

            fibonachi_area.clear();
            Fibonachi fibonachi = new Fibonachi(n,fibonachi_area,fibonachi_progres);
            Thread threadFibonachi = new Thread(fibonachi);
            threadFibonachi.start();

            Thread pomocne = new Thread(() ->{
                try {
                    threadFaktorial.join();
                    threadFibonachi.join();
                    threadMocnina.join();
                    Platform.runLater(() -> {
                        prebiehaVypocet = false;
                    });
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            });
            pomocne.start();
        }

    }



}
