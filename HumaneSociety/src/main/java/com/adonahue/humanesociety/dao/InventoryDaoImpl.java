package com.adonahue.humanesociety.dao;

import com.adonahue.humanesociety.dto.Dog;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author allison
 */
public class InventoryDaoImpl implements InventoryDao {

    private static final String DELIMITER = "::";
    private static final String INVENTORY_FILE = "dogInventory.txt";
    Map<String, Dog> dogs = new HashMap<>();

    @Override
    public List<Dog> getAllDogs() {
        return dogs.values().stream().collect(Collectors.toList());
    }

    @Override
    public String marshallInventory(Dog dog) {
        String dogAsText = dog.getDogId() + DELIMITER;
        dogAsText += dog.getDogName() + DELIMITER;
        dogAsText += dog.getDogAge() + DELIMITER;
        dogAsText += dog.getDogSize() + DELIMITER;
        dogAsText += dog.getAdoptionCost() + DELIMITER;
        dogAsText += dog.getAdmissionDate() + DELIMITER;
        return dogAsText;
    }

    @Override
    public Dog unmarshallInventory(String dogAsText) {
        String[] inventoryTokens = dogAsText.split(DELIMITER);
        String id = inventoryTokens[0];
        Dog DogFromFile = new Dog(id);
        DogFromFile.setDogName(inventoryTokens[1]);
        DogFromFile.setDogAge(Double.parseDouble(inventoryTokens[2]));
        DogFromFile.setDogSize(inventoryTokens[3]);
        DogFromFile.setAdoptionCost(new BigDecimal(inventoryTokens[4]));
        DogFromFile.setAdmissionDate(LocalDate.parse(inventoryTokens[5]));

        return DogFromFile;
    }

    @Override
    public void loadInventory() throws HumaneSocietyDaoException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(
                    new FileReader(INVENTORY_FILE)));
        } catch (FileNotFoundException e) {
            throw new HumaneSocietyDaoException(
                    "-_- Could not load inventory data into memory.", e);
        }
        String currentLine;
        Dog currentDog;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDog = unmarshallInventory(currentLine);
            dogs.put(currentDog.getDogId(), currentDog);
        }
        scanner.close();
    }

    @Override
    public void writeInventory() throws HumaneSocietyDaoException {
        PrintWriter out;
        String dogAsText;
        List<Dog> dogList = this.getAllDogs();
        try {
            out = new PrintWriter(new FileWriter(INVENTORY_FILE));
        } catch (IOException e) {
            throw new HumaneSocietyDaoException(
                    "Could not save dog data.", e);
        }
        for (Dog currentDog : dogList) {
            dogAsText = marshallInventory(currentDog);
            out.println(dogAsText);
            out.flush();
        }
        out.close();
    }
    
    @Override
    public Map<String, Dog> passthroughMap(){
        return dogs;
    }
    
    @Override
    public Dog removeDog(String id){
       return dogs.remove(id);
    }

}
