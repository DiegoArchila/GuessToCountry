package com.diarchila.guessthecountry;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GuessTheCountry extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 740, 1048);
        stage.setTitle("Guess The Country Game!");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}