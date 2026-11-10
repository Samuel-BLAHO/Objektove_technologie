module com.example.ot_opakovanie2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ot_opakovanie2 to javafx.fxml;
    exports com.example.ot_opakovanie2;
}