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
    String result = getName() + " 고객님의 대여 기록\n";

    for (Rental each : rentals) {
      // 이번에 대여하는 비디오 정보와 대여료를 출력
      result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
    }

    // 푸터 행 추가
    result += "누적 대여료: " + getTotalCharge() + "\n";
    result += "적립 포인트: " + getTotalFrequentRenterPoints() + "\n";
    return result;
  }

  private double getTotalCharge() {
    double result = 0;
    for (Rental each : rentals) {
      result += each.getCharge();
    }
    return result;
  }

  private int getTotalFrequentRenterPoints() {
    int result = 0;
    for (Rental each : rentals) {
      result += each.getFrequentRenterPoints();
    }
    return result;
  }

}
