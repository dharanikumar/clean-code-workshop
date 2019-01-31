package com.thoughtworks.movierental;

import java.util.List;

public class Rentals {
    List<Rental> rentals;

    public Rentals(List<Rental> rentalsObj){
        rentals =rentalsObj;
    }

    public int frequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental each : rentals) {
            //add frequent renter points
            frequentRenterPoints += each.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    public double totalAmount() {
        double totalAmount = 0;
        for (Rental each : rentals) {
            totalAmount += each.amount();
        }
        return totalAmount;
    }



}
