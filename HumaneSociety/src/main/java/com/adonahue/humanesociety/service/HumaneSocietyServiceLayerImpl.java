/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adonahue.humanesociety.service;

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
public class HumaneSocietyServiceLayerImpl implements HumaneSocietyServiceLayer{
    
    InventoryDao dao = new InventoryDaoImpl();
    Money currentMoney = new Money();
    
    @Override
    public List<Dog> getAllDogs(){
       return dao.getAllDogs();
    }
    
    @Override
    public BigDecimal getCurrentMoney(){
        return currentMoney.getBalance();
    }
    
    @Override
    public void setCurrentMoney(BigDecimal balance){
        currentMoney.setBalance(balance);
    }
    
    @Override
    public Dog getDog(String id){
       return dao.passthroughMap().get(id);
    }
    
    
}
