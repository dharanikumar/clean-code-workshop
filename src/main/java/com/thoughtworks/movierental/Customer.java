package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private String name;
  private List<Rental> rentals = new ArrayList<>();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentals.add(arg);
  }

  public String getName() {
    return name;
  }

  public String statement() {

    StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

    for (Rental each : rentals) {
      //show figures for this rental
      result.append("\t").append(each.getMovie().getTitle()).append("\t").append(String.valueOf(each.amount())).append("\n");

    }

    //add footer lines result
    result.append("Amount owed is ").append(String.valueOf(totalAmount())).append("\n");
    result.append("You earned ").append(String.valueOf(frequentRenterPoints())).append(" frequent renter points");
    return result.toString();
  }


  public String htmlStatement(){
    return new TextStatement().display(getName(),rentals,totalAmount(),frequentRenterPoints());

  }

  private int frequentRenterPoints() {
    int frequentRenterPoints = 0;
    for (Rental each : rentals) {
      //add frequent renter points
      frequentRenterPoints += each.getFrequentRenterPoints();
    }
    return frequentRenterPoints;
  }

  private double totalAmount() {
    double totalAmount = 0;
    for (Rental each : rentals) {
      totalAmount += each.amount();
    }
    return totalAmount;
  }


  private class TextStatement {
    public String display(String name, List<Rental> rentals,double totalAmount,int frequentRenterPoints) {
      StringBuilder result = new StringBuilder("<h1>Rental Record for <b>" + name + "</b></h1><br/>");

      for (Rental each : rentals) {
        //show figures for this rental
        result.append(" ").append(each.getMovie().getTitle()).append(" ").append(String.valueOf(each.amount())).append("<br/>");

      }

      result.append("Amount owed is <b>").append(String.valueOf(totalAmount)).append("</b><br/>");
      result.append("You earned <b>").append(String.valueOf(frequentRenterPoints)).append("</b> frequent renter points");

      return result.toString();
    }
  }
}

