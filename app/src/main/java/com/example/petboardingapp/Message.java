package com.example.petboardingapp;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

    private Date boardDate;
    private String name;
    private Integer numDays;
    private String petType;
    private Boolean vaccinated;

    @Override
    public String toString() {
        return "Message{" +
                "boardDate='" + boardDate + '\'' +
                ", name='" + name + '\'' +
                ", numDays='" + numDays + '\'' +
                ", petType='" + petType + '\'' +
                ", vaccinated='" + vaccinated + '\'' +
                '}';
    }

    public Message() {
// Default constructor required for calls to snapshot.toObject(Message.class)
    }

    public Message(Date boardDate, String name, Integer numDays, String petType, Boolean vaccinated) {
        this.boardDate = boardDate;
        this.name = name;
        this.numDays = numDays;
        this.petType = petType;
        this.vaccinated = vaccinated;
    }

    public Date getBoardDate() {
        return boardDate;
    }

    public void setBoardDate(Date boardDate) {
        this.boardDate = boardDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumDays() {
        return numDays;
    }

    public void setNumDays(Integer numDays) {
        this.numDays = numDays;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public Boolean getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(Boolean vaccinated) {
        this.vaccinated = vaccinated;
    }
}
