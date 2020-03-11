package com.adonahue.humanesociety.dao;

import com.adonahue.humanesociety.dto.Dog;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author allison
 */
public class InventoryDaoImpl implements InventoryDao{
    
    private static final String DELIMITER = "::";

    @Override
    public String marshallInventory(Dog dog) {
        String dogAsText = dog.getDogID() + DELIMITER;
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
            throw new VendingMachineDaoException(
                    "-_- Could not load inventory data into memory.", e);
        }
        String currentLine;
        Item currentItem;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentItem = unmarshallInventory(currentLine);
            items.put(currentItem.getId(), currentItem);
        }
        scanner.close();
    }
    
}
