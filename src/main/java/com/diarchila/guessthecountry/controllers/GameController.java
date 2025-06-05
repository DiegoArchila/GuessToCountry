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

public class GameController {

    List<Country> countries = CountryServices.COUNTRIES;

    List<Country> countryQuestions = new ArrayList<>();

    Country currentCountryQuestion = null;

    Random random = new Random();

    Score  scoreData = new Score();

    ScoreServices scoreService = new ScoreServices();

    int score = 0;
    int MAXQUESTIONS = 10;
    int SCORE_CORRECT_ANSWER = 100;
    int SCORE_WRONG_ANSWER = 50;

    private Timeline questionTimer;
    private final int TIME_LIMIT = 30; // segundos
    private int timeLeft;

    @FXML
    private Label lblQuestion, lblmaxQuestions, lblScore, lblTimer;

    @FXML
    private ImageView imagenBandera;

    @FXML
    private Button btnOpcion1, btnOpcion2, btnOpcion3, btnOpcion4;

    @FXML
    private Button btnBackToMenuGame;

    @FXML
    private void initialize() {

        btnBackToMenuGame.setOnAction(event -> {
            try {
                backToMenuGame(event);
            } catch (IOException e1) {
                e1.printStackTrace();
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
                System.out.println("Respuesta correcta! Puntuación: " + score);
            } else {
                score -= SCORE_WRONG_ANSWER;
                System.out.println(
                        "Respuesta incorrecta. La respuesta correcta era: " + currentCountryQuestion.getName());
            }
        }

        if (countryQuestions.size() < MAXQUESTIONS) {
            nextQuestion();
        } else {
            lblQuestion.setText("¡Juego terminado!");
            lblScore.setText("Puntuación final: " + score);
            btnOpcion1.setDisable(true);
            btnOpcion2.setDisable(true);
            btnOpcion3.setDisable(true);
            btnOpcion4.setDisable(true);
            System.out.println("Juego terminado. Tu puntuación final es: " + score);

            questionTimer.stop(); // Detener el temporizador
            questionTimer = null; // Limpiar el temporizador
            lblTimer.setText("Tiempo: 0s");

            scoreData.setScore(score);
            scoreData.setDate(new java.util.Date());

            ScoreServices.addScore(scoreData); // Guardamos la puntuación final

            return;
        }

    }

    private void nextQuestion() {

        lblScore.setText("Puntuación: " + score);
        lblmaxQuestions.setText("Preguntas: " + (countryQuestions.size()+1) + "/" + MAXQUESTIONS);

        if (countryQuestions != null) {
            do {
                currentCountryQuestion = countries.get(random.nextInt(countries.size()));
            } while (countryQuestions.contains(currentCountryQuestion));

        }

        countryQuestions.add(currentCountryQuestion);

        lblQuestion.setText("¿A qué país pertenece esta bandera?");
        Image bandera = new Image(currentCountryQuestion.getFlagUrlPNG());

        imagenBandera.setImage(bandera);

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
        btnOpcion1.setText(options.get(0));
        btnOpcion2.setText(options.get(1));
        btnOpcion3.setText(options.get(2));
        btnOpcion4.setText(options.get(3));

        // Se asigna los eventos a los botones de respuesta
        btnOpcion1.setOnAction(this::checkResponse);
        btnOpcion2.setOnAction(this::checkResponse);
        btnOpcion3.setOnAction(this::checkResponse);
        btnOpcion4.setOnAction(this::checkResponse);

        // Mostramos el pais actual y la puntuación
        System.out.println("Respuesta: " + currentCountryQuestion.getName());

        startTimer();

        btnBackToMenuGame.setOnAction(event -> {
            try {
                backToMenuGame(event);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    private void startTimer() {

        if (questionTimer != null) {
            questionTimer.stop();
        }

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

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/MenuGame.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 600);

        stage.setScene(scene);
    }
}
