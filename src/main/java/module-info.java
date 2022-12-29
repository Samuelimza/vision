module com.simul.vision {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.simul.vision to javafx.fxml;
    exports com.simul.vision;
}