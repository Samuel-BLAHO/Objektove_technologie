module com.example.ot1_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ot1_2 to javafx.fxml;
    exports com.example.ot1_2;
}