package com.diarchila.guessthecountry.services;

import com.diarchila.guessthecountry.models.Country;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CountryServices {

    public static final List<Country> COUNTRIES = new ArrayList<>();

    static {
        loadCountries();
    }

    private static void loadCountries() {
        try {
            ObjectMapper countriesMapper = new ObjectMapper();
            File file = new File("src/main/resources/data/Countries.json");
            List<Country> countries = countriesMapper.readValue(file, new TypeReference<List<Country>>() {});
            COUNTRIES.addAll(countries);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error loading countries: " + e.getMessage());
        }
    }

}