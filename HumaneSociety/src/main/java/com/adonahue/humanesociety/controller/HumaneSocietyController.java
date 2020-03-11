package com.adonahue.humanesociety.controller;

import com.adonahue.humanesociety.dao.HumaneSocietyDaoException;
import com.adonahue.humanesociety.dto.Dog;
import com.adonahue.humanesociety.service.HumaneSocietyServiceLayer;
import com.adonahue.humanesociety.ui.HumaneSocietyView;
import java.math.BigDecimal;
import java.time.LocalDate;
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
        Dog currentDog = view.getNewDogInfo();
        service.createDog(currentDog);
        view.displayDonateADogSuccssBanner();
    }

    //Adopt a dog method
    private void adoptADog() throws HumaneSocietyDaoException {
        view.displayAdoptADogBanner();
        String dogId = view.getAdoptionDogId();
        BigDecimal balance = service.getCurrentMoney();
        BigDecimal newMoney = balance.subtract(service.getDog(dogId).getAdoptionCost());
        service.setCurrentMoney(newMoney);
        service.removeDog(dogId);
        service.writeBudget(service.getDog(dogId), newMoney);
        view.displayAdoptADogSuccessBanner();
    }

    //Edit dog method
    private void editDogProfile() throws HumaneSocietyDaoException {
        view.displayEditDogBanner();
        String dogId = view.getDogToEdit();
        Dog dog = service.getDog(dogId);
        int editSelection = view.printEditMenuAndGetSelection();
        String Change = view.editChange();
        boolean keepGoing = true;
        while (keepGoing) {
            switch (editSelection) {
                case 1:
                    dog.setDogName(Change);
                    break;
                case 2:
                    dog.setDogSize(Change);
                    break;
                case 3:
                    dog.setDogAge(Double.parseDouble(Change));
                    break;
                case 4:
                    dog.setAdoptionCost(new BigDecimal(Change));
                    break;
                case 5:
                    dog.setAdmissionDate(LocalDate.parse(Change));
                    break;
                case 6:
                    keepGoing = false;
            }
        }

        view.displayEditSuccessDogBanner();
    }

    //Unknown method
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    //Exit method
    private void exitMessage() {
        view.displayExitBanner();
    }

}
