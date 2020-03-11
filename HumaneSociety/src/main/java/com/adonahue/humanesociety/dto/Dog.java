package com.adonahue.humanesociety.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author allison
 */
public class Dog {
    private String dogName; //Key
    private String dogSize; //Values
    private double dogAge; //Values
    private BigDecimal adoptionCost; //Values
    private LocalDate admissionDate; //Values
    
    public Dog(String dogName) { //Constructor for dog name.
        this.dogName = dogName;
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
        this.admissionDate = adimissionDate;
    }
    
}
