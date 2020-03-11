/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adonahue.humanesociety.service;

import com.adonahue.humanesociety.dao.BudgetDao;
import com.adonahue.humanesociety.dao.BudgetDaoImpl;
import com.adonahue.humanesociety.dao.HumaneSocietyDaoException;
import com.adonahue.humanesociety.dto.Dog;
import com.adonahue.humanesociety.dao.InventoryDao;
import com.adonahue.humanesociety.dao.InventoryDaoImpl;
import com.adonahue.humanesociety.dto.Money;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author allison
 */
public class HumaneSocietyServiceLayerImpl implements HumaneSocietyServiceLayer {

    InventoryDao dao = new InventoryDaoImpl();
    BudgetDao bdao = new BudgetDaoImpl();
    Money currentMoney = new Money();

    @Override
    public List<Dog> getAllDogs() throws HumaneSocietyDaoException {
        dao.loadInventory();
        return dao.getAllDogs();
    }

    @Override
    public BigDecimal getCurrentMoney() {
        return currentMoney.getBalance();
    }

    @Override
    public void setCurrentMoney(BigDecimal balance) {
        currentMoney.setBalance(balance);
    }

    @Override
    public Dog getDog(String id) {
        return dao.passthroughMap().get(id);
    }

    @Override
    public void removeDog(String id) throws HumaneSocietyDaoException {
        dao.loadInventory();
        dao.removeDog(id);
        dao.writeInventory();
    }

    @Override
    public void createDog(Dog dog) throws HumaneSocietyDaoException {
        dao.loadInventory();
        dao.createDog(dog);
        dao.writeInventory();
    }

    public void writeBudget(Dog dog, BigDecimal newMoney) throws HumaneSocietyDaoException{
        bdao.writeBudget(dog, newMoney);
    }

}
