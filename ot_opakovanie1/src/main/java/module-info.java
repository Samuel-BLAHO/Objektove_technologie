module com.example.ot_opakovanie1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ot_opakovanie1 to javafx.fxml;
    exports com.example.ot_opakovanie1;
}