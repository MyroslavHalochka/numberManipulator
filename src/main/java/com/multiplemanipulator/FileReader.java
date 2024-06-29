package com.multiplemanipulator;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {
  // Читання змісту файла
  public List<Integer> readIntegersFromResourceFile(String fileName) {
    List<Integer> integers = new ArrayList<>();

    // Отримуємо InputStream для файлу у ресурсах
    InputStream inputStream = Main.class.getResourceAsStream(fileName);

    if (inputStream != null) {
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
        integers = reader.lines()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return integers;
  }
}
