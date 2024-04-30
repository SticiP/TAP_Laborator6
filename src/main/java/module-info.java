module org.example.tap_laborator6 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.tap_laborator6 to javafx.fxml;
    exports org.example.tap_laborator6;
}