module com.diarchila.guessthecountry {
    requires javafx.controls;
    requires javafx.fxml;

    requires javafx.graphics;
    requires javafx.base;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires java.logging;

    opens com.diarchila.guessthecountry to javafx.fxml;
    opens com.diarchila.guessthecountry.controllers to javafx.fxml;

    opens com.diarchila.guessthecountry.models to com.fasterxml.jackson.databind;
    opens com.diarchila.guessthecountry.services to com.fasterxml.jackson.databind;
    
    exports com.diarchila.guessthecountry;
    exports com.diarchila.guessthecountry.controllers;
    exports com.diarchila.guessthecountry.models;
    exports com.diarchila.guessthecountry.services;
    
}