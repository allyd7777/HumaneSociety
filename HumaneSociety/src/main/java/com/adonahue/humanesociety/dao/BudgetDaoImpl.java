package com.adonahue.humanesociety.dao;

import com.adonahue.humanesociety.dto.Dog;
import com.adonahue.humanesociety.dto.Money;
import com.adonahue.humanesociety.service.HumaneSocietyServiceLayer;
import com.adonahue.humanesociety.service.HumaneSocietyServiceLayerImpl;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author allison
 */
public class BudgetDaoImpl implements BudgetDao {

    HumaneSocietyServiceLayer service = new HumaneSocietyServiceLayerImpl();
    private static final String DELIMITER = "::";
    private static final String BUDGET_FILE = "budget.txt";

    @Override
    public String marshallBudget(Dog dog, BigDecimal balance) {

        String budgetAsText = balance + DELIMITER;
        budgetAsText += dog.getDogId() + DELIMITER;
        budgetAsText += dog.getAdoptionDate() + DELIMITER;
        budgetAsText += dog.getAdoptionCost() + DELIMITER;
        return budgetAsText;
    }

    @Override
    public void writeBudget(Dog dog, BigDecimal balance) throws HumaneSocietyDaoException {
        PrintWriter out;
        String budgetAsText;
        try {
            out = new PrintWriter(new FileWriter(BUDGET_FILE, true));
        } catch (IOException e) {
            throw new HumaneSocietyDaoException(
                    "Could not save budget data.", e);
        }
        budgetAsText = marshallBudget(dog, balance);
        out.println(budgetAsText);
        out.flush();
        out.close();
    }

}
