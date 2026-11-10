module com.example.ot4b {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ot4b to javafx.fxml;
    exports com.example.ot4b;
}