package com.thoughtworks.movierental;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void testCustomerStatement(){
        Customer customerBob = new Customer("Bob");

        Movie sampleMovie =  new Movie("Sample Movie",Movie.REGULAR);
        testMovie(sampleMovie);
        Movie testMovie =  new Movie("Test Movie",Movie.NEW_RELEASE);
        testMovie(testMovie);

        Rental sampleRent = new Rental(sampleMovie,4);
        testRent(sampleRent);
        Rental testRent = new Rental(testMovie,6);
        testRent(testRent);

        customerBob.addRental(sampleRent);
        customerBob.addRental(testRent);
        testCustomer(customerBob);
    }

    //Testing Rental details
    private void testRent(Rental rental) {
        assert (rental.getMovie()!=null): "Rent not associated with any movie";
        assert (rental.getDaysRented()>0): "Rental days should be a positive number";
    }

    //Testing Movie details
    private void testMovie(Movie movie) {
        assert (movie.getTitle()!=null && movie.getTitle().length()>0): "Movie doesn't have title";
        assert (movie.getPriceCode() == Movie.NEW_RELEASE || movie.getPriceCode() == Movie.REGULAR || movie.getPriceCode() == Movie.CHILDRENS): "Movie doesn't have priceCode";
    }


    //Testing customer details
    private void testCustomer(Customer customer){
        assert (customer.getName().length() > 0):"Customer doesn't have name";
        Assert.assertEquals("Rental Record for Bob\n" +
                "\tSample Movie\t5.0\n" +
                "\tTest Movie\t18.0\n" +
                "Amount owed is 23.0\n" +
                "You earned 3 frequent renter points",customer.statement());
    }

}