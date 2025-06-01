module com.diarchila.guessthecountry {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.annotation;

    opens com.diarchila.guessthecountry to javafx.fxml;
    opens com.diarchila.guessthecountry.controllers to javafx.fxml;

    opens com.diarchila.guessthecountry.models to com.fasterxml.jackson.databind;
    opens com.diarchila.guessthecountry.services to com.fasterxml.jackson.databind;
    
    exports com.diarchila.guessthecountry;
    exports com.diarchila.guessthecountry.controllers;
    exports com.diarchila.guessthecountry.models;
    exports com.diarchila.guessthecountry.services;
    
}