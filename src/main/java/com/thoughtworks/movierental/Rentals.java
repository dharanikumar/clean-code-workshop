package com.thoughtworks.movierental;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental> {


    double totalAmount() {
      double totalAmount = 0;
      for (Rental each : this) {
        totalAmount += each.amount();
      }
      return totalAmount;
    }

    int frequentRenterPoints() {
      int frequentRenterPoints = 0;
      for (Rental each : this) {
        //add frequent renter points
        frequentRenterPoints += each.getFrequentRenterPoints();
      }
      return frequentRenterPoints;
    }
}
