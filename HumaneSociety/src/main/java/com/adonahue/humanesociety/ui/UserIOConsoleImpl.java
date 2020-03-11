/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adonahue.humanesociety.ui;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author colin
 */
public class UserIOConsoleImpl implements UserIO {
        Scanner sc = new Scanner(System.in);

    public int readInt(String prompt) {
        while (true) {
            System.out.println(prompt);
            String stringInteger = sc.nextLine();

            try {
                int integer = Integer.parseInt(stringInteger);
                return integer;
            } catch (NumberFormatException e) {
                System.out.println("Not an integer!");
            }
        }
    }

    public int readInt(String prompt, int min, int max) {
        int integer = 0;
        while (true) {
            do {
                System.out.println(prompt);
                String stringInteger = sc.nextLine();
                while (stringInteger.isEmpty()) {
                    System.out.println(prompt);
                    stringInteger = sc.nextLine();
                }
                try {
                    integer = Integer.parseInt(stringInteger); //put this into a try catch 
                    return integer;
                } catch (NumberFormatException e) {
                    System.out.println("Not an integer!");
                }
            } while (integer < min || integer > max);

        }
    }

    public String readString(String prompt) {
        while (true) {
        System.out.println(prompt);
        try{
        String input = sc.nextLine();
            return input;
        } catch (Exception e) {
            System.out.println("Not a String!");
            }
    }
    }

    public float readFloat(String prompt) {
        System.out.println(prompt);
        String stringFloat = sc.nextLine();
        float readFloat = Float.parseFloat(stringFloat);
        return readFloat;
    }

    public float readFloat(String prompt, float min, float max) {
        float readFloat;
        do {
            System.out.println(prompt);
            String stringFloat = sc.nextLine();
            readFloat = Float.parseFloat(stringFloat);
        } while (readFloat < min || readFloat > max);
        return readFloat;
    }

    public double readDouble(String prompt) {
        System.out.println(prompt);
        String stringDouble = sc.nextLine();
        double readDouble = Double.parseDouble(stringDouble);
        return readDouble;
    }

    public double readDouble(String prompt, double min, double max) {
        double readDouble;
        do {
            System.out.println(prompt);
            String stringDouble = sc.nextLine();
            readDouble = Double.parseDouble(stringDouble);
        } while (readDouble < min || readDouble > max);
        return readDouble;
    }

    public long readLong(String prompt) {
        System.out.println(prompt);
        String stringLong = sc.nextLine();
        long readLong = Long.parseLong(stringLong);
        return readLong;
    }

    public long readLong(String prompt, long min, long max) {
        long readLong;
        do {
            System.out.println(prompt);
            String stringLong = sc.nextLine();
            readLong = Long.parseLong(stringLong);
        } while (readLong < min || readLong > max);
        return readLong;
    }

    public void printDate(LocalDate date) {
        System.out.println(date);
    }

    public void print(String message) {
        System.out.println(message);
    }

    public LocalDate readDate(String prompt) {
        while (true) {
            LocalDate date;
            System.out.println(prompt);
            String stringDate = sc.nextLine();
            try {
                date = LocalDate.parse(stringDate);
                return date;
            } catch (DateTimeException e) {
                System.out.println("Invalid input!");
            }
        }
    }

    public BigDecimal readBigDecimal(String prompt) {
        while (true) {
            System.out.println(prompt);
            String stringBigDecimal = sc.nextLine();
            try {
                BigDecimal bd = new BigDecimal(stringBigDecimal);
                bd.setScale(2, RoundingMode.HALF_UP);
                return bd;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
    }
}
