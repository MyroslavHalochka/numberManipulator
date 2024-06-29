package com.multiplemanipulator.strategies.impl;

import com.multiplemanipulator.strategies.IntegerStrategy;
import java.util.List;

public class MaxIntegerStrategyImpl implements IntegerStrategy {

  @Override
  public int compute(List<Integer> numbers) {
    int max = Integer.MIN_VALUE;
    for (int number : numbers) {
      if (number > max) {
        max = number;
      }
    }
    return max;
  }
}
