module com.example.s4_zadanie_12 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.s4_zadanie_12 to javafx.fxml;
    exports com.example.s4_zadanie_12;
}