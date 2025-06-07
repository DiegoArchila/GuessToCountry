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

public class InstruccionesController {

    @FXML
    private Button btnVolver;

    @FXML
    private TextArea txtInstrucciones;

    // Archivo JSON con las instrucciones
    private final String INSTRUCTIONS_FILE = "/data/instructions.json";

    @FXML
    public void initialize() {
        cargarInstrucciones();
    }

    @FXML
    public void volverAtras(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    private void cargarInstrucciones() {
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
            e.printStackTrace();
            txtInstrucciones.setText("Hubo un error al cargar las instrucciones.");
        }
    }
}
