package com.adonahue.humanesociety.dao;

/**
 *
 * @author allison
 */
public interface InventoryDao {
    
    void marshallInventory(Dog dog);
    
    void unmarshallInventory(String dogAsText);
    
}
