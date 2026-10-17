module com.example.s4_zadanie1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.s4_zadanie1 to javafx.fxml;
    exports com.example.s4_zadanie1;
}