/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adonahue.humanesociety.dto;

import java.math.BigDecimal;

/**
 *
 * @author brian
 */
public class Money {
    private BigDecimal balance = new BigDecimal(-1000.00); 
    private BigDecimal overHeadCost;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getOverHeadCost() {
        return overHeadCost;
    }

    public void setOverHeadCost(BigDecimal overHeadCost) {
        this.overHeadCost = overHeadCost;
    }
}

