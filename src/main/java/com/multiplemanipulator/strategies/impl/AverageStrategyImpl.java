package com.multiplemanipulator.strategies.impl;

import com.multiplemanipulator.strategies.DoubleStrategy;
import java.util.List;

public class AverageStrategyImpl implements DoubleStrategy {

  @Override
  public double compute(List<Integer> numbers) {
    long sum = 0;
    for (int number : numbers) {
      sum += number;
    }
    return (double) sum / numbers.size();
  }
}
