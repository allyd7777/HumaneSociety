package com.adonahue.humanesociety.ui;

import com.adonahue.humanesociety.dto.Dog;
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
    
    public void displayEditDogBannder() {
        io.print("Edit a dog:");
    }
    
    public void displayGoodbyeMessage() {
        io.print("See you later! Hug a dog today! (But only if it wants the hug)");
    }
    
    public void displayAllDogs(List<Dog> dogs) {
        for (Dog d : dogs) {
            io.print(d.);
        }
    }
}
