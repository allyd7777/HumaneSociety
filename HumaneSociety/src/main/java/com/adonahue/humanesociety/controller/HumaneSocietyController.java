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
    public void run() throws HumaneSocietyDaoException {
        service.load();
        boolean keepGoing = true;
        int menuSelection = 0;
        view.dogPicture();
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
        Boolean isNull;
        BigDecimal newMoney = new BigDecimal("0");
        String dogId = "";
        do {
            isNull = false;
            try {
                dogId = view.getAdoptionDogId();
                Dog dog = service.getDog(dogId);
                BigDecimal balance = service.loadBudget();
                newMoney = balance.add(dog.getAdoptionCost());
            } catch (NullPointerException e) {
                System.out.println("We don't have that dog!");
                isNull = true;
            }
        } while (isNull);
        service.setCurrentMoney(newMoney);
        service.getDog(dogId).setAdoptionDate(LocalDate.now());
        service.writeBudget(service.getDog(dogId), newMoney);
        service.removeDog(dogId);

        view.displayAdoptADogSuccessBanner();
    }

    //Edit dog method
    private void editDogProfile() throws HumaneSocietyDaoException {
        view.displayEditDogBanner();
         Boolean isNull;
        String dogId = "";
        Dog dog = new Dog("");
        do {
            isNull = false;
            dogId = view.getAdoptionDogId();
            if(!service.getDogIds().contains(dogId)) {
                System.out.println("We don't have that dog!");
                isNull = true;
            } else{
                dog = service.getDog(dogId);
            }
        } while (isNull);
        boolean keepGoing = true;
        while (keepGoing) {
            int editSelection = view.printEditMenuAndGetSelection();
            if (editSelection != 6) {
                String Change = view.editChange();
                service.editDog(dog, Change, keepGoing, editSelection);
            } else {
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
