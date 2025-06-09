package com.diarchila.guessthecountry.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

public class InstructionsController {

    private static final Logger logger = Logger.getLogger(InstructionsController.class.getName());

    @FXML
    private Button backButton;

    @FXML
    private TextArea txtInstrucciones;

    @FXML
    public void initialize() {

        backButton.setOnAction(this::goBack);

        String INSTRUCTIONS_FILE = "/data/Instructions.json";
        try (InputStream is = getClass().getResourceAsStream(INSTRUCTIONS_FILE)) {
            if (is == null) {
                txtInstrucciones.setText("No se pudo cargar las instrucciones. El archivo no fue encontrado.");
                return;
            }
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(is);
            String instrucciones = root.path("instrucciones").asText();
            txtInstrucciones.setText(instrucciones);
        } catch (IOException e) {
            logger.severe("Error al cargar las instrucciones: " + e.getMessage());
            txtInstrucciones.setText("Hubo un error al cargar las instrucciones.");
        }
    }

    @FXML
    public void goBack(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
