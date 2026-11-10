module com.example.ot4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;


    opens com.example.ot4 to javafx.fxml;
    exports com.example.ot4;
}