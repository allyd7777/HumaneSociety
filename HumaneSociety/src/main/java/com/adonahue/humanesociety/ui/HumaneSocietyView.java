package com.adonahue.humanesociety.ui;

import com.adonahue.humanesociety.dto.Dog;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author allison
 */
public class HumaneSocietyView {
    
    UserIO io = new UserIOConsoleImpl();
    
    public HumaneSocietyView(UserIOConsoleImpl io) {
        this.io = io;
    }
    
    public int printMenuAndGetSelection() {
        io.print("Welcome to Puppies R Us!");
        io.print("Would you like to:");
        io.print("1. View all dogs in the shelter");
        io.print("2. Donate a dog to the shelter");
        io.print("3. Adopt a dog!!!!!");
        io.print("4. Edit dog profile");
        io.print("5. Exit");
        
        return io.readInt("Please select from the above options", 1, 5);
    }
    
    public void displayViewAllDogsBanner() {
        io.print("Here are ALL our dogs!");
    }
    
    public void displayDonateADogBanner() {
        io.print("Tell us about the dog you want to donate");
    }
    
    public void displayAdoptADogBanner() {
        io.print("Which dog would you like to take home today!?");
    }
    
    public void displayEditDogBanner() {
        io.print("Edit a dog:");
    }
    
    public void displayGoodbyeMessage() {
        io.print("See you later! Hug a dog today! (But only if it wants the hug)");
    }
    
    public void displayAllDogs(List<Dog> dogs) {
        for (Dog d : dogs) {
            io.print(d.getDogId());
            io.print(d.getDogName());
            io.print(d.getDogSize());
            io.print(Double.toString(d.getDogAge()));
            io.print(d.getAdoptionCost().toString());
            io.print(d.getAdmissionDate().toString());
        }
    }
    
    public Dog getNewDogInfo() {
        LocalDate admissionDate;
        String newId = io.readString("Please enter the new dog ID");
        String dogName = io.readString("What is the name of the  new dog? ");
        String dogSize = io.readString("What is the size of the new dog? ");
        double dogAge = io.readDouble("What is the age of the new dog in years?");
        BigDecimal adoptionCost = io.readBigDecimal("What is the adoption cost of the new dog?");
        admissionDate = LocalDate.now();
        Dog newDog = new Dog(newId);
        newDog.setDogName(dogName);
        newDog.setDogSize(dogSize);
        newDog.setDogAge(dogAge);
        newDog.setAdoptionCost(adoptionCost);
        newDog.setAdmissionDate(admissionDate);
        return newDog;
    }
    
    public String getIdToRemove() {
      return  io.readString("Please enter the ID of the dog you would like to adopt!");
    }
    
    public String getDogToEdit() {
        String idToEdit = io.readString("Please enter the ID of the dog you would like to edit.");
        return idToEdit;
    }
    
    public String getAdoptionDogId(){
        return io.readString("Please enter the ID of the adopted dog.");
    }
    
    public int printEditMenuAndGetSelection() {
        io.print("===Edit Dog Info===");
        io.print("What would you like to edit?:");
        io.print("1. Dog Name");
        io.print("2. Dog size");
        io.print("3. Dog age");
        io.print("4. Adoption Cost");
        io.print("5. Admission Date");
        
        return io.readInt("Please select from the above options", 1, 5);
    }
    
    public void displayDonateADogSuccssBanner() {
        io.print("Dog has been successfull donated. Bittersweet.");
    }
    
    public void displayEditSuccessDogBanner() {
        io.print("Dog profile sucessfully edited! Look at you go!");
    }
    
    public void displayAdoptADogSuccessBanner() {
        io.print("Dog successfully adopted! Bye, buddy, have fun with your new parent(s)!");
    }
    
    public String getDogToAdopt() {
       return io.readString("Please enter the ID for the dog you want to adopt");
    }
}
