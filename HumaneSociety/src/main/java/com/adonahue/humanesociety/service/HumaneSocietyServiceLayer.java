package com.adonahue.humanesociety.service;

import com.adonahue.humanesociety.dto.Dog;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author allison
 */
public interface HumaneSocietyServiceLayer {

    List<Dog> getAllDogs();

    BigDecimal getCurrentMoney();

    void setCurrentMoney(BigDecimal balance);

    Dog getDog(String id);

    void removeDog(String id);

    void createDog(Dog dog);
}
