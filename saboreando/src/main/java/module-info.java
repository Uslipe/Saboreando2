module com.saboreando {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.saboreando to javafx.fxml;
    exports com.saboreando;
}
