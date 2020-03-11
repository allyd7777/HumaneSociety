/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adonahue.humanesociety.dao;

/**
 *
 * @author allison
 */
public class HumaneSocietyDaoException extends Exception{
    public HumaneSocietyDaoException(String message) {
        super(message);
    }

    public HumaneSocietyDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
