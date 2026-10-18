module com.example.s4_zadanie_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.s4_zadanie_2 to javafx.fxml;
    exports com.example.s4_zadanie_2;
}