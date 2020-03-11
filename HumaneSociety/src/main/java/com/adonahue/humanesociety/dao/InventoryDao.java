package com.adonahue.humanesociety.dao;

import com.adonahue.humanesociety.dto.Dog;
import java.util.List;
import java.util.Map;

/**
 *
 * @author allison
 */
public interface InventoryDao {
    
    List<Dog> getAllDogs();
    Map<String, Dog> passthroughMap();
    Dog removeDog(String id);
    
    String marshallInventory(Dog dog);
    
    Dog unmarshallInventory(String dogAsText);
    
    void loadInventory() throws HumaneSocietyDaoException;
    
    void writeInventory() throws HumaneSocietyDaoException;
    
}
