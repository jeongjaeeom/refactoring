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

  int getFrequentRenterPoints(int daysRented) {
    // 최신물을 이틀 이상 대여하면 2포인트 지급하고 그 외엔 1포인트 지급하는 코드를
    // 빼내 getFrequentRenterPoints 메서드로 만들고 이 rental 클래스로 옮겼다.
    if ((getPriceCode() == NEW_RELEASE && daysRented > 1)) {
      return 2;
    }
    return 1;
  }

  public double getCharge(int daysRented) {
    return price.getCharge(daysRented);
  }
}
