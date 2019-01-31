package com.thoughtworks.movierental;

class HtmlStatement {
  public String display(String name, Rentals rentalsObj) {
    StringBuilder result = new StringBuilder("<h1>Rental Record for <b>" + name + "</b></h1><br/>");

    for (Rental each : rentalsObj) {
      //show figures for this rental
      result.append(" ").append(each.getMovie().getTitle()).append(" ").append(String.valueOf(each.amount())).append("<br/>");

    }

    result.append("Amount owed is <b>").append(String.valueOf(rentalsObj.totalAmount())).append("</b><br/>");
    result.append("You earned <b>").append(String.valueOf(rentalsObj.frequentRenterPoints())).append("</b> frequent renter points");

    return result.toString();
  }
}
