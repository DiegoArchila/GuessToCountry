package com.diarchila.guessthecountry.services;

import java.util.List;
import java.io.File;
import java.util.ArrayList;

import com.diarchila.guessthecountry.models.Score;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ScoreServices {

    private static final List<Score> SCORES = new ArrayList<>();

    static {
        loadScores();
    }

    /**
     * Loads scores from a JSON file into the static list of scores.
     *
     * <p>
     * This method reads a JSON file located at "src/main/resources/data/Scores.json"
     * and populates the static list {@code SCORES} with the data. If the file cannot
     * be read or parsed, an error message is printed to the standard error stream.
     * </p>
     */
    private static void loadScores() {

        try {

            ObjectMapper scoresMapper = new ObjectMapper();
            File file = new File("src/main/resources/data/Scores.json");
            List<Score> scores = scoresMapper.readValue(file, new TypeReference<List<Score>>() {
            });

            SCORES.clear(); // Clear existing scores to avoid duplicates

            SCORES.addAll(scores);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error loading scores: " + e.getMessage());
        }

        System.err.println("Scores loaded");

        if (SCORES.isEmpty()) {
            System.err.println("No scores loaded. Check the JSON file.");
        }
    }

    /**
     * Returns a copy of the list of scores currently stored.
     *
     * <p>
     * This method provides read-only access to the stored scores by returning a new
     * list
     * containing the same elements as the internal list. Modifications to the
     * returned list
     * will not affect the original data.
     * </p>
     *
     * @return a list containing all stored {@code Score} objects
     */
    public static List<Score> getScores() {
        return new ArrayList<>(SCORES);
    }

    /**
     * Adds a new score to the list of stored scores.
     *
     * <p>
     * If the provided score is {@code null}, the method will not modify the list
     * and
     * will print an error message to the standard error stream.
     * </p>
     *
     * @param score the {@code Score} object to be added; must not be {@code null}
     */
    public static void addScore(Score score) {
        if (score != null) {
            SCORES.add(score);
            saveScoreToJSONFile();
        } else {
            System.err.println("It was not possible to add the score.");
        }
    }

    /**
     * Saves the current list of scores to a JSON file.
     *
     * <p>
     * This method serializes the list of scores and writes it to a file located at
     * "src/main/resources/data/Scores.json". If an error occurs during the
     * serialization or file writing process, an error message is printed to the
     * standard error stream.
     * </p>
     */
    private static void saveScoreToJSONFile() {
        try {
            ObjectMapper scoresMapper = new ObjectMapper();
            File file = new File("src/main/resources/data/Scores.json");
            scoresMapper.writeValue(file, SCORES);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error saving scores: " + e.getMessage());
        }
        System.err.println("Scores saved to JSON file.");
    
        loadScores();
    
    }


}
