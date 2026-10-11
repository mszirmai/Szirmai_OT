module com.example.s3_zadanie1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.s3_zadanie1 to javafx.fxml;
    exports com.example.s3_zadanie1;
}