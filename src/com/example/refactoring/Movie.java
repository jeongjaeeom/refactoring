package com.example.refactoring;

public class Movie {

  public static final int CHILDREN = 2;
  public static final int REGULAR = 0;
  public static final int NEW_RELEASE = 1;
  private String title;
  Price price;

  public Movie(String title, int priceCode) {
    this.title = title;
    setPriceCode(priceCode);
  }

  public void setPriceCode(int priceCode) {
    switch (priceCode) {
      case REGULAR:
        price = new RegularPrice();
        break;
      case CHILDREN:
        price = new ChildrenPrice();
        break;
      case NEW_RELEASE:
        price = new NewReleasePrice();
        break;
      default:
        throw new IllegalArgumentException("가격 코드가 잘못됐습니다.");
    }
  }

  public String getTitle() {
    return title;
  }

  public int getPriceCode() {
    return price.getPriceCode();
  }

  public double getCharge(int daysRented) {
    return price.getCharge(daysRented);
  }

  public int getFrequentRenterPoints(int daysRented) {
    return price.getFrequentRenterPoints(daysRented);
  }
}
