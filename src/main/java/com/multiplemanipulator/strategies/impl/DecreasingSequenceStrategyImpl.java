package com.multiplemanipulator.strategies.impl;

import com.multiplemanipulator.strategies.SequenceStrategy;
import java.util.ArrayList;
import java.util.List;

public class DecreasingSequenceStrategyImpl implements SequenceStrategy {

  @Override
  public List<Integer> compute(List<Integer> numbers) {
    List<Integer> longestSequence = new ArrayList<>();
    List<Integer> currentSequence = new ArrayList<>();
    for (int number : numbers) {
      if (currentSequence.isEmpty() || number < currentSequence.get(currentSequence.size() - 1)) {
        currentSequence.add(number);
      } else {
        if (currentSequence.size() > longestSequence.size()) {
          longestSequence.clear();
          longestSequence.addAll(currentSequence);
        }
        currentSequence.clear();
        currentSequence.add(number);
      }
    }
    if (currentSequence.size() > longestSequence.size()) {
      longestSequence = currentSequence;
    }
    return longestSequence;
  }
}
