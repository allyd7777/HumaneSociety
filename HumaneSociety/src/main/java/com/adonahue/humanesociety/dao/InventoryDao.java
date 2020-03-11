package com.adonahue.humanesociety.dao;

import com.adonahue.humanesociety.dto.Dog;

/**
 *
 * @author allison
 */
public interface InventoryDao {
    
    String marshallInventory(Dog dog);
    
    Dog unmarshallInventory(String dogAsText);
    
}
