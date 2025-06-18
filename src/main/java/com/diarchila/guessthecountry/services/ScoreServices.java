package com.diarchila.guessthecountry.services;

import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.diarchila.guessthecountry.models.Score;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ScoreServices {

    private static final Logger logger = Logger.getLogger(ScoreServices.class.getName());

    private static final List<Score> SCORES = new ArrayList<>();

    static {
        loadScores();
    }

    private static void loadScores() {
        try {
            ObjectMapper scoresMapper = new ObjectMapper();
            File file = new File("src/main/resources/data/Scores.json");
            List<Score> scores = scoresMapper.readValue(file, new TypeReference<>() {});

            SCORES.clear();
            SCORES.addAll(scores);

            if (SCORES.isEmpty()) {
                logger.warning("No scores loaded. Check the JSON file.");
            } else {
                logger.info("Scores loaded: " + SCORES.size() + " scores available.");
            }
        } catch (Exception e) {
            logger.severe("Error loading scores: " + e.getMessage());
        }
    }

    public static List<Score> getScores() {
        return new ArrayList<>(SCORES);
    }

    public static void addScore(Score score) {
        if (score != null) {
            SCORES.add(score);
            saveScoreToJSONFile();
        } else {
            logger.warning("Attempted to add a null score.");
        }
    }

    private static void saveScoreToJSONFile() {
        try {
            ObjectMapper scoresMapper = new ObjectMapper();
            File file = new File("src/main/resources/data/Scores.json");
            scoresMapper.writeValue(file, SCORES);

            logger.info("Scores saved to JSON file.");
            loadScores();
        } catch (Exception e) {
            logger.severe("Error saving scores: " + e.getMessage());
        }
    }
}
