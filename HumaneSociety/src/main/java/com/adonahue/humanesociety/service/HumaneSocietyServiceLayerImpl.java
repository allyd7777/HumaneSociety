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
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author allison
 */
public class HumaneSocietyServiceLayerImpl implements HumaneSocietyServiceLayer {

    InventoryDao dao = new InventoryDaoImpl();
    BudgetDao bdao = new BudgetDaoImpl();
    Money currentMoney = new Money();

    public HumaneSocietyServiceLayerImpl(InventoryDaoImpl dao, BudgetDaoImpl bdao) {
        this.dao = dao;
        this.bdao = bdao;
    }

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

    @Override
    public void writeBudget(Dog dog, BigDecimal newMoney) throws HumaneSocietyDaoException {
        bdao.writeBudget(dog, newMoney);
    }

    @Override
    public void editDog(Dog dog, String Change, boolean keepGoing, int editSelection) throws HumaneSocietyDaoException {
        switch (editSelection) {
            case 1:
                dog.setDogName(Change);
                break;
            case 2:
                dog.setDogSize(Change);
                break;
            case 3:
                dog.setDogAge(Double.parseDouble(Change));
                break;
            case 4:
                dog.setAdoptionCost(new BigDecimal(Change));
                break;
            case 5:
                dog.setAdmissionDate(LocalDate.parse(Change));
                break;
            case 6:
                keepGoing = false;
        }
        dao.writeInventory();
    }

    @Override
    public void load() throws HumaneSocietyDaoException {
        dao.loadInventory();
        bdao.loadBudget();
    }
}
