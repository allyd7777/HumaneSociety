package com.adonahue.humanesociety.dao;

import com.adonahue.humanesociety.dto.Dog;
import java.util.List;

/**
 *
 * @author allison
 */
public interface InventoryDao {
    
    List<Dog> getAllDogs();
    
    String marshallInventory(Dog dog);
    
    Dog unmarshallInventory(String dogAsText);
    
    void loadInventory() throws HumaneSocietyDaoException;
    
    void writeInventory() throws HumaneSocietyDaoException;
    
}
