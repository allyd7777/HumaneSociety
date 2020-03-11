package com.adonahue.humanesociety.controller;

import com.adonahue.humanesociety.dao.HumaneSocietyDaoException;
import com.adonahue.humanesociety.dto.Dog;
import com.adonahue.humanesociety.service.HumaneSocietyServiceLayer;
import com.adonahue.humanesociety.ui.HumaneSocietyView;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author allison
 */
public class HumaneSocietyController {
    
    HumaneSocietyView view;
    HumaneSocietyServiceLayer service;
    
    public HumaneSocietyController(HumaneSocietyView view, HumaneSocietyServiceLayer service) {
        this.view = view;
        this.service = service;
    }
    
    // Run method
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        viewAllDogs();
                        break;
                    case 2:
                        donateADog();
                        break;
                    case 3:
                        adoptADog();
                        break;
                    case 4:
                        editDogProfile();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (HumaneSocietyDaoException e) {

        }
        
    }
    
    //Method to get menu selection
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    //Method to view all dogs
    private void viewAllDogs() throws HumaneSocietyDaoException {
        view.displayViewAllDogsBanner();
        List<Dog> dogList = service.getAllDogs(); //****Verify the call method from service layer
        view.displayAllDogs(dogList);
    }
    
    //Method to donate a dog
    private void donateADog() throws HumaneSocietyDaoException {
        view.displayDonateADogBanner();
        boolean hasErrors = false;
        do {
            Dog currentDog = view.getNewDogInfo();
            try {
                service.createDog(currentDog); //****Verify the call method
                hasErrors = false;
            } catch (HumaneSocietyDaoException e) {
                hasErrors = true;
                System.out.println("ERROR: Could not create donate dog profile.");
            }
        } while (hasErrors);
        view.displayDonateADogSuccssBanner();
    }
    
    //Adopt a dog method
    private void adoptADog() throws HumaneSocietyDaoException {
        view.displayAdoptADogBanner();

        String dogId = view.getAdoptionDogId(); // Verify the call method for getDogIdChoice
        BigDecimal balance = service.getCurrentMoney();
        BigDecimal newMoney = balance.subtract(service.getDog(dogId).getAdoptionCost());
        service.setCurrentMoney(newMoney);

        service.removeDog(dogId); // verify call method for removeDog?
        view.displayAdoptADogSuccessBanner();
    }
    
    //Edit dog method
     private void editDogProfile() throws HumaneSocietyDaoException {
        view.displayEditDogBanner();
        String dogId = view.getDogToEdit();
        if (dao.editNameLogic(dvdName)) {
            DVD editDVD = view.getEditDVDInfo(dvdName);
            dao.addDVD(editDVD.getDvdName(), editDVD);
            view.displayEditSuccessBanner();
        } else view.displayNoEditDVD();
        view.displayEditSuccessDogBanner();
    }


    
}
