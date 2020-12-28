package com.example.refactoring;

public class ChildrenPrice extends Price {

  @Override
  int getPriceCode() {
    return Movie.CHILDREN;
  }
}
