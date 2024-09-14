module com.saboreando {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.saboreando to javafx.fxml;
    exports com.saboreando;
}
