package com.diarchila.guessthecountry.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.logging.Logger;

public class GameMenuController {

    private static final Logger logger = Logger.getLogger(GameMenuController.class.getName());

    @FXML
    private void initialize() {
        // Inicializaciones si son necesarias
        logger.info("GameMenuController initialized");
    }

    @FXML
    private void handleStartBtn(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Game.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 600);

        stage.setScene(scene);

    }

    @FXML
    private void handleScoreBtn(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Scores.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 600);

        stage.setScene(scene);
    }

    @FXML
    private void handleInstructionsBtn() {
        System.out.println("Botón instrucciones presionado");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Instructions.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Instrucciones");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            logger.severe("Error al cargar la ventana de instrucciones: " + e.getMessage());
        }
    }

    @FXML
    private void handleExitBtn(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
