package com.adonahue.humanesociety.dao;

import com.adonahue.humanesociety.dto.Dog;
import java.math.BigDecimal;

/**
 *
 * @author allison
 */
public class InventoryDaoImpl implements InventoryDao{
    
    private static final String DELIMITER = "::";

    @Override
    public void marshallInventory(Dog dog) {
        String dogAsText = dog.getDogID() + DELIMITER;
        dogAsText += dog.getDogName() + DELIMITER;
        dogAsText += dog.getDogAge() + DELIMITER;
        dogAsText += dog.getDogSize() + DELIMITER;
        dogAsText += dog.getAdoptionCost() + DELIMITER;
        dogAsText += dog.getAdmissionDate() + DELIMITER;
        return dogAsText;
    }

    @Override
    public void unmarshallInventory(String dogAsText) {
        String[] inventoryTokens = dogAsText.split(DELIMITER);
        String id = inventoryTokens[0];
        Dog ItemFromFile = new Dog(id);
        DogFromFile.setName(inventoryTokens[1]);
        DogFromFile.setAge(inventoryTokens[2]);
        DogFromFile.setSize(inventoryTokens[3]);
        DogFromFile.setCost(new BigDecimal(inventoryTokens[4]));
        DogFromFile.setDate(inventoryTokens[5]);

        return ItemFromFile;
    }
    
}
