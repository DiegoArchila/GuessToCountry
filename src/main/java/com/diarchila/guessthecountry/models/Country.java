package com.diarchila.guessthecountry.models;

import java.util.ArrayList;
import java.util.List;

public class Country {

    private String name;
    private String capital;
    private String region;
    private String flagUrlPNG;
    private List<String> languages;
    private List<String> currency;

    public Country() {
        this.languages = new ArrayList<>();
        this.currency = new ArrayList<>();
    }

    public Country(
            String name,
            String capital,
            String region,
            String flagUrlPNG,
            List<String> languages,
            List<String> currency) {
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.flagUrlPNG = flagUrlPNG;
        this.languages = (languages!=null) ? new ArrayList<>(languages) : new ArrayList<>();
        this.currency = (currency!=null) ? new ArrayList<>(currency) : new ArrayList<>();
    }

    /*
     * Getters
     */

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getRegion() {
        return region;
    }

    public String getFlagUrlPNG() {
        return flagUrlPNG;
    }

    public List<String> getLanguages() {
        return new ArrayList<>(this.languages);
    }

    public List<String> getCurrency() { 
        return new ArrayList<>(this.currency); 
    }

    /*
     * Setters
     */

    public void setName(String name) {
        this.name = name;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setLanguages(List<String> languages) {
         this.languages = (languages != null) ? new ArrayList<>(languages) : new ArrayList<>();
    }

    public void setFlagUrlPNG(String flagUrlPNG) {
        this.flagUrlPNG = flagUrlPNG;
    }

    public void setCurrency(List<String> currency) { 
        this.currency = (currency != null) ? new ArrayList<>(currency) : new ArrayList<>();
    }

    public void addLanguages(String languageToAdd) {
        this.languages.add(languageToAdd);
    }

    public void addCurrency(String currencyToAdd) {
        this.currency.add(currencyToAdd);
    }
}