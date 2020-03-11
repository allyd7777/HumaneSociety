package com.adonahue.humanesociety.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author allison
 */
public class Dog {
    private String dogId; //Key
    private String dogName; //Values
    private String dogSize; //Values
    private double dogAge; //Values
    private BigDecimal adoptionCost; //Values
    private LocalDate admissionDate; //Values
    
    public Dog(String dogId) { //Constructor for dog id.
        this.dogId = dogId;
    }

    public String getDogId() {
        return dogId;
    }

    public void setDogId(String dogId) {
        this.dogId = dogId;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getDogSize() {
        return dogSize;
    }

    public void setDogSize(String dogSize) {
        this.dogSize = dogSize;
    }

    public double getDogAge() {
        return dogAge;
    }

    public void setDogAge(double dogAge) {
        this.dogAge = dogAge;
    }

    public BigDecimal getAdoptionCost() {
        return adoptionCost;
    }

    public void setAdoptionCost(BigDecimal adoptionCost) {
        this.adoptionCost = adoptionCost;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }
    
}
