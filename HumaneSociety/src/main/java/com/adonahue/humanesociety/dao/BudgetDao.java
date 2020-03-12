package com.adonahue.humanesociety.dao;

import com.adonahue.humanesociety.dto.Dog;
import java.math.BigDecimal;

/**
 *
 * @author allison
 */
public interface BudgetDao {
    
    String marshallBudget(Dog dog, BigDecimal balance);
    
    BigDecimal unmarshallBudget(String balanceAsText);
    
    BigDecimal loadBudget() throws HumaneSocietyDaoException;
    
    void writeBudget(Dog dog, BigDecimal balance) throws HumaneSocietyDaoException;
    
}
