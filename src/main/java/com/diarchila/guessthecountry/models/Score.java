package com.diarchila.guessthecountry.models;

import java.util.Date;

public class Score {

    private Date date= new Date();
    private Integer score=0; 

    public Score(Date date, Integer score) {
        this.date = date;
        this.score = score;
    }
    
    public Score() {
        // Default constructor
    }

    public Date getDate() {
        return date;
    }

    public Integer getScore() {
        return score;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public void setScore(Integer score) {
        this.score = score;
    }

}
