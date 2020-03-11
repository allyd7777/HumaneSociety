package com.adonahue.humanesociety.controller;

import com.adonahue.humanesociety.dao.HumaneSocietyDaoException;
import com.adonahue.humanesociety.dto.Dog;
import com.adonahue.humanesociety.service.HumaneSocietyServiceLayer;
import com.adonahue.humanesociety.ui.HumaneSocietyView;
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
            Dog currentDog = view.getNewStudentInfo(); //****Verify the call method
            try {
                service.createStudent(currentDog); //****Verify the call method
                view.displayCreateSuccesBanner(); ////****Verify if Banner is created?
                hasErrors = false;
            } catch (HumaneSocietyDaoException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
    }


    
}
