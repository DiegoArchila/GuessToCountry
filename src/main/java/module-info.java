module com.diarchila.guessthecountry {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.diarchila.guessthecountry to javafx.fxml;
    opens com.diarchila.guessthecountry.controllers to javafx.fxml;
    
    exports com.diarchila.guessthecountry;
    exports com.diarchila.guessthecountry.controllers;
}