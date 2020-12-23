package com.example.refactoring;

public class Movie {

  public static final int CHILDREN = 2;
  public static final int REGULAR = 0;
  public static final int NEW_RELEASE = 1;
  private String title;
  private int priceCode;

  public Movie(String title, int priceCode) {
    this.title = title;
    this.priceCode = priceCode;
  }

  public void setPriceCode(int priceCode) {
    this.priceCode = priceCode;
  }

  public String getTitle() {
    return title;
  }

  public int getPriceCode() {
    return priceCode;
  }

  double getCharge(int daysRented) {
    double result = 0;
    switch (getPriceCode()) {
      case REGULAR:
        result += 2;
        if (daysRented > 2) {
          result += (daysRented - 2) * 1.5;
        }
        break;
      case NEW_RELEASE:
        result += daysRented * 3;
        break;
      case CHILDREN:
        result += 1.5;
        if (daysRented > 3) {
          result += (daysRented - 3) * 1.5;
        }
        break;
    }
    return result;
  }

  int getFrequentRenterPoints(int daysRented) {
    // 최신물을 이틀 이상 대여하면 2포인트 지급하고 그 외엔 1포인트 지급하는 코드를
    // 빼내 getFrequentRenterPoints 메서드로 만들고 이 rental 클래스로 옮겼다.
    if ((getPriceCode() == NEW_RELEASE && daysRented > 1)) {
      return 2;
    }
    return 1;
  }
}
