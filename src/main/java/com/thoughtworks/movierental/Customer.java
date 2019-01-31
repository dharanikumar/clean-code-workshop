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

    return new TextStatement().display(getName(),new Rentals(rentals));
  }


  public String htmlStatement(){
    return new HtmlStatement().display(getName(),new Rentals(rentals));
  }

  private class HtmlStatement {
    public String display(String name, Rentals rentalsObj) {
      StringBuilder result = new StringBuilder("<h1>Rental Record for <b>" + name + "</b></h1><br/>");

      for (Rental each : rentalsObj.rentals) {
        //show figures for this rental
        result.append(" ").append(each.getMovie().getTitle()).append(" ").append(String.valueOf(each.amount())).append("<br/>");

      }

      result.append("Amount owed is <b>").append(String.valueOf(rentalsObj.totalAmount())).append("</b><br/>");
      result.append("You earned <b>").append(String.valueOf(rentalsObj.frequentRenterPoints())).append("</b> frequent renter points");

      return result.toString();
    }
  }


  private class TextStatement {
    public String display(String name, Rentals rentalsObj) {
      StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

      for (Rental each : rentalsObj.rentals) {
        //show figures for this rental
        result.append("\t").append(each.getMovie().getTitle()).append("\t").append(String.valueOf(each.amount())).append("\n");

      }

      result.append("Amount owed is ").append(String.valueOf(rentalsObj.totalAmount())).append("\n");
      result.append("You earned ").append(String.valueOf(rentalsObj.frequentRenterPoints())).append(" frequent renter points");

      return result.toString();
    }
  }
}

