package com.diarchila.guessthecountry.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class InstruccionesController {

    @FXML
    private Label lblTitle;  // Título fijo en FXML

    @FXML
    private TextArea txtInstructions;

    @FXML
    private Button btnVolver;

    @FXML
    public void initialize() {
        loadInstructionsContentFromJson();
    }

    private void loadInstructionsContentFromJson() {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = getClass().getResourceAsStream("/data/Instructions.json")) {
            if (is == null) {
                txtInstructions.setText("No se encontró el archivo de instrucciones.");
                return;
            }
            JsonNode root = mapper.readTree(is);
            JsonNode contentArray = root.path("content");

            StringBuilder sb = new StringBuilder();
            for (JsonNode line : contentArray) {
                sb.append("• ").append(line.asText()).append("\n\n");
            }

            txtInstructions.setText(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
            txtInstructions.setText("Error al cargar las instrucciones.");
        }
    }

    @FXML
    public void volverAtras(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
