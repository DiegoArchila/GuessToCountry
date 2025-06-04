package com.diarchila.guessthecountry.controllers;

import com.diarchila.guessthecountry.models.Score;
import com.diarchila.guessthecountry.services.ScoreServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.scene.control.TableCell;

public class ScoreController {

    @FXML
    private TableView<Score> scoreTable;

    @FXML
    private TableColumn<Score, Date> dateColumn;

    @FXML
    private TableColumn<Score, Integer> scoreColumn;

    @FXML
    private Button btnBackToMenuGame;

    @FXML
    public void initialize() {
        // Configurar columnas
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));

        // Formatear fecha/hora
        dateColumn.setCellFactory(column -> {
            return new TableCell<Score, Date>() {
                private final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");

                @Override
                protected void updateItem(Date item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty || item == null ? null : format.format(item));
                }
            };
        });

        // Cargar datos
        ObservableList<Score> scores = FXCollections.observableArrayList(ScoreServices.getScores());
        scoreTable.setItems(scores);

         btnBackToMenuGame.setOnAction(event -> {
            try {
                backToMenuGame(event);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    @FXML
    private void handleExit() {
        // Cierra la ventana actual
        Stage stage = (Stage) scoreTable.getScene().getWindow();
        stage.close();
    }

    private void backToMenuGame(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/MenuGame.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 600);

        stage.setScene(scene);
    }
}
