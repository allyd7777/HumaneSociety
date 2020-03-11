package com.adonahue.humanesociety.service;

import com.adonahue.humanesociety.dao.HumaneSocietyDaoException;
import com.adonahue.humanesociety.dto.Dog;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author allison
 */
public interface HumaneSocietyServiceLayer {

    List<Dog> getAllDogs() throws HumaneSocietyDaoException;

    BigDecimal getCurrentMoney();

    void setCurrentMoney(BigDecimal balance);

    Dog getDog(String id);

    void removeDog(String id) throws HumaneSocietyDaoException;

    void createDog(Dog dog) throws HumaneSocietyDaoException;
    
    void editDog(Dog dog, String Change, boolean keepGoing, int editSelection) throws HumaneSocietyDaoException;
    
     void writeBudget(Dog dog, BigDecimal newMoney) throws HumaneSocietyDaoException;
}
