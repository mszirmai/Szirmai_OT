module com.example.s6_zadanie_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.s6_zadanie_1 to javafx.fxml;
    exports com.example.s6_zadanie_1;
}