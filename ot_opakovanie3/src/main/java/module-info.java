module com.example.ot_opakovanie3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ot_opakovanie3 to javafx.fxml;
    exports com.example.ot_opakovanie3;
}