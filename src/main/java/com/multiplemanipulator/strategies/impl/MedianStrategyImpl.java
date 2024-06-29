package com.multiplemanipulator.strategies.impl;

import com.multiplemanipulator.strategies.DoubleStrategy;
import java.util.Collections;
import java.util.List;

public class MedianStrategyImpl implements DoubleStrategy {

  @Override
  public double compute(List<Integer> numbers) {
    Collections.sort(numbers);
    int middle = numbers.size() / 2;
    if (numbers.size() % 2 == 0) {
      return (numbers.get(middle - 1) + numbers.get(middle)) / 2.0;
    } else {
      return numbers.get(middle);
    }
  }
}
