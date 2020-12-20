package com.example.refactoring;

public class VideoRentalStoreApplication {

  public static void main(String[] args) {
    Customer teddy = new Customer("teddy");

    Movie thor = new Movie("Thor", Movie.REGULAR);
    Movie blackPanther = new Movie("Black Panther", Movie.NEW_RELEASE);

    Rental rentalThor = new Rental(thor, 3);
    Rental rentalBlackPanther = new Rental(blackPanther, 2);

    teddy.addRental(rentalThor);
    teddy.addRental(rentalBlackPanther);

    String result = teddy.statement();
    System.out.println(result);
  }

}
