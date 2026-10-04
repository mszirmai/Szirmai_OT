module com.example.ot_s2zadanie2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ot_s2zadanie2 to javafx.fxml;
    exports com.example.ot_s2zadanie2;
}