package com.multiplemanipulator.strategies.impl;

import com.multiplemanipulator.strategies.IntegerStrategy;
import java.util.List;

public class MinIntegerStrategyImpl implements IntegerStrategy {

  @Override
  public int compute(List<Integer> numbers) {
    int min = Integer.MAX_VALUE;
    for (int number : numbers) {
      if (number < min) {
        min = number;
      }
    }
    return min;
  }

}
