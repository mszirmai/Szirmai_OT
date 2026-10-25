module com.example.s5_zadanie_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.s5_zadanie_2 to javafx.fxml;
    exports com.example.s5_zadanie_2;
}