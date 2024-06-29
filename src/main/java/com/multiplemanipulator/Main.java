package com.multiplemanipulator;

import com.multiplemanipulator.strategies.DoubleStrategy;
import com.multiplemanipulator.strategies.IntegerStrategy;
import com.multiplemanipulator.strategies.SequenceStrategy;
import com.multiplemanipulator.strategies.impl.AverageStrategyImpl;
import com.multiplemanipulator.strategies.impl.DecreasingSequenceStrategyImpl;
import com.multiplemanipulator.strategies.impl.MaxIntegerStrategyImpl;
import com.multiplemanipulator.strategies.impl.MedianStrategyImpl;
import com.multiplemanipulator.strategies.impl.MinIntegerStrategyImpl;
import com.multiplemanipulator.strategies.impl.IncreasingSequenceStrategyImpl;
import java.util.List;

public class Main {
  private static IntegerStrategy integerStrategy;
  private static DoubleStrategy doubleStrategy;
  private static SequenceStrategy sequenceStrategy;

  public static void main(String[] args) {
    FileReader fileReader = new FileReader();
    List<Integer> numbers = fileReader.readIntegersFromResourceFile("/10m.txt");
    try {

      long startTime = System.currentTimeMillis();

      int max = findMax(numbers);
      int min = findMin(numbers);
      double average = calculateAverage(numbers);
      List<Integer> longestIncreasingSequence = findLongestIncreasingSequence(numbers);
      List<Integer> longestDecreasingSequence = findLongestDecreasingSequence(numbers);
      double median = calculateMedian(numbers);

      long endTime = System.currentTimeMillis();
      long executionTime = endTime - startTime;

      printResult("Максимальне число: ", max);
      printResult("Мінімальне число: ", min);
      printResult("Медіана: ", median);
      printResult("Середнє арифметичне: ", average);
      printResult("Найбільша послідовність, що зростає: ", longestIncreasingSequence);
      printResult("Найбільша послідовність, що спадає: ", longestDecreasingSequence);

      System.out.println("Час виконання: " + executionTime + " мс");

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private static void printResult(String text, Number variable) {
    System.out.println(text + variable);
  }

  private static void printResult(String text, List<Integer> variable) {
    System.out.println(text + variable);
  }

  // Знаходження максимального числа
  private static int findMax(List<Integer> numbers) {
    integerStrategy = new MaxIntegerStrategyImpl();
    return integerStrategy.compute(numbers);
  }

  // Знаходження мінімального числа
  private static int findMin(List<Integer> numbers) {
    integerStrategy = new MinIntegerStrategyImpl();
    return integerStrategy.compute(numbers);
  }

  // Обчислення медіани
  private static double calculateMedian(List<Integer> numbers) {
    doubleStrategy = new MedianStrategyImpl();
    return doubleStrategy.compute(numbers);
  }

  // Обчислення середнього арифметичного
  private static double calculateAverage(List<Integer> numbers) {
    doubleStrategy = new AverageStrategyImpl();
    return doubleStrategy.compute(numbers);
  }

  // Знаходження найбільшої послідовності, що зростає
  private static List<Integer> findLongestIncreasingSequence(List<Integer> numbers) {
    sequenceStrategy = new IncreasingSequenceStrategyImpl();
    return sequenceStrategy.compute(numbers);
  }

  // Знаходження найбільшої послідовності, що спадає
  private static List<Integer> findLongestDecreasingSequence(List<Integer> numbers) {
    sequenceStrategy = new DecreasingSequenceStrategyImpl();
    return sequenceStrategy.compute(numbers);
  }

}