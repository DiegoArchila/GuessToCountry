package com.diarchila.guessthecountry.controllers;

import com.diarchila.guessthecountry.models.Country;
import com.diarchila.guessthecountry.models.Score;
import com.diarchila.guessthecountry.services.CountryServices;
import com.diarchila.guessthecountry.services.ScoreServices;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameController {

    private static final Logger logger = Logger.getLogger(GameController.class.getName());

    List<Country> countries = CountryServices.COUNTRIES;

    List<Country> countryQuestions = new ArrayList<>();

    Country currentCountryQuestion = null;

    Random random = new Random();

    Score  scoreData = new Score();

    int score = 0;
    int MAX_QUESTIONS = 10;
    int SCORE_CORRECT_ANSWER = 100;
    int SCORE_WRONG_ANSWER = 50;

    private Timeline questionTimer;
    private int timeLeft;

    @FXML
    private Label lblQuestion, lblMaxQuestions, lblScore, lblTimer;

    @FXML
    private ImageView flagImage;

    @FXML
    private Button btnOption1, btnOption2, btnOption3, btnOption4;

    @FXML
    private Button btnBackToMenuGame;

    @FXML
    private void initialize() {

        btnBackToMenuGame.setOnAction(event -> {
            try {
                backToMenuGame(event);
            } catch (IOException e1) {
                logger.log(Level.SEVERE, "Error al volver al menú del juego", e1);
            }
        });

        nextQuestion(); // Cargamos la primera pregunta al iniciar
    }

    private void checkResponse(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String selectedCountry = clickedButton.getText();

        if (currentCountryQuestion != null) {
            if (selectedCountry.equals(currentCountryQuestion.getName())) {
                score += SCORE_CORRECT_ANSWER;
                logger.log(Level.INFO, "Respuesta correcta! Puntuación: {0}", score);
            } else {
                score -= SCORE_WRONG_ANSWER;
                logger.log(Level.WARNING, "Respuesta incorrecta. La respuesta correcta era: {0}", currentCountryQuestion.getName());
            }
        }

        if (countryQuestions.size() < MAX_QUESTIONS) {
            nextQuestion();
        } else {
            lblQuestion.setText("¡Juego terminado!");
            lblScore.setText("Puntuación final: " + score);
            btnOption1.setDisable(true);
            btnOption2.setDisable(true);
            btnOption3.setDisable(true);
            btnOption4.setDisable(true);

            logger.log(Level.INFO, "Juego terminado. Puntuación final: {0}", score);

            questionTimer.stop(); // Detener el temporizador
            questionTimer = null; // Limpiar el temporizador
            lblTimer.setText("Tiempo: 0s");

            scoreData.setScore(score);
            scoreData.setDate(new java.util.Date());

            ScoreServices.addScore(scoreData); // Guardamos la puntuación final
        }
    }

    private void nextQuestion() {
        lblScore.setText("Puntuación: " + score);
        lblMaxQuestions.setText("Preguntas: " + (countryQuestions.size()+1) + "/" + MAX_QUESTIONS);

        if (countryQuestions != null) {
            do {
                currentCountryQuestion = countries.get(random.nextInt(countries.size()));
            } while (countryQuestions.contains(currentCountryQuestion));

        }

        assert countryQuestions != null;
        countryQuestions.add(currentCountryQuestion);

        lblQuestion.setText("¿A qué país pertenece esta bandera?");
        Image flag = new Image(currentCountryQuestion.getFlagUrlPNG());

        flagImage.setImage(flag);

        // Limpiar botones antes de asignar nuevas opciones de respuesta
        List<String> options = new ArrayList<>();
        options.add(currentCountryQuestion.getName()); // Respuesta correcta

        // Añadir 3 opciones incorrectas
        while (options.size() < 4) {
            String randomCountryName = countries.get(random.nextInt(countries.size())).getName();
            if (!options.contains(randomCountryName)) {
                options.add(randomCountryName);
            }
        }

        // combinamos los nombres de países y los mezclamos
        java.util.Collections.shuffle(options);

        // Asignar texto a los botones
        btnOption1.setText(options.get(0));
        btnOption2.setText(options.get(1));
        btnOption3.setText(options.get(2));
        btnOption4.setText(options.get(3));

        // Se asigna los eventos a los botones de respuesta
        btnOption1.setOnAction(this::checkResponse);
        btnOption2.setOnAction(this::checkResponse);
        btnOption3.setOnAction(this::checkResponse);
        btnOption4.setOnAction(this::checkResponse);

        // Mostramos el pais actual y la puntuación
        logger.log(Level.INFO, "Respuesta: {0}", currentCountryQuestion.getName());

        startTimer();

        btnBackToMenuGame.setOnAction(event -> {
            try {
                backToMenuGame(event);
            } catch (IOException e1) {
                logger.log(Level.SEVERE, "Error al volver al menú del juego", e1);
            }
        });
    }

    private void startTimer() {

        if (questionTimer != null) {
            questionTimer.stop();
        }

        // segundos
        int TIME_LIMIT = 30;
        timeLeft = TIME_LIMIT;
        lblTimer.setText("Tiempo: " + timeLeft + "s");

        questionTimer = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            timeLeft--;
            lblTimer.setText("Tiempo: " + timeLeft + "s");

            if (timeLeft <= 0) {
                questionTimer.stop();
                handleTimeout(); // Se cuenta como incorrecta si no responde
            }
        }));
        questionTimer.setCycleCount(TIME_LIMIT);
        questionTimer.play();
    }

    private void handleTimeout() {

        score -= SCORE_WRONG_ANSWER;

        nextQuestion(); 
    }

    private void backToMenuGame(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/GameMenu.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 600);

        stage.setScene(scene);
    }
}
