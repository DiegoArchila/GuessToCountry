package com.diarchila.guessthecountry.services;

import com.diarchila.guessthecountry.models.Country;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CountryServices {

    private static final Logger logger = Logger.getLogger(CountryServices.class.getName());

    public static final List<Country> COUNTRIES = new ArrayList<>();

    static {
        loadCountries();
    }

    private static void loadCountries() {
        try {
            ObjectMapper countriesMapper = new ObjectMapper();
            File file = new File("src/main/resources/data/Countries.json");
            List<Country> countries = countriesMapper.readValue(file, new TypeReference<>() {});
            COUNTRIES.addAll(countries);
        } catch (Exception e) {
            logger.severe("Error loading countries: " + e.getMessage());
        }

        if (COUNTRIES.isEmpty()) {
            logger.warning("No countries loaded. Check the JSON file.");
        } else {
            logger.info("Countries loaded: " + COUNTRIES.size() + " countries available.");
        }
    }

}