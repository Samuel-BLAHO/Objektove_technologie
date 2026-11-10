module com.example.ot6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ot6 to javafx.fxml;
    exports com.example.ot6;
}