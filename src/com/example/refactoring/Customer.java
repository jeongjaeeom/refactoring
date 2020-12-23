package com.example.refactoring;

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
    double totalAmount = 0;
    int frequentRenterPoints = 0;
    String result = getName() + " 고객님의 대여 기록\n";

    for (Rental each : rentals) {
      // 적립포인트를 1 포인트 증가
      frequentRenterPoints++;
      // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
      if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1)) {
        frequentRenterPoints++;
      }

      // 이번에 대여하는 비디오 정보와 대여료를 출력
      result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
      // 현재까지 누적된 총 대여료
      totalAmount += each.getCharge();
    }

    // 푸터 행 추가
    result += "누적 대여료: " + totalAmount + "\n";
    result += "적립 포인트: " + frequentRenterPoints + "\n";
    return result;
  }

}
