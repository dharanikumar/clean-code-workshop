package com.thoughtworks.movierental;

class TextStatement {

  public String display(String name, Rentals rentalsObj) {
    StringBuilder result = new StringBuilder("Rental Record for " + name + "\n");

    for (Rental each : rentalsObj) {
      //show figures for this rental
      result.append("\t").append(each.getMovie().getTitle()).append("\t").append(String.valueOf(each.amount())).append("\n");

    }

    result.append("Amount owed is ").append(String.valueOf(rentalsObj.totalAmount())).append("\n");
    result.append("You earned ").append(String.valueOf(rentalsObj.frequentRenterPoints())).append(" frequent renter points");

    return result.toString();
  }
}
